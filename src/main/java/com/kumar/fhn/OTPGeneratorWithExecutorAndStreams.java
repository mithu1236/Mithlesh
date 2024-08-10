package com.kumar.fhn;
import java.security.SecureRandom;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OTPGeneratorWithExecutorAndStreams {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            // Submit the OTP generation task to the executor
            Future<String> otpFuture = executor.submit(new OTPTask(6));

            // Get the result of the OTP generation
            String otp = otpFuture.get();
            System.out.println("Your OTP is: " + otp);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred while generating OTP: " + e.getMessage());
        } /*finally {
            // Shutdown the executor service
            executor.shutdown();
        }*/
    }

    // Callable task to generate OTP
    public static class OTPTask implements Callable<String> {
        private final int length;

        public OTPTask(int length) {
            this.length = length;
        }

        @Override
        public String call() throws Exception {
            return generateOTP(length);
        }

        private String generateOTP(int length) throws Exception {
            if (length <= 0) {
                throw new IllegalArgumentException("OTP length must be greater than 0");
            }

            SecureRandom random = new SecureRandom();

            // Using Java 8 streams to generate the OTP
            return IntStream.range(0, length)
                    .mapToObj(i -> String.valueOf(random.nextInt(10))) // Generate a digit between 0 and 9
                    .collect(Collectors.joining());
        }
    }
}
