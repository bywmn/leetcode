package com.wmn.leetcodetest.a008_String_2_integer;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-19
 */
public class StringToInteger_solution_state_machine {
    private static final int START = 0;

    private static final int SIGN = 1;

    private static final int NUM = 2;

    private static final int END = 3;

    public static void main(String[] args) {
        System.out.println(new StringToInteger_solution_state_machine().myAtoi("42"));
    }


    /**
     * 使用状态机进行求解
     * <p>
     * 状态转换表格
     * 输入： 空格  正\负号 数字 其他
     * start start  sign  num end
     * sign  end    end   num end
     * num   end    end   num end
     * end   end    end   end end
     * <p>
     * 转换成数组 new int[3][4] {
     * 0,1,2,3,
     * 3,3,2,3,
     * 3,3,3,3
     * }
     */
    public int myAtoi(String s) {
        int[][] stateChangeAns = new int[][]{
            {START, SIGN, NUM, END},
            {END, END, NUM, END},
            {END, END, NUM, END}
        };
        int sign = 1;
        long res = 0;
        int state = START;
        for (char ch : s.toCharArray()) {
            state = stateChangeAns[state][getCurrentStatr(ch)];
            System.out.println(state + "  ch:" + ch);
            switch (state) {
                case START:
                    break;
                case SIGN:
                    if (ch == '-') {
                        sign = -1;
                    }
                    break;
                case NUM:
                    res = res * 10 + sign * (ch - '0');
                    if (res >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (res <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    break;
                case END:
                    return (int) res;
            }
        }
        return (int) res;
    }

    private int getCurrentStatr(char ch) {
        if (ch == ' ') {
            return START; // start 状态
        }
        if (ch == '+' || ch == '-') {
            return SIGN; // sign 符号状态
        }
        if (Character.isDigit(ch)) {
            return NUM; // 数字状态
        }
        return END; // 结束
    }
}
