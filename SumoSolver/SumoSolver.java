import java.util.*;

public class SumoSolver {

    public static void main (String[] args) {

      // int[] cost = {100, 49, 55};
      // int[] weight = {51, 52, 99};
      // int amount = 100;


      int[] cost = new int[args.length];
      int[] weight = new int[args.length];
      int amount = 0;

      try {
          amount = Integer.parseInt(args[args.length - 1]);
          if (amount < 0) {
              System.out.println("Amount must be a postive integer.");
              return;
          }
          for (int i = 0; i < args.length-1; i+=2) {
            cost[i] = Integer.parseInt(args[i]);
            weight[i] = Integer.parseInt(args[i+1]);
          }
      } catch (NumberFormatException nfe) {
          System.out.println("Amount must be an integer.");
      }

      int[][] solution = new int[cost.length][amount+1];


      SumoSolver(cost, weight, cost.length-1, amount, solution);
    //  System.out.println("$" + cost[i] + " / " + weight[i] + " pounds");
      System.out.println(" items / $" + " / " + solution[cost.length-1][amount] + " pounds");

    }


    public static int SumoSolver(int[] cost, int[] weight, int i, int j, int[][]solution) {
      //conditon where we can pull a cost out and we are not on the top row of the table
      if (j - cost[i] > 0 && i > 0) {
        int lbs;
        int previousSolution;

        //memoization of supplemental value
        if (solution[i-1][j-cost[i]] != 0) {
          lbs = weight[i] + solution[i-1][j-cost[i]];
        } else {
          lbs = weight[i] + SumoSolver(cost, weight, i-1, j-cost[i], solution); //supplement
        }

        //memoization of previous solution
        if (solution[i-1][j] != 0) {
          previousSolution = solution[i-1][j];
        } else {
          previousSolution = SumoSolver(cost, weight, i-1, j, solution);
        }

        //check which solution is better
        if (lbs > previousSolution) {
          return solution[i][j] = lbs;
        } else {
          return solution[i][j] = previousSolution;
        }

      //condition where we can pull a cost out but we are on the top row of the table
      } else if (j - cost[i] > 0 && j >= 0) {
        solution[i][j] = weight[i];
        return solution[i][j];

      //condition where we cannot pull a cost out and we are on the top row
      } else {
        return 0;
      }
    }

}
