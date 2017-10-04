import java.util.*;
class Solution {
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); //length of letters+gap
        int H = in.nextInt(); //number of rows
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine().toUpperCase();
        int index = 0;
        String answer = "";
        for (int i = 0; i < H; i++) { 
            String line = in.nextLine();
            for(int j = 0 ; j < T.length(); j++) { 
                index = T.charAt(j) - 'A';
                if(index < 0 || index >= 26) {
                    index = 26;
                } 
                answer += line.substring(index*L, index*L+L);
        	}
        	answer += '\n';
        }
        System.out.println(answer);
	}
}