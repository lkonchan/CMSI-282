import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;

public class MathMethods {

    public static void main (String[] args){


      // String method = args[0];
      //
      // if (method.equals("factorial")) {
      //   System.out.println(factorial(Integer.parseInt(args[1])));
      // }
      // if (method.equals("fibonacci")) {
      //   System.out.println(fibonacci(Integer.parseInt(args[1])));
      // }
      // if (method.equals("gcd")) {
      //   System.out.println(gcd(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
      // }
      // if (method.equals("lcm")) {
      //   System.out.println(lcm(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
      // }

      //testing
      // System.out.println(factorial(6));
      // System.out.println(fibonacci(100));
      // System.out.println(gcd(1, 1)); //two consecutive fibonacci numbers = worst case scenario
      //   System.out.println(lcm(8, 7));
      // System.out.println(poly(5, [2, 1, 0]));
      // System.out.println(power(5, 3));
       System.out.println(root(5, 243, 1));
      // System.out.println(sqrt(25, 1)); //epsilon must be related intellectually to the digit

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
    // }
    //
    public static double root(int n, double x, double epsilon) {
      if (x == 1) {
         return 1;
      } else if (x < 1) {
        //need to do
         return 0;
      } else {
         return rootWork(n,0,x,x,epsilon);
      }
    }

    public static double sqrt(double x, double epsilon) {
       // use the binary search (halving technique) until you find a value that's within epsilon's requirements
       // WRINKLE if the number is less than 1, bounds must change
       // test 1 - an edge case
       if (x == 1) {
          return 1;
       } else if (x < 1) {
         //need to do
          return 0;
       } else {
          return rootWork(2, 0, x , x, epsilon);
       }
    }

    private static double rootWork(int n, double bound1, double bound2, double x, double e) {
      double half = (bound1 + bound2)/2;
      double de1 = bound1 - half;
      double de2 = bound2 - half;

      double test = half;
      for (int i = 1; i < n; i++) {
        test *= half;
      }

      if (test == x || (de1 <= e && de1 >= -e) || (de2 <= e && de2 >= -e)) {
        return half;
      } else {
        if (test > x) {
          //System.out.println(half);
          return rootWork(n, bound1, half, x, e);
        } else {
          //System.out.println(half);
          return rootWork(n, half, bound2, x, e);
        }
      }

    }

}
