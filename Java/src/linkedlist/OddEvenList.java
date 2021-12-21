package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.List;
import java.util.stream.Stream;

public class OddEvenList {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {1,2,3,4,5}
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

//        remove(node, val);


        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode evenHead = even;
        ListNode oddHead = odd;

        while(node != null) {

            if(node.val % 2 == 0) {
                oddHead.next = node;
                oddHead = oddHead.next;
            }
            else {
                evenHead.next = node;
                evenHead = evenHead.next;
            }

            node = node.next;
        }
        System.out.println("A");
//
//        while (even != null && even.next != null) {
//            odd.next = odd.next.next;
//            even.next = even.next.next;
//            odd = odd.next;
//            even = even.next;
//        }
//        odd.next = evenHead;

    }





}
