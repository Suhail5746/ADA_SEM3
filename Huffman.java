
import java.beans.PropertyDescriptor;
import javax.management.RuntimeErrorException;

class Node {

    int freq;
    char symbol;
    Node left, right;

    Node() {
        freq = 0;
        symbol = '\0';
        left = null;
        right = null;
    }

    Node(int f, char c) {
        freq = f;
        symbol = c;
        left = null;
        right = null;
    }
}

class MinHeap {

    Node a[];
    int size;

    MinHeap(int n) {
        size = 0;
        a = new Node[n];
    }

    void insert(Node x) {
        int i = size;
        while (i > 0 && a[(i - 1) / 2].freq > x.freq) {
            a[i] = a[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        a[i] = x;
        size++;
    }

    Node delMin() {
        if (size == 0) {
            throw new RuntimeException("heap tree is empty");
        }
        Node x = a[0];
        a[0] = a[size - 1];
        size--;
        adjust(0);
        return x;
    }

    void adjust(int i) {
        int j = 2 * i + 1;
        Node x = a[i];
        while (j < size) {
            if (j < size - 1 && a[j].freq > a[j + 1].freq) {
                j++;
            }
            if (x.freq <= a[j].freq) {
                break;
            }

            a[(j - 1) / 2] = a[j];
            j = 2 * j + 1;
        }
        a[(j - 1) / 2] = x;

    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(a[i].freq + " " + a[i].symbol + " ");
        }
    }

    
}

public class Huffman {

    static void inorder(Node root){
       if(root==null)
         return;
       inorder(root.left);
       System.out.print(root.freq+" ");
       inorder(root.right);
    }

    //Preorder
    static void preorder(Node root){
        if(root ==null)
          return;
        System.out.print(root.freq+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String[] args) {
        char symbol[] = {'a', 'b', 'c'};
        int freq[] = {7, 2, 3};
        int n=freq.length;
        MinHeap t = new MinHeap(3);
        for (int i = 0; i < n; i++) {
            t.insert(new Node(freq[i], symbol[i]));
        }
        for(int i=1;i<n;i++){
            Node p=t.delMin();
            Node q=t.delMin();
            System.out.println(p.freq+"testing");
            System.out.println(q.freq +"testing");
            Node r=new Node(p.freq+q.freq,'$');
            r.left=p;
            r.right=q;
            t.insert(r);
        }
        System.out.println("inorder ");
        inorder(t.a[0]);
        System.out.println();

        System.out.println("preorder ");
        preorder(t.a[0]);

    }
}
