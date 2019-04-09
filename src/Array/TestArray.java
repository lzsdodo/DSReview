package Array;

import static java.lang.System.out;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
        out.println("Test DynamicArray......");
        testDynamicArray();
        out.println("===== ===== ===== =====");

        out.println("Test OrderedArray......");
        testOrderedArray();
        out.println("===== ===== ===== =====");

        out.println("Test ArrayAlgo......");
        testArrayAlgo();
        out.println("===== ===== ===== =====");

    }

    private static void testDynamicArray() {
        DynamicArray da = new DynamicArray();

        for (int i = 0; i < 10; i++)
            da.add(String.valueOf(i));

        out.println(da.toString() + "; Size: " + da.size());

        for (int i = 10; i < 20; i++)
            da.add(String.valueOf(i));

        out.println(da.toString() + "; Size: " + da.size());

        da.remove(10);
        out.println(da.toString() + "; Size: " + da.size());

        da.remove(0);
        out.println(da.toString() + "; Size: " + da.size());

    }

    private static void testOrderedArray() {
        OrderedArray oa = new OrderedArray(10);
        out.println(oa.toString());

        for (int i = 0; i < 12; i++)
            oa.add(i);

        out.println(oa.toString() + " with size " + oa.size());

        oa.remove(3);
        oa.remove(4);
        oa.remove(5);
        out.println(oa.toString() + " with size " + oa.size());

        oa.add(10);
        oa.add(6);
        out.println(oa.toString() + " with size " + oa.size());

        oa.update(0, 11);
        oa.add(12);
        out.println(oa.toString() + " with size " + oa.size());

    }

    private static void testArrayAlgo() {
        int l1[] = {1, 3, 5, 7, 9};
        int l2[] = {0, 2, 4, 6, 8, 10};

        int rtn[] = ArrayAlgo.mergeOrderedList(l1, l2);
        out.println(Arrays.toString(rtn));
    }

}
