import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine(); 
        int K = in.nextInt(); //number of maximum character that the substring will have
        in.close();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int maxChars = K; //minimum substring is the number of chars = K 
        int left = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i); 
            if(map.containsKey(c)) {  //I check if I have already this char in my map
                map.put(c , map.get(c)+1); //if I do, I add +1 to it's key
            } else {
            	map.put(c , 1);  //if I don't, I create new key and start with 1
            }
            if(map.size() > 2) { //when I have 2 I can backtrack to find best solution
                maxChars = Math.max(maxChars, i - left ); //so maxChars contains either min or char index - number of removed 
                while(map.size() > K) { //if I have more then min of characters
                    
                    char f = S.charAt(left); // I take char from begin and traverse 
                    if(map.get(f) == 1) { //if this char is the last one i remove it from map
                        map.remove(f);
                    } else {
                        map.put(f, map.get(f)-1) ; //if this char have more i remove just one
                    }
                    left++;//here I traverse to check 
                }
            }
        }
        maxChars = Math.max(maxChars, S.length()-left); //so the answer is either minimum or the number of "lefts" i removed from string
        System.out.println(maxChars);
    }
}