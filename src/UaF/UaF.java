package UaF;

// Union and Find
public class UaF {

    private int[] ids;

    public UaF(int size) {
        ids = new int[size];
        for (int i = 0; i < size; i++)
            ids[i] = i;
    }

    public int findRoot(int id) {
        int root = id;
        while (root != ids[root]) {
            root = ids[root];
        }

        while (id != ids[id]) {
            int temp = ids[id];
            ids[id]  = root;
            id       = temp;
        }

        return root;
    }

    public boolean connected(int id1, int id2) {
        return findRoot(id1) == findRoot(id2);
    }

    public void union(int id1, int id2) {
        int root1 = findRoot(id1);
        int root2 = findRoot(id2);
        ids[root2] = root1;
        assert findRoot(id1) == findRoot(id2);
    }

    public int numOfRoots() {
        int rootNum = 0;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == i) rootNum++;
        }
        assert rootNum >= 1;
        return rootNum;
    }

}
