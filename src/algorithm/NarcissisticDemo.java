package algorithm;

import java.util.Scanner;

public class NarcissisticDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        if (a > 1000000 || b > 1000000) {
            System.out.println(0);
        } else {
            int count = 0;
            for (int num = a; num <= b; num++) {
                if (isNarcissistic(num)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isNarcissistic(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int powerSum = 0;
        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            powerSum += Math.pow(digit, n);
        }
        return num == powerSum;
    }
}
