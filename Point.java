import java.util.ArrayList;
import java.util.Scanner;

class Point {
    public int x, y;

    Point() {
        x = y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    public double dist(Point p2) {
        return Math.sqrt((x - p2.x) * (x - p2.x) + (y - p2.y) * (y - p2.y));
    }

    public static void read(Point[] a, int n) {
        Scanner in = new Scanner(System.in);
        System.out.println("Read " + n + " points: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter x and y coordinates of the point: ");
            a[i].x = in.nextInt();
            a[i].y = in.nextInt();
        }
    }

    public static void print(Point[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("<" + a[i].x + ", " + a[i].y + ">");
        }
    }

    public static void getConvexHull(Point[] p, int n) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        
        for (int i = 0; i < n-1; i++) {
            Point p_i=p[i];
            for (int j = i+1; j < n; j++) {
                Point p_j=p[j];
                int a= p_j.y-p_i.y;
                int b= p_i.x-p_j.x;
                int c=p_i.x*p_j.y-p_i.y*p_j.x;
                boolean flag = true;
                int newSign,oldSign=2;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    Point p_k=p[k];
                    if(a*p_k.x + b*p_k.y<c) newSign=-1;
                    else if(a*p_k.x + b*p_k.y> c) newSign=1;
                    else newSign=0;

                    if(newSign==0 && p_i.dist(p_k)+p_k.dist(p_j)>p_i.dist(p_j)+0.00001){
                        flag=false;
                        break;
                    }
                       
                       
                    else if(oldSign!=2 && newSign!=oldSign){
                        flag=false;
                        break;
                    }
                    else if(oldSign==2 && newSign!=0){
                        oldSign=newSign;
                    }
                }
    


                if (flag) {
                    System.out.println("Edge of the convex hull: <" + p[i].x + ", " + p[i].y + "> to <" + p[j].x + ", " + p[j].y + ">");
                    x.add(p[i].x);
                    y.add(p[i].y);
                    x.add(p[j].x);
                    y.add(p[j].y);
                }
            }
        }

        System.out.println("Edges of Convex HULL = [");
        for (int i = 0; i < x.size(); i += 2) {
            System.out.println("<" + x.get(i) + ", " + y.get(i) + " -> " + x.get(i + 1) + ", " + y.get(i + 1) + ">");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many points? ");
        int n = in.nextInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point();
        }

        Point.read(points, n);
        System.out.println("\nThe set of points is:");
        Point.print(points, n);
        //call get convex hull
        getConvexHull(points, n);
    }
}



    