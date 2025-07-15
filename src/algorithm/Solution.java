package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     *
     * @param num1 int����
     * @param num2 int����
     * @return int����һά����
     */
    public int[] number (int num1, int num2) {
        // write code here
        List<Integer> list = new ArrayList();
        for (int i = num1; i <= num2; i++) {
            // ��λ��
            int a = i / 100;
            // ʮλ��
            int b = (i / 10) % 10;
            // ��λ��
            int c = i % 10;
            if ((Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) == i) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.number(100, 999);
        for (int i=0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }
}
