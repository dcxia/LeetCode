package EasyProblems;
import LeetCodeResources.TreeNode;

public class PathSum3 {
    public int paths = 0;

    public int travel(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        int val1 = travel(root.left, sum);
        int val2 = travel(root.right, sum);
        return solution(root,sum) + val1 + val2;
    }

    public int solution(TreeNode root, int sum){
        if (root== null){
            return 0;
        }
        int temp = sum - root.val;
        if (sum == 0){
            return 1 + solution(root.left,0) + solution(root.right,0) ;
        }
        return solution(root.left, temp )+ solution(root.right, temp  );
    }

    public static void main(String[] args){


    }
}
