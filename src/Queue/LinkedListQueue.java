package Queue;


import LinkedList.ListNode;

public class LinkedListQueue implements MyQueue {

    private int      size;
    private ListNode dummy;
    private ListNode tail;

    public LinkedListQueue() {
        this.size = 0;
        this.dummy = new ListNode();
        this.tail  = new ListNode();
    }

    @Override
    public boolean offer(Object o) {
        if (empty()) {
            dummy.next = new ListNode(o);
            tail.next  = dummy.next;
            size++;
            return true;
        }
        ListNode temp = new ListNode(o);
        temp.next = tail.next;
        tail.next.prev = temp;
        tail.next = temp;
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if (empty()) return null;
        ListNode head = dummy.next;
        dummy.next    = head.prev;
        size--;
        return head.val;
    }

    @Override
    public Object peek() {
        if (empty()) return null;
        return dummy.next.val;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return null;
        StringBuilder buf = new StringBuilder();
        ListNode temp = dummy.next;
        for (int i = 0; i < size; i++) {
            buf.append("->");
            buf.append(temp.val);
            temp = temp.prev;
        }
        return buf.substring(2);
    }
}
