package LinkedList;

import java.util.List;

public class CircularLinkedList {

    private ListNode dummyHead;
    private ListNode dummyTail;
    private int      size;
    private int      cap;

    public CircularLinkedList(int cap) {
        this.cap  = cap;
        this.size = 0;
        this.dummyHead = new ListNode();
        this.dummyTail = new ListNode();
    }

    public CircularLinkedList() {
        this(10);
    }

    public boolean prepend(ListNode node) {
        return append(node);
    }

    public boolean append(ListNode node) {
        if (size == cap) return false;
        if (size == 0) {
            dummyHead.next = node;
            dummyTail.next = node;
            node.next = node;
        } else {
            dummyTail.next.next = node;
            dummyTail.next = node;
            node.next = dummyHead.next;
        }
        size++;
        return true;
    }

    public boolean removeById(int index) {
        if (index >= size && index < 0) return false;

        ListNode temp = dummyHead;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if (index == size - 1)
            dummyTail.next = temp;

        temp.next = temp.next.next;
        size--;
        return true;
    }

    public boolean remove(Object obj) {
        ListNode temp = dummyHead;
        for (int i = 0; i < size; i++) {
            if (obj == temp.next.val) {
                if (i == size - 1)
                    dummyTail.next = temp;
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int cap() {
        return cap;
    }

    public ListNode getHead() {
        return dummyHead.next;
    }

    public String toString() {
        if (size == 0) return null;
        StringBuilder buf = new StringBuilder();
        ListNode temp = dummyHead.next;
        while (temp != dummyTail.next) {
            buf.append("->");
            buf.append(temp.val);
            temp = temp.next;
        }
        buf.append("->");
        buf.append(temp.val);
        return buf.substring(2);
    }


}
