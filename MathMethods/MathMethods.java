import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;

public class MathMethods {

    public static void main (String[] args){
      //needs to be a runner by being able to call
      //any of the methods from the command line

      //testing
      //System.out.println(factorial(6));
       System.out.println(fibonacci(100));
      // System.out.println(gcd(1, 1)); //two consecutive fibonacci numbers = worst case scenario
      //   System.out.println(lcm(8, 7));
      // System.out.println(poly(5, [2, 1, 0]));
      // System.out.println(power(5, 3));
      // System.out.println(root(243, 5, ?)); //wut is epsilon?
      // System.out.println(sqrt(64, ?)); //epsilon must be related intellectually to the digit

    }

    public static java.math.BigInteger factorial(int n) {
      BigInteger b = new BigInteger(Integer.toString(n));
       for (int i = n - 1; i > 1; i--) {
             BigInteger x = new BigInteger(Integer.toString(i));
             b = b.multiply(x);
       }
       return b;
    }
    //
    public static java.math.BigInteger fibonacci(int n) {
      BigInteger a = new BigInteger("0");
      BigInteger b = new BigInteger("1");

      if (n == 0) {
        return a;
      } else if (n == 1){
        return b;
      }

      for (int i = 0; i <= n; i++) {
        BigInteger temp = a;
        a = a.add(b);
        b = temp;
      }
      return b;
    }
    //
    public static long gcd(long m, long n) {
       if (m > n) {
         long temp = n; n = m; m = temp;
       }

       if (m == 0) {
         return n;
       } else {
         return gcd(n%m, m);
       }
    }

    public static long lcm(long m, long n) {
      return((m*n)/gcd(m,n));
    }

    // public static double poly(double x, double[] coeff) {
    //
    // }
    //
    // public static double power(double x, int n) {
    //    // use the "binary" divide and conquer of the power to lessen the number of multiplications
    //
    // }
    //
    // public static double root(int n, double x, double epsilon) {
    //
    // }
    //
    // public static double sqrt(double x, double epsilon) {
    //    // use the binary search (halving technique) until you find a value that's within epsilon's requirements
    //    // WRINKLE if the number is less than 1, bounds must change
    //    // test 1 - an edge case
    // }

    //epsilon is the number of error to round to


}
