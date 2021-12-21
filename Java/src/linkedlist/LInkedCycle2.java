package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.stream.Stream;

public class LInkedCycle2 {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {3,2,0,-4}
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

        ListNode res = nodeCycle(node);
    }

    public ListNode nodeCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                ListNode idx = head;
                while(idx != slow) {
                    idx = idx.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;

    }
}
