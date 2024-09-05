
import java.util.Arrays;



public class DisjointSet {
    private int[] U;
    int n;

    public DisjointSet(int []V) {
        n=V.length;
        U=V;
        for(int i=0;i<n;i++){
            U[i]=i;
        }
        
    }

    public int find(int x) {
        int i=x;
        while(U[i]!=i){
            i=U[i];
       }
       return i;
    }

    public void merge(int p, int q) {
        if(q>p){
            U[q]=p;
        }
        else
         U[p]=q;
    }

    public boolean equal(int p, int q) {
        return p == q;
    }

    public static void main(String[] args) {
        int[] V = {0,1, 2, 3, 4, 5,6,7,8,9};
        DisjointSet ds = new DisjointSet(V);
        
        
        ds.merge(0, 4);
        ds.merge(2,7);
        ds.merge(3,9);
        ds.merge(2,5);
        ds.merge(3,6);
        System.out.println(Arrays.toString(V));

        
    }
}