import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine(); 
        in.close();
        byte [] buffer = message.getBytes();
        String unary = "";
    	int last = -1;
        for(int i = 0 ; i < buffer.length ; i++) {
        	for(int j = 0; j < 7 ; ++j) {
        		if((buffer[i] & 64) == 0 ) {
        			if(last == 1) 
        				unary += " ";
        			unary += (last == 0) ? "0" : "00 0";
        			last = 0;
        		} else {
        			if(last == 0) 
        				unary += " ";
        			unary += (last == 1) ? "0" : "0 0";
        			last = 1;
        		}
        		buffer[i] <<= 1;
        	}
        }
    	System.out.println(unary);
    }
}