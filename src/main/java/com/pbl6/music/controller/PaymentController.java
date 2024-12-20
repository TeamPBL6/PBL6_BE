package com.pbl6.music.controller;

import com.pbl6.music.dto.request.PaymentRequest;
import com.pbl6.music.entity.BalanceUpdateType;
import com.pbl6.music.entity.TransactionHistory;
import com.pbl6.music.entity.TransactionStatus;
import com.pbl6.music.repository.TransactionRepository;
import com.pbl6.music.service.PaymentService;
import com.pbl6.music.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/create-payment")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest request,
                                                @RequestHeader("Authorization") String token) {
        try {
            // Tạo mã giao dịch một lần và sử dụng lại
            String transactionRef = UUID.randomUUID().toString();

            // Lưu thông tin giao dịch vào database
            TransactionHistory transaction = new TransactionHistory();
            transaction.setWalletId(request.getWalletId());
            transaction.setAmount(request.getAmount());
            transaction.setStatus(TransactionStatus.PENDING);
            transaction.setTransactionRef(transactionRef); // Sử dụng mã vừa tạo
            transactionRepository.save(transaction);

            // Tạo URL thanh toán
            request.setTransactionRef(transactionRef); // Giả sử PaymentRequest có phương thức setTransactionRef
            String paymentUrl = paymentService.createPaymentUrl(request);
            return ResponseEntity.ok(paymentUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không thể tạo giao dịch: " + e.getMessage());
        }
    }


    @GetMapping("/payment-callback")
    public ResponseEntity<String> paymentCallback(@RequestParam Map<String, String> queryParams) {
        String vnp_ResponseCode = queryParams.get("vnp_ResponseCode");
        String vnp_TxnRef = queryParams.get("vnp_TxnRef");
        String vnp_Amount = queryParams.get("vnp_Amount");

        // Tìm giao dịch trong database
        TransactionHistory transaction = transactionRepository.findByTransactionRef(vnp_TxnRef);
        System.out.println("vnp_TxnRef: " + vnp_TxnRef);
        if (transaction == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy giao dịch");
        }

        if ("00".equals(vnp_ResponseCode)) {
            // Giao dịch thành công
            transaction.setStatus(TransactionStatus.SUCCESS);
            transactionRepository.save(transaction);

            try {
                // Cập nhật số xu trong ví
                walletService.updateBalance(
                        Long.valueOf(transaction.getWalletId()),
                        transaction.getAmount(),
                        BalanceUpdateType.DEPOSIT
                );
                return ResponseEntity.ok("Giao dịch thành công");
            } catch (Exception e) {
                transaction.setStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                return ResponseEntity.badRequest().body("Lỗi khi cập nhật ví: " + e.getMessage());
            }
        } else {
            // Giao dịch thất bại
            transaction.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            return ResponseEntity.badRequest().body("Giao dịch thất bại");
        }
    }
}