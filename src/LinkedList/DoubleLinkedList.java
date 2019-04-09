package LinkedList;

public class DoubleLinkedList extends LinkedList {

    @Override
    public void prepend(ListNode node) {
        if (size == 0) {
            dummyHead.next = node;
            dummyTail.next = node;
        } else {
            node.next = dummyHead.next;
            dummyHead.next.prev = node;
            node.prev = dummyHead.next;
            dummyHead.next = node;
        }
        size++;
    }

    @Override
    public void append(ListNode node) {
        if (size == 0) {
            dummyHead.next = node;
            dummyTail.next = node;
        } else {
            dummyTail.next.next = node;
            node.prev = dummyTail.next;
            dummyTail.next = node;
        }
        size++;
    }

    @Override
    public boolean removeById(int index) {
        if (index >= size && index < 0) return false;

        ListNode temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if (index == size - 1)
            dummyTail.next = temp;

        if (temp.next.next != null) {
            temp.next = temp.next.next;
            temp.next.prev = temp;
        } else {
            temp.next = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        ListNode temp = dummyHead;
        for (int i = 0; i < size; i++) {
            if (obj == temp.next.val) {
                if (i == size - 1)
                    dummyTail.next = temp;
                temp.next = temp.next.next;
                temp.next.prev = temp;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String toReverseString() {
        if (size == 0) return null;

        ListNode temp = dummyTail.next;
        StringBuilder buf = new StringBuilder();
        while (temp != null) {
            buf.append("->");
            buf.append(temp.val);
            temp = temp.prev;
        }
        return buf.substring(2);
    }

}
