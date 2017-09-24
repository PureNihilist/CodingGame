import java.util.*;

class Solution {
	static int H = 0;
	static int W = 0;
	static ArrayList<Node> nodes = new ArrayList<Node>();
	
	static class Node {
		int data;
		Node(int data) {

			this.data = data;
		}
	}
	static int food;
	static int maxFood;
	static int [] foodTable;
	
	static void findPath(int adjacencyMatrix[][] , int nodeIndex) {
		food += nodes.get(nodeIndex).data;
		int oldNode = -1;
		foodTable[nodeIndex] = food;
		for(int i = 0; i < H*W; i++) {			
			if(adjacencyMatrix[nodeIndex][i] == 1) {
	    		if(nodeIndex == oldNode) {
	    			food += foodTable[nodeIndex];
	    		}
	    		oldNode = nodeIndex;
	    		findPath(adjacencyMatrix,i);
	    	} else if(nodeIndex == nodes.size() - 1) {
	    		if (food > maxFood) {
	    			maxFood = food;
	    		}
	    		food = 0;	
	    		return;
	    	}
	    }
	}
	
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt(); //width  columns
        H = in.nextInt(); //height rows
        int adjacencyMatrix [][] = new int[H*W][W*H];
        for (int i = 0 ; i < H*W ; i++) {
            for (int j = 0 ; j < W*H ; j++) {
            	adjacencyMatrix[i][j] = 0;
            }
        }
        for (int i = 0 ; i < H ; i++) {
            for (int j = 0 ; j < W ; j++) {
                Node node = new Node(in.nextInt());
                nodes.add(node);
            }
        }
        in.close();
        for(int index = 0 ; index < nodes.size() ; index++) {
            	if(index + 1 < nodes.size() && ( (index + 1) % W != 0) ){ //right neighbour
		        	adjacencyMatrix[index][index+1] = 1;
            	}
            	if(index + W < nodes.size()) {
            		adjacencyMatrix[index][index+W] = 1; //down neighbour
            	}
       }
       foodTable = new int[nodes.size()];
       findPath(adjacencyMatrix,0);
       System.out.println(maxFood);
   }
}