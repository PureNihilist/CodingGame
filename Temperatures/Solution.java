import java.io.*;
class Solution {
    public static void main(String args[]) {
    	int n;
    	String temps;
        BufferedReader reader = null; 
        BufferedWriter writer = null;
        try {
        	reader = new BufferedReader(new InputStreamReader(System.in));
        	writer = new BufferedWriter(new OutputStreamWriter(System.out));
        	n = Integer.valueOf(reader.readLine()); // the number of temperatures to analyse
        	if(n > 0) {
	        	temps = reader.readLine(); // the n temperatures expressed as integers ranging from -273 to 5526
	        	String [] numbers = temps.split(" ");
	        	int margin = 10000;
	        	int current_temp;
	        	for(int i = 0 ; i < n ; i++) {
	        		current_temp = Integer.valueOf(numbers[i]);    			
	        		if(Math.abs(current_temp - 0) < Math.abs(margin - 0 ) || ( Math.abs(current_temp - 0) == Math.abs(margin - 0 )  && current_temp > 0 )) {
	        			margin = current_temp;
	        		} 
	        	}
	        	writer.write(String.valueOf(margin));
        	} else if (n == 0) {
        		writer.write(String.valueOf(0));
        	}
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
        	try {
        		reader.close();
        		writer.close();
        	} catch(IOException IOex) {
        		IOex.printStackTrace();
        	}
        }
    }
}