package EasyProblems;

import LeetCodeDS.TreeNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//Written in Junit 5
class EasyProblemsTest {

    private EasyProblems easy;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        easy = new EasyProblems();

    }

    @Disabled
    @Test
    void twoSum(){
        int[] nums = new int[]{3,3};
        int target = 6;

        int[] out = new int[] {0,1};
        assertTrue(Arrays.equals(out,easy.twoSum(nums, target)));
    }

    @Disabled
    @Test
    void hammingDistance(){
        assertTrue(easy.hammingDistance(4,1) == 2);
    }

    void instantiateTreeNode(TreeNode node, TreeNode left, TreeNode right, int val){
        node.left  = left;
        node.right = right;
        node.val = val;
    }

    @Test
    void mergeTrees(){
        TreeNode t1 = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t4 = new TreeNode();
        TreeNode t3 = new TreeNode();

        TreeNode t5 = new TreeNode();
        TreeNode t6 = new TreeNode();
        TreeNode t7 = new TreeNode();
        TreeNode t8 = new TreeNode();
        TreeNode t9 = new TreeNode();

        //instantiateTreeNode(t1, t2, t3);
    }
}