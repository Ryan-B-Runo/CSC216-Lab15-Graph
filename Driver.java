import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

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

        System.out.println(dijkstra(adj, 0, 1));
        System.out.println(dijkstra(adj, 0, 4));
        System.out.println(dijkstra(adj, 1, 4));
        System.out.println(dijkstra(adj, 4, 0));
        System.out.println(dijkstra(adj, 1, 0));
    }

    static int dijkstra(AdjacencyMap adj, int start, int end) {
        HashMap<Vertex, Integer> dist = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for(Vertex v : adj.getVertices()) {
            if(v.equals(adj.getVertex(start))) {
                dist.put(v, 0);
            }else{
                dist.put(v, Integer.MAX_VALUE);
            }
            pq.add(v);
        }

        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            if(v.equals(adj.getVertex(end))) {
                if(dist.get(v) == Integer.MAX_VALUE) {
                    return -1;
                }
                return dist.get(v);
            }

            for(HashMap.Entry<Vertex, Integer> edge : v.getAdjacencyList().entrySet()) {
                Vertex u = edge.getKey();
                int weight = edge.getValue();

                if(dist.get(v) != Integer.MAX_VALUE && dist.get(v) + weight < dist.get(u)) {
                    dist.put(u, dist.get(v) + weight);
                    pq.remove(u);
                    pq.add(u);
                }
            }
        }
        if(dist.get(adj.getVertex(end)) == Integer.MAX_VALUE) {
            return -1;
        }
        return dist.get(adj.getVertex(end));
    }

}
