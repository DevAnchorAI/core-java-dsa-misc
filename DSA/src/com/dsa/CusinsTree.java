package com.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class CusinsTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left =new TreeNode(4);
		root.right =new TreeNode(9);
		
		root.left.left =new TreeNode(1);
		root.left.right =new TreeNode(10);
				
		root.right.left = null;
		root.right.right =new TreeNode(7);
		
		TreeNode node = replaceValueInTree(root);
		System.out.println("    "+node.left.val);
		System.out.println("  "+node.left.val+"    "+node.right.val);
		System.out.println(node.left.left.val+"  "+node.left.right.val+ (node.right.left!=null?node.right.left:"  ")+"  "+node.right.right.val);

	}
	
//	Solved the problem   using BFS approach.
//
//	step1: Store the PreviousSum/totalSum in variable, by default this    will be root Node vale.
//	step2: Calculate the sum of sibling Node(sibSum).
//	step3: Calculate the sum of all Node at same height and store in currentSum.
//	step4: update the Node with sibSum. 
//	step6: update the Queue<TreeNode>.
	 public static TreeNode replaceValueInTree(TreeNode root) {

		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.offer(root);
		    int previousSum=root.val;
		    while(!queue.isEmpty()){
		        int currentSum=0;
		        int nodeSize=queue.size();
		        for(int i=0;i<nodeSize;i++){
		            int sibSum=0;
		            TreeNode node =queue.poll();           
		            node.val= previousSum-node.val;

		            if(node.left!=null){
		                sibSum += node.left.val;
		            }
		            if(node.right!=null){
		                sibSum += node.right.val;
		            }
		            if(node.left!=null){
		                currentSum += node.left.val;
		                node.left.val=sibSum;
		                queue.offer(node.left);
		            }
		            if(node.right!=null){
		                currentSum += node.right.val;
		                node.right.val=sibSum;
		                queue.offer(node.right);
		            }          
		        }
		        previousSum=currentSum;
		    }
		    return root;  
		    }
	
}
