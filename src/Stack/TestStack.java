package Stack;

import static java.lang.System.out;

public class TestStack {

    public static void main(String[] args) {
        testArrayStack();
        out.println("===== ===== ===== =====\n");

        testLinkedListStack();
        out.println("===== ===== ===== =====\n");

        testBrowser();
        out.println("===== ===== ===== =====\n");
    }

    private static void testArrayStack() {
        ArrayStack as = new ArrayStack();
        out.println(as.getClass().getName());

        for (int i=1; i<=10; i++) {
            as.push(String.valueOf(i));
        }
        out.println("Size: " + as.size());
        out.println("Cap: " + as.cap());

        as.push("11");
        as.push("12");
        as.push("13");
        out.println("Size: " + as.size());
        out.println("Cap: " + as.cap());

        out.println("Peek: " + as.peek());
        out.println("Pop: " + as.pop());
        out.println("Pop: " + as.pop());
        out.println("Peek: " + as.peek());

        int times = as.size() + 1;
        out.println("Size: " + as.size() + "; Times: " + times);
        for (int i=0; i<times; i++) {
            out.println(String.valueOf(as.pop()));
        }

    }

    private static void testLinkedListStack() {
        LinkedListStack lls = new LinkedListStack();
        out.println(lls.getClass().getName());

        for (int i=1; i<=10; i++) {
            lls.push(String.valueOf(i));
        }

        for (int i=1; i<=5; i++) {
            out.println(String.valueOf(lls.pop()));
        }

        for (int i=21; i<=25; i++) {
            lls.push(String.valueOf(i));
        }


        int times = lls.size() + 1;
        out.println("Peek: " + lls.peek());
        out.println("Size: " + lls.size() + "; Times: " + times);
        for (int i=0; i<times; i++) {
            out.println(String.valueOf(lls.pop()));
        }

    }

    private static void testBrowser() {
        Browser bs = new Browser();
        out.println(bs.getClass().getName());

        for (int i=0; i<5; i++) {
            bs.openNewPage("p" + i);
        }

        out.println("Closed: " + bs.closePage());

        for (int i=0; i<5; i++) {
            out.println("Stored: " + bs.pageBack());
        }

        for (int i=0; i<5; i++) {
            out.println("Forward to: " + bs.pageForward());
        }

        out.println("Stored: " + bs.pageBack());
        out.println("Forward to: " + bs.pageForward());
        out.println("Stored: " + bs.pageBack());
        out.println("Stored: " + bs.pageBack());
        out.println("Closed: " + bs.closePage());
        out.println("Forward to: " + bs.pageForward());

    }

}
