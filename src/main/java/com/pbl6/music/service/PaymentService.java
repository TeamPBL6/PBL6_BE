    package com.pbl6.music.service;

    import com.pbl6.music.config.VNPayConfig;
    import com.pbl6.music.dto.response.MusicResponseDTO;
    import com.pbl6.music.util.AppException;
    import com.pbl6.music.util.ErrorCode;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;

    import javax.crypto.Mac;
    import javax.crypto.spec.SecretKeySpec;
    import java.math.BigDecimal;
    import java.text.SimpleDateFormat;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Calendar;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.TimeZone;


    @Service
    public class PaymentService {

        @Autowired
        private MusicService musicService;

        @Value("${vnpay.tmnCode}")
        private String vnp_TmnCode;

        @Value("${vnpay.hashSecret}")
        private String vnp_HashSecret;

        @Value("${vnpay.payUrl}")
        private String vnp_PayUrl;

        public String createPaymentUrl(Long musicId) throws Exception {
            MusicResponseDTO music = musicService.getById(musicId);
            if (music == null) {
                throw new AppException(ErrorCode.MUSIC_NOT_FOUND);
            }

            // Các tham số VNPay
            String vnp_Version = "2.1.0";
            String vnp_Command = "pay";
            String vnp_TxnRef = String.valueOf(System.currentTimeMillis());
            String vnp_IpAddr = "127.0.0.1"; // Có thể sử dụng getIpAddress(request) nếu cần
            String vnp_OrderInfo = "Payment for music: " + music.getTitle();
            long amount = music.getPrice().multiply(BigDecimal.valueOf(1000)).longValue();
            String vnp_Amount = String.valueOf(amount);
            String vnp_Locale = "vn";
            String vnp_CurrCode = "VND";
            String vnp_OrderType = "other";
            String vnp_ReturnUrl = "http://localhost:8181/payment/vnpay-return";

            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());

            // Tạo danh sách tham số
            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", vnp_Amount);
            vnp_Params.put("vnp_CurrCode", vnp_CurrCode);
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
            vnp_Params.put("vnp_OrderType", vnp_OrderType);
            vnp_Params.put("vnp_Locale", vnp_Locale);
            vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            // Tạo chuỗi ký kết
            String signData = VNPayConfig.hashAllFields(vnp_Params);
            String vnp_SecureHash = VNPayConfig.hmacSHA512(vnp_HashSecret, signData);

            // Tạo URL thanh toán
            StringBuilder queryBuilder = new StringBuilder(vnp_PayUrl);
            queryBuilder.append("?").append(signData).append("&vnp_SecureHash=").append(vnp_SecureHash);

// Đảm bảo không có dấu ngoặc kép ở đây
            return queryBuilder.toString().replace("\"", "");
        }
    }
