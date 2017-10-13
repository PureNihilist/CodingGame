import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        HashMap<String, String> association = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next().toUpperCase(); // file extension
            String MT = in.next(); // MIME type.
            association.put('.'+EXT, MT);
        } 
        String FNAME = "";
        for (int i = 0; i <= Q; i++) {
            FNAME = in.nextLine(); // One file name per line.
        	if(FNAME.length() > 0) {
	            try {
		            int extension_start = FNAME.lastIndexOf('.');
		            String extension = FNAME.substring(extension_start, FNAME.length()).toUpperCase();
		            if(association.containsKey(extension)) {
		            	for(Map.Entry<String, String> entry : association.entrySet()) {
		            		if(extension.equals(entry.getKey())) {
		            			System.out.println(entry.getValue());
		            			break;
		            		}
		            	}
		            } else {
		            	System.out.println("UNKNOWN");
		            } 
	            } catch(Exception e) {
	            	System.out.println("UNKNOWN");
	            } 
        	}
        }
        in.close();
    }
}