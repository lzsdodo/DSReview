package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UdGraph {

    private int     v; // # of vertex
    private int[][] adjMatrix;
    private LinkedList<Integer> adjList[];

    public UdGraph(int v) {
        this.v    = v;
        adjMatrix = new int[v][v];

        adjList   = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        // Undirected Graph save 2 times for 1 edge
        // easily with weight or with direction
        adjList[s].add(t);
        adjList[t].add(s);
        adjMatrix[s][t] = 1;
        adjMatrix[t][s] = 1;
    }

    // BFS
    public void bfs(int s, int t) {
        if (s == t) return;

        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[v];

        visited[s] = true;
        queue.add(s);
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adjList[w].size(); i++) {
                int q = adjList[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    // DFS
    boolean found = false; // global variable for dfs

    public void dfs(int s, int t) {
        found = false;

        boolean[] visited = new boolean[v];
        int[]     prev    = new int[v];
        Arrays.fill(prev, -1);
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adjList[w].size(); i++) {
            int q = adjList[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }


    private void print(int[] prev, int s, int t) {
        // Recursively print the path of s->t
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}

