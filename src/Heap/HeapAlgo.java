package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapAlgo {

    public List<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> kList) {

        return null;
    }

    public List<Integer> findTopK(ArrayList<Integer> inputs, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) { return v1 - v2; }
        });

        for (Integer elem: inputs) {
            minHeap.offer(elem);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        return res;
    }

}
