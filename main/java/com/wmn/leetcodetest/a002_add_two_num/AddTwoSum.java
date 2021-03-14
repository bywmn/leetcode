package com.wmn.leetcodetest.a002_add_two_num;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WMN
 * @since 2021-03-14
 */
public class AddTwoSum {

    public static void main(String[] args) {
        ListNode l1 = createNode(new int[]{0});
        ListNode l2 = createNode(new int[]{5,6});
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    /**
     * 使用l1作为基准，进行相加（正常开发不应该改变入参，此处为减小使用空间）
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表之和
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultL1 = null;
        ListNode pNodeL1 = l1;
        ListNode pNodeL2 = l2;
        int carry = 0; // 进位
        while (pNodeL1 != null && pNodeL2 != null) {
            if (resultL1 == null) {
                resultL1 = pNodeL1;
            } else {
                resultL1.next = pNodeL1;
                resultL1 = resultL1.next;
            }
            int sum = pNodeL1.val + pNodeL2.val + carry;
            resultL1.val = sum% 10;
            carry = sum / 10;
            pNodeL1 = pNodeL1.next;
            pNodeL2 = pNodeL2.next;
        }
        // 转变为单链表 + carry
        if (pNodeL1 == null) {
            pNodeL1 = pNodeL2;
        }
        resultL1.next = pNodeL1;
        while (carry != 0) {
            if (pNodeL1 == null) {
                resultL1.next = new ListNode(carry);
                return l1;
            }
            resultL1.next = pNodeL1;
            resultL1 = resultL1.next;
            int sum = pNodeL1.val + carry;
            resultL1.val = sum % 10;
            carry = sum / 10;
            pNodeL1 = pNodeL1.next;
        }
        return l1;
    }

    static ListNode createNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode node = null;
        ListNode head = null;
        for (int num : nums) {
            if (node == null) {
                node = new ListNode(num);
                head = node;
                continue;
            }
            node.next = new ListNode(num);
            node = node.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "," + next.toString();
            }
            return val + "";
        }
    }

}
