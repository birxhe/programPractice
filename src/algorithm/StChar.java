package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StChar {

    public static Map<Integer, Integer> countChar(String str) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(0, 0);// Ӣ����ĸ
        m.put(1, 0);// �ո�
        m.put(2, 0);// ����
        m.put(3, 0);// �����Ը�
        for (Character c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                m.put(0, m.get(0) + 1);
            } else if (Character.isWhitespace(c)) {
                m.put(1, m.get(1) + 1);
            } else if (Character.isDigit(c)) {
                m.put(2, m.get(2) + 1);
            } else {
                m.put(3, m.get(3) + 1);
            }
        }
        return m;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ���ַ���");
        String str = scanner.nextLine();
        scanner.close();

        Map<Integer, Integer> m = countChar(str);

        System.out.println("Ӣ�ģ�" + m.get(0));
        System.out.println("�ո�" + m.get(1));
        System.out.println("���֣�" + m.get(2));
        System.out.println("�����ַ���" + m.get(3));
    }
}
