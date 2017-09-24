import java.util.*;
class Solution {
	public static void main(String [] args) {
	   Scanner in = new Scanner(System.in);
       int W = in.nextInt(); //width  columns
       int H = in.nextInt(); //height rows
       int max [][] = new int[H][W];
       for (int i = 0; i < H; i++)
       {
           for (int j = 0; j < W; j++)
           {
               int food = in.nextInt();
               if(i > 0) {
            	   max[i][j] = max[i-1][j];
               }
               if(j > 0 && max[i][j] < max[i][j-1]) {
            	   max[i][j] = max[i][j-1];
               }
               max[i][j] += food;
           }
       }
       in.close();
       System.out.println(max[H-1][W-1]);
	}
}
