/**You are given two non-empty linked lists representing two non-negative integers. 
  *The digits are stored in reverse order and each of their nodes contain a single digit. 
  *Add the two numbers and return it as a linked list.*/
class AddTwoNumbers {

	public static class ListNode {
		int val;
		public ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode l1;
	public ListNode l2;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            
            int sum = l1.val + l2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        
            l1 = l1.next;
            l2 = l2.next;
        }
    // Check if carry = 1, if so append a new node with digit 11 to the returning list.
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
    	// Create two lists as inputs
    	ListNode head1 = new ListNode(2);
    	ListNode l1 = head1;
		l1.next = new ListNode(4);
		l1 = l1.next;
		l1.next = new ListNode(3);

    	ListNode head2 = new ListNode(5);
    	ListNode l2 = head2;
		l2.next = new ListNode(6);
		l2 = l2.next;
		l2.next = new ListNode(4);

		AddTwoNumbers solution = new AddTwoNumbers();
		ListNode res = solution.addTwoNumbers(head1,head2);

		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
    }
}

// Time: O(max(m, n)). Assume that m and n represents the length of l1 and l2 respectively, 
   //the algorithm above iterates at most max(m, n)max(m,n) times.

// Space: O(max(m,n)). The length of the new list is at most max(m,n)+1