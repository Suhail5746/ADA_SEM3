import java.util.*;

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
            throw new RuntimeException("Heap is empty");
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
            a[i] = a[j];
            i = j;
            j = 2 * i + 1;
        }
        a[i] = x;
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(a[i].freq + " " + a[i].symbol + " ");
        }
    }
}

public class Huffman {
    // For encoding (character -> code)
    static Map<Character, String> encodingMap = new HashMap<>();
    
    // For decoding (code -> character)
    static Map<String, Character> decodingMap = new HashMap<>();

    // Inorder traversal (for debugging purposes)
    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.freq + " ");
        inorder(root.right);
    }

    // Preorder traversal (for debugging purposes)
    static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.freq + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Generate Huffman code recursively
    static void generatecode(Node root, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            System.out.println(root.symbol + "  " + s);
            encodingMap.put(root.symbol, s);
            decodingMap.put(s, root.symbol);
        }
        generatecode(root.left, s + "0");
        generatecode(root.right, s + "1");
    }

    // Method for encoding
    static String encode(String s) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            code.append(encodingMap.get(s.charAt(i)));
        }
        return code.toString();
    }

    // Method for decoding
    static String decode(String s) {
        String res = "";
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            t += s.charAt(i);
            if (decodingMap.containsKey(t)) {
                res += decodingMap.get(t);
                t = "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char symbol[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int freq[] = { 16, 5, 12, 17, 10, 25 };
        int n = freq.length;
        
        // Build the MinHeap and Huffman Tree
        MinHeap t = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            t.insert(new Node(freq[i], symbol[i]));
        }
        for (int i = 1; i < n; i++) {
            Node p = t.delMin();
            Node q = t.delMin();
            Node r = new Node(p.freq + q.freq, '$');
            r.left = p;
            r.right = q;
            t.insert(r);
        }

        // Inorder and Preorder traversal
        System.out.println("Inorder:");
        inorder(t.a[0]);
        System.out.println("\nPreorder:");
        preorder(t.a[0]);

        // Generate Huffman codes
        generatecode(t.a[0], "");

        // Example encoding and decoding
        String input = "cab";
        String encoded = encode(input);
        System.out.println("\nEncoded string: " + encoded);

        String decoded = decode(encoded);
        System.out.println("Decoded string: " + decoded);
    }
}
