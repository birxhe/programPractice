package algorithm;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SubStringDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        processStr(str);
    }

    public static void processStr(String str) {
        String previous;
        do {
            previous = str;
            // 通过正则表达式实现替换连续的字母（3个以上）
            str = str.replaceAll("([a-z])\\1{2,}", "");
            if (!str.equals(previous)) {
                System.out.println("-> " + str);
            }
        } while (!str.equals(previous));
    }
}
