package edu.miu.validateBinarySearchTree;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left=left;
        root.right=right;

        System.out.println(isValidBST(root));

    }

    public  static boolean isValidBST(TreeNode root) {

        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean validate(TreeNode root,int min,int max){

        if(root==null)
            return true;
        else if(root.val<=min ||root.val>=max)
            return false;
        else if(!validate(root.left,min,root.val))
            return false;
        else if(!validate(root.right,root.val,max))
            return false;

        return true;


    }
}
class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
         this.right = right;
     }
 }
