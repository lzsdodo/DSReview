package Heap;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapAlgo {

    public ListNode mergeKSortedList(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        // compare already implemented in ListNode
        PriorityQueue<ListNode> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.offer(lists[i]);
        }
        if (pq.isEmpty()) return null;

        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null)
                pq.offer(node.next);
        }

        return dummyHead.next;
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
