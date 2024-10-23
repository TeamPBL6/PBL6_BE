//package com.pbl6.music.controller;
//
//import com.pbl6.music.service.IPaymentService;
//import com.pbl6.music.exception.ApiException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/payment")
//public class PaymentController {
//
//    @Autowired
//    private IPaymentService paymentService;
//
//    @PostMapping("/create-vnpay-payment")
//    public ResponseEntity<Map<String, String>> createVnPayPayment(@RequestBody Map<String, Long> request) {
//        Long musicId = request.get("musicId");
//        try {
//            String paymentUrl = paymentService.createPaymentUrl(musicId);
//            return ResponseEntity.ok(Map.of("paymentUrl", paymentUrl));  // Chỉ trả về URL
//        } catch (ApiException e) {
//            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Map.of("error", "An unexpected error occurred: " + e.getMessage()));
//        }
//    }
//}
//
//
