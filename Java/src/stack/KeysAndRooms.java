package stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class KeysAndRooms {

    static Stream<List<List<Integer>>> paramProvider() {
        return Stream.of(
                List.of(
                        List.of(1,3),
                        List.of(3,0,1),
                        List.of(2),
                        List.of(0)
                ));
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(List<List<Integer>> room) {
        canVisitAllRooms(room);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei: rooms.get(node))
                if (!seen[nei]) {
                    seen[nei] = true;
                    stack.push(nei);
                }
        }

        for (boolean v: seen)
            if (!v) return false;
        return true;
    }
}
