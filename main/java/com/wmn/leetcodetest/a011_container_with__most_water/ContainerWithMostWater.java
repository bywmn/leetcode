package com.wmn.leetcodetest.a011_container_with__most_water;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-20
 */
public class ContainerWithMostWater {
    /**
     * 双指针法，因为Smax = (Aj - Ai) * min(hj, hi);
     * S初始值为S(0-n),所以当j-i减小时（指针向中间缩小）,若要存在最大值，则要min(hj, hi) > min (h[0],h[n])
     * 即短板内移，高度相同时均向内移动
     *
     * @param height 高度数组
     * @return 最大值
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int max = Math.min(height[length - 1], height[0]) * (length - 1);
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return max;
    }

    /**
     * 简单优化
     */
    public int maxArea1(int[] height) {
        int length = height.length;
        int max = Math.min(height[length - 1], height[0]) * (length - 1);
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
            if (height[start] < height[end]) {
                int hi = height[start];
                while (start <= end) {
                    if (height[start] <= hi) {
                        start++;
                    }else {
                        break;
                    }
                }
            } else {
                int hj = height[end];
                while (start <= end) {
                    if (height[end] <= hj) {
                        end--;
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
