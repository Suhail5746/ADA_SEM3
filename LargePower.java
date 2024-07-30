public class LargePower {
  static int[] power(int n, int p) {
     // Estimate the number of digits in n^p using logarithms
     double logSum = p * Math.log10(n);
     int m = (int) Math.floor(logSum) + 1;

     // Create an array to store the digits of the result
     int[] result = new int[m];
     result[m - 1] = 1; // Initialize the array with 1 (since n^0 = 1)

     // Compute n^p
     for (int i = 0; i < p; i++) {
        int carry = 0;
        for (int k = m - 1; k >= 0; k--) {
           int x = n * result[k] + carry;
           result[k] = x % 10;
           carry = x / 10;
        }

        // Handle remaining carry
        /*int j = m - 1;
        while (carry > 0) {
           j--;
           if (j >= 0) {
              result[j] += carry % 10;
              carry /= 10;
           } else {
              break;
           }
        }*/
     }

     // Return the array containing the digits of n^p
     return result;
  }

  public static void main(String[] args) {
     int n = 3;
     int p = 20;
     int a[] = power(n, p);
     for (int i = 0; i < a.length; i++) {
       
        System.out.print(a[i]);
     }
  }
}
