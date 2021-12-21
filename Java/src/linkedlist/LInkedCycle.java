package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ArrayArgumentsProvider;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class LInkedCycle {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {3,2,0,-4}
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

        boolean has = hasCycle(node);
    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }

        return false;

    }
}
