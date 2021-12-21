package linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class isPalindrome {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new Integer[] {1,2,3,2,1}
        ));
    }
    ListNode frontier = null;
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(Integer[] vals) {

        ListNode node = ListNodeBuilder.getInstance().build(vals).node;

        frontier = node;
        recursive(node);

    }

    boolean iterate(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }


        for(int i = 0; i < list.size() / 2; i++) {

            int first = list.get(i);
            int last = list.get(list.size() - i - 1);

            if(first != last) {
                return false;
            }
        }

        return true;
    }

    boolean recursive(ListNode node) {
        if(node != null) {
            if(!recursive(node.next)) return false;
            if(node.val != frontier.val) return false;

            frontier = frontier.next;
        }

        return true;
    }

}
