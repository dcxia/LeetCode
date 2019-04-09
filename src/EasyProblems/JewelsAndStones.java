package EasyProblems;
//https://leetcode.com/problems/jewels-and-stones
import java.util.*;

public class JewelsAndStones {

    public static int solution(String J, String S){
        int count = 0;

        Set<Character> gems = new HashSet<Character>();
        for (int i = 0; i < J.length();i++){
            gems.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i ++){
            if (gems.contains(S.charAt(i))){
               count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(solution("aA","aAAbbBB"));


    }
}
