package com.sunjinwei.linkedlist;

import com.sunjinwei.domain.ListNode;

/**
 * 判断链表是否是循环链表
 * 思路：使用快慢指针
 * 有两种写法
 */
public class Is_Loop {

    /**
     * 快慢指针写法1：初始时 快慢在同一个位置
     *
     * @param head
     * @return
     */
    public boolean isLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针写法2: 初始时 快指针先走一步
     *
     * @param head
     * @return
     */
    public boolean isLoop2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
