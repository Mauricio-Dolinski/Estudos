import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        int currHeight = 0;
        int maxHeight = 0;
        
        Stack<Node> stack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        stack.push(root);
        Node current = root;
        
        while (!stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                heightStack.push(currHeight);
                current = current.left;
                currHeight++;
            }

            current = stack.pop();
            if (current.equals(root)){
                currHeight = 0;
            }
            else {
                currHeight = heightStack.pop();
            }

            if (current != null){
                //System.out.println(current.data + " altura: " + currHeight);
                if (currHeight > maxHeight) maxHeight = currHeight;
            } 

            current = current.right;
            currHeight++;
        }
        
        
        /* //Outro metodo, indo nivel a nivel, visitando todos os nodes
        if (root == null) {
            return 0;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int maxHeight = 0;

        Stack<Node> nextLevel = new Stack<>();

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.left != null) {
                nextLevel.push(current.left);
            }
            if (current.right != null) {
                nextLevel.push(current.right);
            }

            if (stack.isEmpty()) {
                stack = nextLevel;
                nextLevel = new Stack<>();
                maxHeight++;
            }
        }
        
        */

        
        return maxHeight;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}