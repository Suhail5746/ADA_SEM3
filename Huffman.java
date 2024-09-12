
import java.util.*;
import org.w3c.dom.ls.LSException;

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
    static Map<String, Character> mp=new HashMap<>();

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

    static void generatecode(Node root ,String s){
        if(root == null)
        return;
        if(root.left ==null && root.right==null){
           System.out.print(root.symbol+ "  ");
           System.out.println(s);
           mp.put(s,root.symbol);
        }
        generatecode(root.left, s+"0");
        generatecode(root.right, s+"1");
    }
//method for encoding
   static String encode(String s) {
        String code="";
        for (int i = 0; i < s.length(); i++) {
            code += mp.get(s.charAt(i));
        }
        return code;

   }

   static String decode(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            String t=s.charAt(i)+"";
            if(mp.containsKey(t)){
                

        }

   }
    


    public static void main(String[] args) {
        char symbol[] = {'a', 'b', 'c','d','e','f'};
        int freq[] = {16,5,12,17,10,25};
        int n=freq.length;
        MinHeap t = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            t.insert(new Node(freq[i], symbol[i]));
        }
        for(int i=1;i<n;i++){
            Node p=t.delMin();
            Node q=t.delMin();
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
        
        System.out.println();
        generatecode(t.a[0], "");

        String res=encode("cab");
        System.out.println(res);
        decode(res);

    }
}
