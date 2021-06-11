package com.self.dsa.linkedlist;

class ListNode {
	
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
}

class DoubleNode {

	ListNode head;
	ListNode tail;
	boolean reverse;

	public DoubleNode(ListNode head, ListNode tail, boolean reverse) {
		this.head = head;
		this.tail = tail;
		this.reverse = reverse;
	}
}

public class ReverseKGroupInLinkedList {

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode pointer = head;

		DoubleNode reversed = null;
		DoubleNode reversedK = null;

		while (pointer != null) {
			reversedK = reverseK(pointer, k);
			System.out.println(reversedK.head.val + " -> .... ->" + reversedK.tail.val);

			pointer = reversedK.tail.next;

			if (reversed == null)
				reversed = reversedK;
			else {
				reversed.tail.next = reversedK.head;
				reversed.tail = reversedK.tail;
			}
			System.out.println(reversed.tail.val);
		}
		return reversed.head;
	}

	public DoubleNode reverseK(ListNode node, int k) {

		if (node == null)
			return new DoubleNode(null, null, false);

		if (k == 1)
			return new DoubleNode(node, node, true);

		DoubleNode smallHead = reverseK(node.next, k - 1);
		boolean reverse = smallHead == null || smallHead.reverse;

		if (reverse) {
			node.next = smallHead.tail.next;
			smallHead.tail.next = node;

			return new DoubleNode(smallHead.head, node, smallHead.reverse);
		} else {
			node.next = smallHead.head;

			return new DoubleNode(node, node, false);
		}

	}

}