
// Definition for a Singly-Linked List
/*************************************/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
/*************************************/

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        // edge cases
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {  //[1,2] pos = -1
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);

		/*Create non-loop for testing */
		head.next.next = null;

		/*Create loop for testing */
		head.next.next = head;

		LinkedListCycle solution = new LinkedListCycle();
		boolean res = solution.hasCycle(head);
		System.out.println(res);
	}
}

// Two pointers method
// Time: O(n), n is the total number of nodes in the linked list.
	// Consider two cases separately: (1) List has no cycle; (2) List has a cycle
	
// Space: O(1) only use two nodes (slow and fast)