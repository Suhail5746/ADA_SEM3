import java.util.*;
public class BubblePartition{
    static int count=0;
   
    
    static void read(int []arr,int n){
      Scanner sc=new Scanner(System.in);
       System.out.println("enter "+n+ " values" );
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
    }

    static void print(int []arr,int n){
        System.out.print("[ ");
        for(int i=0;i<n;i++){
    
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }

    static void segregate(int []arr,int n){
         
         for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
               if(arr[j]%2==0 && arr[j+1]%2==0 && arr[j]<arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                count++;
              }
              else if(arr[j]%2!=0 && arr[j+1]%2!=0 && arr[j]>arr[j+1])
              {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                count++;
              }
              else if(arr[j]%2!=0 && arr[j+1]%2==0){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                count++;
              }
            }
        }
                
                
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int [] arr;
        int n;
        System.out.println("enter the size of array");
        n=sc.nextInt();
        arr=new int[n];
        read(arr,n);
        System.out.println("list before segregating");
        print(arr,n);
       
        System.out.println("list after segregating");
        segregate(arr,n);
       
        print(arr,n);
        
       System.out.println("total no. of swaps -> "+count);


    }
}