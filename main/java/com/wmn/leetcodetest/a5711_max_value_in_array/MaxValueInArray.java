package com.wmn.leetcodetest.a5711_max_value_in_array;

/**
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 * <p>
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-value-at-a-given-index-in-a-bounded-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-21
 */
public class MaxValueInArray {
    public static void main(String[] args) {
        System.out.println(new MaxValueInArray().maxValue(6, 2, 931384943));
    }

    /**
     * 正确题解 二分法
     */
    public int maxValue(int n, int index, int maxSum) {
        if (maxSum < n) {
            return 0;
        }
        int res = 0;
        int left = 1;
        int right = maxSum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getSum(n, index, mid) == maxSum) {
                return mid;
            }
            if (getSum(n, index, mid) < maxSum) {
                res = mid;
                left = mid + 1;
            } else {
                res = mid - 1;
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 需要定义为long,否则在用例6, 2,931384943中无法跑过
     */
    private long getSum(int n, int index, long height) {
        long sum = 0;
        // 计算左侧总和 0-index
        if (height >= index + 1) {
            // height大于左边项数时,即第一项值不等于1时
            sum += (height - index + height) * (index + 1) / 2;
        } else {
            sum += (1 + height) * height / 2 + index + 1 - height;
        }
        // 计算右侧总和 index + 1 - n
        if (height - 1 >= n - 1 - index) {
            sum += (height - (n - 1 - index) + (height - 1)) * (n - 1 - index) / 2;
        } else {
            sum += (1 + (height - 1)) * (height - 1) / 2 + (n - 1 - index) - (height - 1);
        }
        return sum;
    }

    /**
     * 超时，不一定正确
     */
    public int maxValue1(int n, int index, int maxSum) {
        int res = 0;
        for (int max = maxSum / n; max <= maxSum - n + 1; max++) {
            // 当i为最大值时
            int sum = 0;
            int temp = 0;
            for (int i = index; i >= 0; i--) {
                if (max - temp >= 1) {
                    sum += max - temp;
                    temp++;
                } else {
                    sum += 1;
                }
            }
            temp = 1;
            for (int i = index + 1; i <= n - 1; i++) {
                if (max - temp >= 1) {
                    sum += max - temp;
                    temp++;
                } else {
                    sum += 1;
                }
            }
            if (sum <= maxSum) {
                res = Math.max(res, max);
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 超时，不一定正确
     */
    public int maxValue2(int n, int index, int maxSum) {
        int res = 0;
        for (int max = maxSum - n + 1; max >= maxSum / n; max--) {
            // 当i为最大值时
            int sum = 0;
            int temp = 0;
            for (int i = index; i >= 0; i--) {
                if (max - temp >= 1) {
                    sum += max - temp;
                    temp++;
                } else {
                    sum += 1;
                }
                if (sum > maxSum) {
                    break;
                }
            }
            if (sum > maxSum) {
                continue;
            }
            temp = 1;
            for (int i = index + 1; i <= n - 1; i++) {
                if (max - temp >= 1) {
                    sum += max - temp;
                    temp++;
                } else {
                    sum += 1;
                }
                if (sum > maxSum) {
                    break;
                }
            }
            if (sum <= maxSum) {
                return max;
            }
        }
        return res;
    }

    /**
     * 超时，不一定正确
     */
    public int maxValue3(int n, int index, int maxSum) {
        if (maxSum < n) {
            return 0;
        }
        if (index < n / 2) {
            index = n - 1 - index;
        }
        int res = 0;
        // 当i为最大值时
        int sum = 0;
        int temp = 1;
        for (int i = 0; i <= index; i++) {
            sum += temp;
            temp++;
        }
        int height = index + 1;
        temp = height;
        for (int i = index + 1; i <= n - 1; i++) {
            if (temp > 1) {
                temp--;
            }
            sum += temp;
        }
        // 需要继续判断有没有更大的值
        while (sum <= maxSum) {
            height++;
            sum += n;
            if (sum > maxSum) {
                break;
            }
        }
        while (height >= 1) {
            sum -= Math.min(height - 1, index + 1);
            sum -= Math.min(height - 1 - 1, n - 1 - index);
            height--;
            if (sum <= maxSum) {
                return height;
            }
        }
        return res;
    }
}
