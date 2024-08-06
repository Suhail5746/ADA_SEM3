
import java.util.*;
class Permutation{
    /*  public static void permute(int[]arr,int idx,int n){
        if(idx==n){
             System.out.print("[");
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" , ");
            }
            System.out.print("]");
            return;
        }

        for(int i=idx;i<n;i++){
            swap(arr,i,idx);
            permute(arr,idx+1,n);
            swap(arr,i,idx);
        }
    }

    //swap function
    public static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String []args){
         double t=10^9;
         int arr[]={1,2,3,4,5,6,7,8,9,0};
         permute(arr,0,arr.length);
         System.out.println();
         System.out.println(System.nanoTime()/t);
         
    }*/

    static void backtrack(int[]arr,List<Integer> temp){
        if(temp.size()==arr.length){
            System.out.print("[");
            for(int i=0;i<arr.length;i++){
                System.out.print(temp.get(i)+", ");
            }
            System.out.println("]");
        }
        else{

        for(int i=0;i<arr.length;i++){
            if(!temp.contains(arr[i])) {
                temp.add(arr[i]);
                backtrack(arr, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    }

    public static void main(String[] args) {
       // List<List<Integer>> ans=new ArrayList<>();
       double t=10^9;
        int arr[]={1,2,3,4,5,6,7,8,9,0};
        backtrack(arr ,new ArrayList<Integer>());
        System.out.println(System.nanoTime()/t);
    }

    


}