package EasyProblems;
import LeetCodeDS.ListNode;

public class MergeTwoSortedLists {
    public ListNode solution(ListNode l1, ListNode l2){

        //recursive return statement
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }

        if (l1.val <= l2.val){
            l1.next = solution(l1.next, l2);
            return l1;
        }else{
            l2.next = solution(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args){

    }

}
