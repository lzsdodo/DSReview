package Graph;

public class Vertex {

    int id;
    int degIn;
    int degOut;


    public Vertex(int id) {
        this.id     = id;
        this.degIn  = 0;
        this.degOut = 0;
    }

}
