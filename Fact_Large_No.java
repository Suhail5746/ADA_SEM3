public class Fact_Large_No {
  static int[] fact(int n) {
     // Calculate the number of digits in n!
     double logSum = 0;
     for (int i = 2; i <= n; i++) {
        logSum += Math.log10(i);
     }
     int m = (int) Math.floor(logSum) + 1; // Number of digits in n!

     // Create an array to store the digits of the factorial
     int[] f = new int[m];
     f[m - 1] = 1; // Initialize the array with 1 (since 0! = 1)

     // Compute factorial
     for (int i = 2; i <= n; i++) {
        int carry = 0;
        for (int k = m - 1; k >= 0; k--) {
           int x = i * f[k] + carry;
           f[k] = x % 10;
           carry = x / 10;
        }

        // Handle remaining carry
        /*int j = m - 1;
        while (carry > 0) {
           j--;
           f[j] += carry % 10;
           carry /= 10;
        }*/
     }

     // Return the array containing the digits of n!
     return f;
  }

  public static void main(String[] args) {
     int a[] = fact(100);
     for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]);
     }
    
  }
}
