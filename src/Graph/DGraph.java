package Graph;

import java.util.LinkedList;

public class DGraph {

    private int v;
    private LinkedList<Edge> adjList[];

    public DGraph(int v) {
        this.v = v;
        this.adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        this.adjList[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // Start vertex of an edge
        public int tid; // End vertex of an edge
        public int w;   // Weight
        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w   = w;
        }
    }

    // For Dijkstra
    private class Vertex {
        public int id;   // Vertex ID
        public int dist; // Distance from start vertex to this vertex
        public Vertex(int id, int dist) {
            this.id   = id;
            this.dist = dist;
        }
    }

}
