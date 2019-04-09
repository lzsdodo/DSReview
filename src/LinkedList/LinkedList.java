package LinkedList;

public class LinkedList {

    protected ListNode dummyHead;
    protected ListNode dummyTail;
    protected int      size;

    public LinkedList() {
        this.dummyHead = new ListNode();
        this.dummyTail = new ListNode();
        this.size      = 0;
    }

    public void prepend(ListNode node) {
        if (size == 0) {
            dummyHead.next = node;
            dummyTail.next = node;
        } else {
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        size++;
    }

    public void append(ListNode node) {
        if (size == 0) {
            dummyHead.next = node;
            dummyTail.next = node;
        } else {
            dummyTail.next.next = node;
            dummyTail.next = node;
        }
        size++;
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

    public String toString() {
        if (size == 0) return null;
        StringBuilder buf = new StringBuilder();
        ListNode temp = dummyHead.next;
        while (temp != null) {
            buf.append("->");
            buf.append(temp.val);
            temp = temp.next;
        }
        return buf.substring(2);
    }

}
