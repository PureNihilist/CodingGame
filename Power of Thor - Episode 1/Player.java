import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lX = in.nextInt(); // the X position of the light of power
        int lY = in.nextInt(); // the Y position of the light of power
        int tX = in.nextInt(); // Thor's starting X position
        int tY = in.nextInt(); // Thor's starting Y position
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            String path = "";

                if( lY > tY ) {
                    tY++;
                    path = "S";
                } else if (lY < tY) {
                    tY--;
                    path = "N";   
                } 
                
                if( lX > tX ) {
                    tX++;
                    path += "E";
                } else if ( lX < tX ) {
                    tX--;
                    path += "W";
                } 
                // Write an action using System.out.println()
                // To debug: System.err.println("Debug messages...");
                System.out.println(path);
            }
            // A single line providing the move to be made: N NE E SE S SW W or NW
        }
}
