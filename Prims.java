/*import java.util.Arrays;

class Prims {
    static int V = 5; // You can change this to the number of vertices in your graph

    // Function to find the Minimum Spanning Tree (MST) using Prim's algorithm
    static void primMST(int[][] W) {
        int[] nearest = new int[V];
        int[] distance = new int[V];
        boolean[] inMST = new boolean[V];
        
        // Initializing the nearest and distance arrays
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0; // Start from vertex 0
        nearest[0] = -1; // The source vertex doesn't have a nearest vertex
        
        for (int count = 0; count < V - 1; count++) {
            // Find the minimum distance vertex that is not yet included in MST
            int min = Integer.MAX_VALUE;
            int near = -1;
            
            for (int i = 0; i < V; i++) {
                if (!inMST[i] && distance[i] < min) {
                    min = distance[i];
                    near = i;
                }
            }
            
            // Include the chosen vertex in MST
            inMST[near] = true;
            
            // Update the distance value of the adjacent vertices of the chosen vertex
            for (int i = 0; i < V; i++) {
                if (!inMST[i] && W[near][i] != 0 && W[near][i] < distance[i]) {
                    nearest[i] = near;
                    distance[i] = W[near][i];
                }
            }
        }
        
        // Printing the constructed MST
        printMST(nearest, W);
    }
    
    // Function to print the constructed MST
    static void printMST(int[] nearest, int[][] W) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(nearest[i] + " - " + i + "\t" + W[i][nearest[i]]);
        }
    }

    public static void main(String[] args) {
        
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };

        // Print the solution
        primMST(graph);
    }
}*/

import java.util.*;

// User function Template for Java

class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V,
                            ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq =
            new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];
        // {wt, node}
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}

public class Prims {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        Solution obj = new Solution();
        int sum = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}

