import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt(); // the number of cells on the X axis
        int R = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String [][] cord = new String[R][C];
        
        ArrayList<String> nodes = new ArrayList<String>(); //(column, row)
        
        for (int i = 0; i < R; i++) { //rows, height
            String line = in.nextLine(); 
            for(int j = 0; j < C; j++) { //columns, width
                char c = line.charAt(j);
                
                if( c == '0') {
                	cord[i][j] = j+" "+i;
                } else if( c == '.') {
                	cord[i][j] = "-1 -1";
                }
                nodes.add(cord[i][j]); 
            }
        }
        
        for(int index = 0; index < nodes.size(); index++) {
        	String label = nodes.get(index);
        	if(label != "-1 -1") {
        		Integer c = Integer.valueOf(label.substring(0,1));
        		Integer r = Integer.valueOf(label.substring(2,3));
                String answer = label;
                int right = (c+1)+r*C;
        		while(true) {
        			if(right % C == 0) {
        				answer += " -1 -1";
        				break;
        			}
        			if(nodes.get(right) != "-1 -1") {
        				answer += " "+nodes.get(right);
        				break;
        			} 
        			right++;
        		}
        		int below = c+C+r*C;
        		while(true) {
        			if(below >= nodes.size()) {
        				answer += " -1 -1";
        				break;
        			}
        			if(nodes.get(below) != "-1 -1") {
        				answer += " "+nodes.get(below);
        				break;
        			}
        			below += C;
        		}
        		System.out.println(answer);
        	}
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}