import java.util.ArrayList;
import java.util.Collections;



class Edge implements Comparable<Edge> {
  int src, dest, weight;
  Edge(int _src, int _dest, int _wt) {
      this.src = _src; this.dest = _dest; this.weight = _wt;
  }
  // Comparator function used for
  // sorting edgesbased on their weight
  public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
  }
}
class Kruskal {
  //Function to find sum of weights of edges of the Minimum Spanning Tree.
  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    ArrayList<Edge> edges = new ArrayList<>();
    
    // O(N + E)
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < adj.get(i).size(); j++) {
            int adjNode = adj.get(i).get(j).get(0);
            int wt = adj.get(i).get(j).get(1);
            int node = i;
            edges.add(new Edge(node, adjNode, wt));
        }
    }
    
    DisjointSet ds = new DisjointSet(V);
    
    // Sorting edges by weight (M log M)
    Collections.sort(edges);
    
    int mstWt = 0;
    ArrayList<Edge> mstEdges = new ArrayList<>();
    
    // Iterating through sorted edges (M x 4 x alpha x 2)
    for (Edge edge : edges) {
        int wt = edge.weight;
        int u = edge.src;
        int v = edge.dest;

        if (ds.findUPar(u) != ds.findUPar(v)) {
            mstWt += wt;
            mstEdges.add(edge);
            ds.unionBySize(u, v);
        }
    }
    
    // Print the edges in the MST
    System.out.println("Edges in the MST:");
    for (Edge edge : mstEdges) {
        System.out.println("Edge: (" + edge.src + ", " + edge.dest + ") with weight: " + edge.weight);
    }

    return mstWt;
}
}

class Main {
public static void main(String[] args) {
    int V = 5;
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];

        ArrayList<Integer> tmp1 = new ArrayList<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp1.add(v);
        tmp1.add(w);

        tmp2.add(u);
        tmp2.add(w);

        adj.get(u).add(tmp1);
        adj.get(v).add(tmp2);
    }

    Kruskal obj = new Kruskal();
    int mstWt = obj.spanningTree(V, adj);
    System.out.println("The sum of all the edge weights: " + mstWt);
}
}