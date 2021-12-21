package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(
                            array = {1,2,3,4,5}
                    )
            }
    )
    public void test(int[] a) {

        ListNode node = ListNodeBuilder.getInstance().build(a).node;

        ListNode temp = node.next.next;
        node.next = temp;

//        ListNode res = reverseList2(node);

        List<Integer> list = new LinkedList<>();

//        list.
//        System.out.println("A");
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = reverseList2(head.next);
        head.next.next = head;
//        head.next = null;
        return node;
    }
    public ListNode reverseList1(ListNode head) {
        //if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null ) {
            ListNode temp = cur.next;  // temp = null;
            cur.next = prev;           // cur.next = null
            prev = cur;                // prev = 2
            cur = temp;                // cur = 2
        }

        return prev;
    }


}
