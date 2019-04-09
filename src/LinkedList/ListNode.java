package LinkedList;

public class ListNode {

    public Object   val;
    public ListNode prev;
    public ListNode next;

    public ListNode() {
        this.val  = null;
        this.prev = null;
        this.next = null;
    }

    public ListNode(Object obj) {
        this.val  = obj;
        this.prev = null;
        this.next = null;
    }

    public int compare(ListNode other) {
        if (this.val == other.val) return 0;
        if ((int) this.val < (int) other.val) return -1;
        else return 1;
    }

}
