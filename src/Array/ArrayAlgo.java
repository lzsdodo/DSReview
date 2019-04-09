package Array;

public class ArrayAlgo {

    public static int[] mergeOrderedList(int[] l1, int[] l2) {

        int len1 = l1.length;
        int len2 = l2.length;
        int[] rtn = new int[len1+len2];

        int i = 0;
        int i1 = 0;
        int i2 = 0;

        while (i1 < len1 && i2 < len2) {
            if (l1[i1] <= l2[i2])
                rtn[i++] = l1[i1++];
            else
                rtn[i++] = l2[i2++];
        }

        while (i1 < len1) rtn[i++] = l1[i1++];
        while (i2 < len2) rtn[i++] = l2[i2++];

        return rtn;
    }

}
