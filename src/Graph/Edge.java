package Graph;

public class Edge {

    Vertex v1;
    Vertex v2;
    float weight;

    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, 0);
    }

    public Edge(Vertex v1, Vertex v2, float weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

}
