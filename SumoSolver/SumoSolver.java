import java.util.*;

public class SumoSolver {

    public static void main (String[] args) {

      int[] cost = {48, 49, 55};
      int[] weight = {51, 52, 99};
      int amount = 100;
      int[][] solution = new int[cost.length][amount+1];

      SumoSolver(cost, weight, cost.length-1, amount, solution);
      System.out.println("Answer is: " + solution[cost.length-1][amount]);

      // int[] cost = new int[args.length / 2];
      // int[] weight = new int[args.length / 2];
      // int amount;

      // try {
      //     amount = Integer.parseInt(args[args.length - 1]);
      //     if (amount < 0) {
      //         System.out.println("Amount must be a postive integer.");
      //         return;
      //     }
      // } catch (NumberFormatException nfe) {
      //     System.out.println("Amount must be an integer.");
      // }

      // for (int i = 0; i < args.length-1; i++) {
      //   if (i%2 == 0) {
      //
      //   }
      // }

      // example code for parsing args
      // try {
  		// 	k = Integer.parseInt(args[0]);
  		// } catch (ArrayIndexOutOfBoundsException e) {
  		// 	System.out.println("BAD DATA");
  		// }
    }

    //returns array with total cost, which foods were used & their costs & weights
    //array[cost[], weight[], foods[], weights[]]; where cost & weight only have 1 item
    //table

    public static int SumoSolver(int[] cost, int[] weight, int i, int j, int[][]solution) {
      //System.out.println("conditional: " + (j-cost[i]));
      //System.out.println(j + " " + cost[i]);
      if (j - cost[i] > 0 && i > 0) {
        ////System.out.println(solution[i][j]);
        int supplement = SumoSolver(cost, weight, i, j-cost[i], solution);
        System.out.println("weight = " + weight[i] + " supplement = " + supplement + " cost = " + cost[i]);
        int lbs = weight[i] + supplement;
        int previousSolution = SumoSolver(cost, weight, i-1, j, solution);
        if (lbs > previousSolution) {
          solution[i][j] = lbs;
          //System.out.println("switched to supplement: " + solution[i][j]);
          return lbs;
        } else {
          solution[i][j] = previousSolution;
          //System.out.println("used previous solution: " +solution[i][j]);
          return previousSolution;
        }
      } else if (j - cost[i] > 0 && j >= 0) {
        System.out.println("Weight: " + weight[i]);
        solution[i][j] = weight[i];
        return solution[i][j];
      } else {
        //System.out.println(solution[i][j]);
        return 0;
      }
    }

}
