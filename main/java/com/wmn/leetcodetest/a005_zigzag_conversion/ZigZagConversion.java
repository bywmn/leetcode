package com.wmn.leetcodetest.a005_zigzag_conversion;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时
 * 你的输出需要从左往右逐行读取，产生出一个新的字符串"PAHNAPLSIIGYIR"
 *
 * @author WMN
 * @since 2021-03-18
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }

    /**
     * Z字形走，先往下走，到头了再往前走，设个标志位控制方向，到达顶点换方向
     *
     * @param s 输入字符串
     * @param numRows 行数
     * @return 返回转换后的结果
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int isDown = 1;
        char[] chars = s.toCharArray();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        int currentRowIndex = 0;
        while (index < chars.length) {
            stringBuilders[currentRowIndex].append(chars[index]);
            currentRowIndex += isDown;
            // 到达起点/末尾
            if (currentRowIndex == 0 || currentRowIndex == numRows - 1) {
                isDown *= -1;
            }
            index++;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : stringBuilders) {
            result.append(sb);
        }
        return result.toString();
    }
}
