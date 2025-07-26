
public class Driver {

    public static void main(String[] args) {
        AdjacencyMap adj = new AdjacencyMap();

        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();

        v1.addAdjacent(v2);
        v1.addAdjacent(v3);
        v1.addAdjacent(v5);

        v2.addAdjacent(v4);
        v4.addAdjacent(v3);
        v3.addAdjacent(v5);

        adj.addVertex(v1);
        adj.addVertex(v2);
        adj.addVertex(v3);
        adj.addVertex(v4);
        adj.addVertex(v5);
    }

}
