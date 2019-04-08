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


}