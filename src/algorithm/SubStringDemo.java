package algorithm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStringDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        // Part1
        processStr1(str1);
        // Part2
        processStr2(str2);
    }

    public static void processStr1(String str) {
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

    public static void processStr2(String str) {
        String previous;
        do {
            previous = str;

            Pattern pattern = Pattern.compile("([a-z])\\1{2,}");
            Matcher matcher = pattern.matcher(str);

            StringBuffer sb = new StringBuffer();

            while (matcher.find()) {
                // 查找到分组中的第一个字符
                char matchedChar = matcher.group().charAt(0);
                // 当匹配字符为 'a' 时，替换为空字符串
                // 否则，替换为当前字母-1的字符
                if (matchedChar == 'a') {
                    matcher.appendReplacement(sb, "");
                } else {
                    char replaceChar = (char) (matchedChar - 1);
                    matcher.appendReplacement(sb, String.valueOf(replaceChar));
                }
            }
            matcher.appendTail(sb);
            str = sb.toString();

            if (!str.equals(previous)) {
                System.out.println("-> " + str);
            }
        } while (!str.equals(previous));
    }
}
