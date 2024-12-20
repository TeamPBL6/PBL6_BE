package com.pbl6.music.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Configuration
public class VNPayConfig {
//
//    @Value("${vnpay.payUrl}")
//    public static String vnp_PayUrl;
//
//    @Value("${vnpay.returnUrl}")
//    public static String vnp_ReturnUrl;
//
//    @Value("${vnpay.tmnCode}")
//    public static String vnp_TmnCode;
//
//    @Value("${vnpay.hashSecret}")
//    public static String vnp_HashSecret;
//
//    public static String hashAllFields(Map<String, String> fields) {
//        List<String> fieldNames = new ArrayList<>(fields.keySet());
//        Collections.sort(fieldNames);
//        StringBuilder sb = new StringBuilder();
//        for (String fieldName : fieldNames) {
//            String fieldValue = fields.get(fieldName);
//            if (fieldValue != null && !fieldValue.isEmpty()) {
//                sb.append(fieldName).append("=").append(fieldValue).append("&");
//            }
//        }
//        // Xóa dấu & cuối cùng
//        if (sb.length() > 0) {
//            sb.setLength(sb.length() - 1);
//        }
//        return sb.toString();
//    }
//
//    public static String hmacSHA512(final String key, final String data) {
//        try {
//            Mac hmac512 = Mac.getInstance("HmacSHA512");
//            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
//            hmac512.init(secretKey);
//            byte[] result = hmac512.doFinal(data.getBytes(StandardCharsets.UTF_8));
//            StringBuilder sb = new StringBuilder(2 * result.length);
//            for (byte b : result) {
//                sb.append(String.format("%02x", b & 0xff));
//            }
//            return sb.toString();
//        } catch (Exception ex) {
//            throw new RuntimeException("HMAC SHA512 error", ex);
//        }
//    }
@Value("${vnpay.tmnCode}")
private String tmnCode;

    @Value("${vnpay.hashSecret}")
    private String hashSecret;

    @Value("${vnpay.return-url}")
    private String returnUrl;

    @Value("${vnpay.payUrl}")
    private String payUrl;

    public String getTmnCode() {
        return tmnCode;
    }

    public String getHashSecret() {
        return hashSecret;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }
}
