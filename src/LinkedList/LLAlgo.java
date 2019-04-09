package LinkedList;

public class LLAlgo {

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, succ = null;
        while (head != null) {
            succ = head.next;
            head.next = prev;
            prev = head;
            head = succ;
        }
        return prev;
    }

    public static ListNode mergeTwoOrderedLL(ListNode p, ListNode q) {
        ListNode dummy = new ListNode();

        ListNode temp = dummy;
        while (p != null && q != null) {
            if (p.compare(q) < 0) {
                temp.next = p;
                p = p.next;
            } else {
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }

        temp.next = p == null ? q : p;
        return dummy.next;
    }

    public static ListNode findMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
