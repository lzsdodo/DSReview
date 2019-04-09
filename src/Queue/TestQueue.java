package Queue;

import static java.lang.System.out;

public class TestQueue {

    public static void main(String[] args) {
        testArrayQueue();
        out.println("===== ===== ===== =====\n");

        testLinkedListQueue();
        out.println("===== ===== ===== =====\n");

        testCircularQueue();
        out.println("===== ===== ===== =====\n");
    }

    private static void testArrayQueue() {
        ArrayQueue aq = new ArrayQueue(5);
        out.println(aq.getClass().getName());

        for (int i = 0; i < 6; i++)
            out.println(String.valueOf(aq.offer(i)));

        out.println(aq.toString());

        for (int i = 0; i < 3; i++)
            out.println(String.valueOf(aq.poll()));

        out.println(aq.toString());
        out.println(aq.peek().toString());

        out.println(String.valueOf(aq.offer("10")));
        out.println(String.valueOf(aq.offer("11")));
        out.println(aq.toString());
        out.println(String.valueOf(aq.offer("12")));
        out.println(String.valueOf(aq.offer("13")));
        out.println(aq.toString());

        for (int i = 0; i < 6; i++)
            out.println(String.valueOf(aq.poll()));

    }

    private static void testLinkedListQueue() {
        LinkedListQueue llq = new LinkedListQueue();
        out.println(llq.getClass().getName());

        for (int i = 0; i < 5; i++)
            llq.offer(i);

        out.println("Size: " + llq.size());
        out.println("Head: " + llq.peek());
        out.println(llq.toString());

        for (int i = 0; i < 5; i++)
            out.println(String.valueOf(llq.poll()));

        out.println("Size: " + llq.size());
        out.println("Head: " + llq.peek());
        out.println(llq.toString());

        llq.offer("10");
        llq.offer("11");
        out.println(llq.toString());
        llq.poll();
        out.println(llq.toString());
        llq.offer("12");
        llq.offer("13");
        out.println(llq.toString());
    }

    private static void testCircularQueue() {
        CircularQueue cq = new CircularQueue();
        out.println(cq.getClass().getName());

        for (int i = 0; i < 10; i++)
            cq.offer(i);
        out.println(String.valueOf(cq.offer(10)));
        out.println(String.valueOf(cq.offer(11)));
        out.println(cq.toString() + " with size " + cq.size());

        for (int i = 0; i < 5; i++)
            out.println(String.valueOf(cq.poll()));
        out.println(cq.toString() + " with size " + cq.size());
        out.println("Head: " + cq.peek());

        while (cq.size() > 0) cq.poll();

        cq.offer(1);
        cq.offer(3);
        cq.offer(5);
        cq.offer(7);
        out.println(cq.toString() + " with size " + cq.size());
        cq.poll();
        cq.poll();
        out.println(cq.toString() + " with size " + cq.size());
        for (int i = 2; i <= 16; i+=2)
            cq.offer(i);

        out.println(cq.toString() + " with size " + cq.size());
        out.println(String.valueOf(cq.offer(18)));
        out.println(String.valueOf(cq.offer(20)));
        out.println(cq.toString() + " with size " + cq.size());
        cq.poll();
        cq.poll();
        out.println(cq.toString() + " with size " + cq.size());
        cq.offer(18);
        cq.offer(20);
        out.println(cq.toString() + " with size " + cq.size());

    }
}
