package EasyProblems;
import LeetCodeDS.TreeNode;

//Problem 101: Symmetric tree: https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {

    public static boolean symmetric = true;

    public static boolean checkTrees(TreeNode node1, TreeNode node2){
        //Checks to see if end nodes are null or not.
        if (node1 == null && node2 == null){
            return true;
        }
        //checks to see if only one branch side of the tree ends
        if (node1 == null || node2 == null){
            return false;
        }
        //Checks to see if value are the same, and if values are the same for children of node
        return ((node1.val == node2.val)&& checkTrees(node1.left,node2.right) && checkTrees(node1.right,node2.left));
    }

    public static boolean solution(TreeNode root){
        if (root == null){
            return true;
        }
        return checkTrees(root.left,root.right);

    }
    public static void main (String[] args){

    }
}
