import java.util.*;

class Triplet {
    int weight;
    int node;
    int parent;
    public Triplet(int weight, int node,int parent) { 
        this.node = node;
        this.weight = weight;
        this.parent=parent;
    }
}
class Prims {
    
    static ArrayList<int[]> findMST(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

       
        boolean[] visited = new boolean[V];

       
        ArrayList<int[]> mst = new ArrayList<>();

        
        pq.add(new Triplet(0, 0, -1));

        // Process until the queue is empty
        while (!pq.isEmpty()) {
            Triplet current = pq.poll();
            int weight = current.weight;
            int node = current.node;
            int parent = current.parent;

            // If node is already visited, continue to the next element
            if (visited[node]) continue;

            // Mark the node as visited
            visited[node] = true;

            // If the node has a parent (i.e., it is not the starting node)
            if (parent != -1) {
                mst.add(new int[] {parent, node, weight});
            }

            // Explore adjacent nodes
            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int adjWeight = neighbor.get(1);

                // If adjacent node is not visited, push it to the priority queue
                if (!visited[adjNode]) {
                    pq.add(new Triplet(adjWeight, adjNode, node));
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        int V = 5; 
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            ArrayList<Integer> edge1 = new ArrayList<>();
            edge1.add(v);
            edge1.add(w);
            adj.get(u).add(edge1);

            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(u);
            edge2.add(w);
            adj.get(v).add(edge2);
        }
        Prims obj=new Prims();

        // Get the edges of the MST
        ArrayList<int[]> mst = obj.findMST(V, adj);
        System.out.println("The edges in the Minimum Spanning Tree are:");
        for (int[] edge : mst) {
            System.out.println(edge[0] + " - " + edge[1] + ", weight: " + edge[2]);
        }
    }
}

