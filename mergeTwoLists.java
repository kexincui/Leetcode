import java.util.Arrays;

class mergeTwoLists {
	
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
	public mergeTwoLists(ListNode list1, ListNode list2) {
		l1 = list1;
		l2 = list2;
	}

    public ListNode merge_two_lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;      
    }

    public static void main(String[] args) {
    	
    	ListNode head1 = new ListNode(1);
    	ListNode l1 = head1;
		l1.next = new ListNode(2);
		l1 = l1.next;
		l1.next = new ListNode(4);

    	ListNode head2 = new ListNode(1);
    	ListNode l2 = head2;
		l2.next = new ListNode(3);
		l2 = l2.next;
		l2.next = new ListNode(4);


		mergeTwoLists solution = new mergeTwoLists(head1,head2);
		ListNode res = solution.merge_two_lists(head1,head2);

		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

    }
}