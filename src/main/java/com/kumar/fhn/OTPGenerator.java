package com.kumar.fhn;

import java.security.SecureRandom;

public class OTPGenerator {
    public static void main(String[] args) {
        int otpLength = 6; // Length of the OTP
        String otp = generateOTP(otpLength);
        System.out.println("Your OTP is: " + otp);
    }

    public static String generateOTP(int length) {
        // SecureRandom provides a cryptographically strong random number generator
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random number between 0 and 9
            otp.append(digit);
        }

        return otp.toString();
    }
}