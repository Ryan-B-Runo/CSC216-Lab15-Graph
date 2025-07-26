import java.util.HashMap;

public class Vertex {
    private HashMap<Vertex, Integer> adjacencyList;

    public Vertex() {
        this.adjacencyList = new HashMap<>();
    }

    public void setAdjacent(Vertex v) {
        if(!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, 1);
        }
    }

    public void addAdjacent(Vertex v, int weight) {
        adjacencyList.put(v, weight);
    }

    public void addAdjacent(Vertex v) {
        adjacencyList.put(v, 1);
    }

    public int getAdjacent(Vertex v) {
        return adjacencyList.get(v);
    }

}
