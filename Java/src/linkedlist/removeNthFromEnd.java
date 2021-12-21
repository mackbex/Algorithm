package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.stream.Stream;

public class removeNthFromEnd {
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

        ListNode res = removeNthFromEnd2(node, idx);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        if (head == null || head.next == null) return null;

        ListNode front = head, back = head;
        while(n-- > 0) front = front.next;

        while(front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) return null;
        ListNode front = head, back = head;
        while(n-- > 0) front = front.next;
        if(front == null) return head.next;
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }

}
