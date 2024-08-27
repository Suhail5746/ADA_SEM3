public class ChainedMatrixOpt {

        /*static void order(int i, int j,int p[][],int n){
            if(i==j)
             System.out.print("A"+j+1);
            else{
                int k=p[i][j];
                System.out.print("(");
                order(i,k-i-1,p,n);
                order(k+1,j,p,n);
                System.out.print(")");
            
            }
    
        }*/
        public static int minMul(int O[],int[][]p,int n){
            int M[][]=new int[n][];
            for(int i=0;i<n;i++){
                M[i]=new int[n-i];
            }
          
            for(int d=1;d<n;d++){
                for(int i=0;i<n-d;i++){
                    int j=d;
                    M[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<i+j;k++){
                        int q = M[i][k-i] + M[k+1][i+j-k-1] + O[i]*O[k+1]*O[i+j+1];
                        if(q < M[i][j]){
                            M[i][j] = q;
                            p[i][j-1] = k+1;
                        }
                    }
                }   
            }
            System.out.println("matrix M ");
            for(int i=0;i<n;i++) {
                for(int j=0;j<n-i;j++){
                    System.out.print(M[i][j]+ " ");
    
                }
                System.out.println();
            }
    
            System.out.println("matrix p is");
    
            for(int i=0;i<n;i++) {
                for(int j=0;j<n-i-1;j++){
                    System.out.print(p[i][j]+ " ");
    
                }
                System.out.println();
            }
            //order(0,2,p,n);
            System.out.println();
            return M[1][n];
        } 
        
        public static void main(String[]args){
            int n=4;
            int d[]=new int[n+1];
            d[0]=5;
            d[1]=2;
            d[2]=3;
            d[3]=4;
            d[4]=6;
            int p[][]=new int[n+1][];
            for(int i=0;i<n;i++){
                p[i]=new int[n-1-i];
            }
            int min=minMul(d,p,n);
            System.out.println("Min no.of multiplication is  " +min);
        }
}
