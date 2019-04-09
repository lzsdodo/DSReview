package LinkedList;

import static java.lang.System.out;

public class TestLinkedList {

    public static void main(String[] args) {
        testLinkedList();
        out.println("===== ===== ===== =====\n");

        testDoubleLinkedList();
        out.println("===== ===== ===== =====\n");

        testCircularLinkedList();
        out.println("===== ===== ===== =====\n");
    }

    private static void testLinkedList() {
        LinkedList ll = new LinkedList();
        out.println(ll.getClass().getName());

        for (int i = 0; i < 10; i++)
            ll.append(new ListNode(i));
        out.println(ll.toString() + " with size of " + ll.size());

        ll.removeById(5);
        ll.removeById(0);
        out.println(ll.toString() + " with size of " + ll.size());
        ll.removeById(ll.size() - 1);
        out.println(ll.toString() + " with size of " + ll.size());
        ll.remove(2);
        ll.remove(3);
        out.println(ll.toString() + " with size of " + ll.size());
        ll.prepend(new ListNode(10));
        ll.append(new ListNode(-1));
        out.println(ll.toString() + " with size of " + ll.size());

        for (int i = 0; i < 10; i++)
            ll.remove(i);
        out.println(ll.toString() + " with size of " + ll.size());
    }

    private static void testDoubleLinkedList() {
        DoubleLinkedList dl = new DoubleLinkedList();
        out.println(dl.getClass().getName());

        for (int i = 0; i < 10; i++)
            dl.append(new ListNode(i));
        out.println(dl.toString() + " with size of " + dl.size());
        out.println(dl.toReverseString());

        dl.remove(4);
        dl.remove(5);
        dl.remove(6);
        out.println(dl.toString() + " with size of " + dl.size());
        out.println(dl.toReverseString());

        out.println("Remove last");
        dl.removeById(dl.size() - 1);
        out.println(dl.toString() + " with size of " + dl.size());

        while (dl.size() > 1)
            dl.removeById(0);
        out.println(dl.toString() + " with size of " + dl.size());

        dl.prepend(new ListNode(10));
        dl.append(new ListNode(-1));
        out.println(dl.toString() + " with size of " + dl.size());
    }

    private static void testCircularLinkedList() {
        CircularLinkedList cll = new CircularLinkedList();
        out.println(cll.getClass().getName());

        for (int i = 0; i < 10; i++)
            cll.append(new ListNode(i));
        out.println(cll.toString());
        out.println(cll.append(new ListNode(11)));
        out.println(cll.append(new ListNode(12)));

        cll.removeById(cll.size() - 1);
        cll.removeById(0);
        out.println(cll.toString());

        cll.append(new ListNode(10));
        out.println(cll.toString());

        ListNode temp = cll.getHead();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < cll.size()*2; i++) {
            buf.append("->");
            buf.append(temp.val);
            temp = temp.next;
        }
        out.println(buf.substring(2));

    }

}
