package Graph;


import java.util.LinkedList;

public class GraphAlgo {

    // Topo Sort: Kahn & DFS
    public void topoSortByKahn(int v, LinkedList<Integer> adjList[]) {
        int[] degIn = new int[v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                int w = adjList[i].get(j); // i->w
                degIn[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; ++i) {
            if (degIn[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adjList[i].size(); j++) {
                int k = adjList[i].get(j);
                degIn[k]--;
                if (degIn[k] == 0) queue.add(k);
            }
        }
    }


    public void topoSortByDFS(int v, LinkedList<Integer> adjList[]) {
        // Create inverseAdjList
        // s->t means: s depends on t，t is ahead of s
        LinkedList<Integer> invAdjList[] = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            invAdjList[i] = new LinkedList<>();
        }

        // Generate inverse AdjList
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                int w = adjList[i].get(j); // i->w
                invAdjList[w].add(i); // w->i
            }
        }

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // DFS traverse the graph
            if (!visited[i]) {
                visited[i] = true;
                tpsDFS(i, invAdjList, visited);
            }
        }
    }

    private void tpsDFS(int vertex, LinkedList<Integer> invAdjList[], boolean[] visited) {
        for (int i = 0; i < invAdjList[vertex].size(); i++) {
            int w = invAdjList[vertex].get(i);
            if (visited[w]) continue;
            visited[w] = true;
            tpsDFS(w, invAdjList, visited);
        } // print all adj vertexes first, then the vertex itself
        System.out.print("->" + vertex);
    }



    // SSSP
    // Dijkstra, Bell-ford, Floyd......
    // Dijkstra: https://leetcode.com/problems/network-delay-time/

}
