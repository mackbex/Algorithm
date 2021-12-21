package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.stream.Stream;

public class Reverse {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {1,2,3,4,5,7,8},
                (Object) 4
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals, int idx) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

        ListNode res = recursive(node);
    }

    ListNode iteration(ListNode node) {

       ListNode cur = null;
       while(node != null) {
           ListNode next = node.next; //2,3,4,5 -> 3,4,5
           node.next = cur; // null -> 1
           cur = node; // 1 -> 2,1
           node = next; // 2,3,4,5 -> 3,4,5
       }




        return cur;

    }
    ListNode recursive(ListNode node) { // 4
        if(node == null || node.next == null) return node;
        ListNode next = node.next;
        ListNode cur = recursive(next); // 5
        next.next = node; // 4
        node.next = null;


        return cur;
    }

}
