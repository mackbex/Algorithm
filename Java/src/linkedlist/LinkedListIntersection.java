package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.stream.Stream;

public class LinkedListIntersection {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {3,2,0,-4,6,9},
                (Object) new Integer[] {5,7,1,6,9}
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals1,Integer[] vals2) {

        ListNode node1 = ListNodeBuilder.getInstance().build(vals1).node;
        ListNode node2 = ListNodeBuilder.getInstance().build(vals2).node;



        ListNode res = nodeCycle(node1, node2);
    }

    public ListNode nodeCycle(ListNode a,ListNode b) {

        //boundary check
        if(a == null || b == null) return null;

        ListNode aa = a;
        ListNode bb = b;


        while(aa != bb) {
            aa = aa == null ? b : aa.next;
            bb = bb == null ? a : bb.next;
        }

        return a;

    }
}
