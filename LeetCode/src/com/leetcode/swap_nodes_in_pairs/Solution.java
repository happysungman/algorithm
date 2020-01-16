package com.leetcode.swap_nodes_in_pairs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode nextOperationNode = head.next.next;
		head.next.next = head;
		ListNode changedHead = head.next;
		head.next = swapPairs(nextOperationNode);
		return changedHead;
	}

	@Test
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode swappedHead = swapPairs(node1);
		assertEquals(node2, swappedHead);
		assertEquals(node1, swappedHead.next);
		assertEquals(node4, swappedHead.next.next);
		assertEquals(node3, swappedHead.next.next.next);
	}
}
