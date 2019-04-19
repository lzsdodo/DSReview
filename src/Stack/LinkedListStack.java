package Stack;

import LinkedList.ListNode;

public class LinkedListStack implements MyStack {

    private ListNode dummy;
    private ListNode tail;
    private int      size;

    public LinkedListStack() {
        this.dummy = new ListNode("HEAD");
        this.tail = this.dummy.next;
        this.size = 0;
    }

    @Override
    public void push(Object obj) {
        if (size == 0) {
            dummy.next = new ListNode(obj);
            tail = dummy.next;
        } else {
            tail.next = new ListNode(obj);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0) return null;
        size--;
        Object rtn = dummy.next.val;
        dummy.next = dummy.next.next;
        return rtn;
    }

    @Override
    public Object peek() {
        if (size == 0) return null;
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
}
