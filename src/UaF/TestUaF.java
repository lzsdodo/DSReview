package UaF;

import static java.lang.System.out;

public class TestUaF {

    public static void main(String[] args) {
        out.println("Test UaF");

        UaF uf = new UaF(5);

        out.println(uf.numOfRoots()); // 5

        out.println(uf.connected(0, 1)); // false
        uf.union(0, 1);
        out.println(uf.connected(0, 1)); // true
        uf.union(2, 3);
        out.println(uf.numOfRoots()); // 3

        uf.union(0, 4);
        out.println(uf.numOfRoots()); // 2

        uf.union(4, 2);
        out.println(uf.numOfRoots()); // 1
    }


}
