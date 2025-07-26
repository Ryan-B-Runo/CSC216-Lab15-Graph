import java.util.ArrayList;

public class AdjacencyMap {
    private ArrayList<Vertex> vertices;

    public AdjacencyMap() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.add(v);
    }

    public Vertex getVertex(int index) {
        return this.vertices.get(index);
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public int size() {
        return this.vertices.size();
    }

}
