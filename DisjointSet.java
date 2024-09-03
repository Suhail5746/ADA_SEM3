public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int numSets;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        numSets = 0;
    }

    public void makeSet(int x) {
        if (x < 0 || x >= parent.length) {
            throw new IndexOutOfBoundsException();
        }
        if (parent[x] == 0) {
            parent[x] = x;
            rank[x] = 0;
            numSets++;
        }
    }

    public int find(int x) {
        if (x < 0 || x >= parent.length) {
            throw new IndexOutOfBoundsException();
        }
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void merge(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            numSets--;
        }
    }

    public boolean equal(int p, int q) {
        return find(p) == find(q);
    }
}