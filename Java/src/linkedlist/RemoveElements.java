package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.stream.Stream;

public class RemoveElements {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {1,2,3,4,5,7,4},
                (Object) 4
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals, int val) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

//        remove(node, val);

        ListNode cur = node;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else
                cur = cur.next;
        }
    }

    ListNode removeIterate(ListNode node, int val) {
        while(node != null && node.val == val)
        {
            node = node.next;
        }
        ListNode temp = node;
        while(temp != null && temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }

        return node;
    }
    ListNode remove(ListNode node, int val) {
        if(node == null) return null;
        node.next = remove(node.next, val);
        if(node.val == val) return node.next;

        return node;

    }



}
