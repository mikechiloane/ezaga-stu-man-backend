package co.za.faboda.ezagastumanbackend.util;

import java.util.Random;

public class StudentNumberGenerator {

    public static void main(String[] args) {
        String studentNumber = generateStudentNumber();
        System.out.println("Generated Student Number: " + studentNumber);
    }

    public static String generateStudentNumber() {
        String prefix = "EZX";
        String randomDigits = generateRandomDigits(4);
        return prefix + randomDigits;
    }

    public static String generateRandomDigits(int numberOfDigits) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfDigits; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}
