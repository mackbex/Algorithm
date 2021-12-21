package stack;

import java.util.ArrayList;
import java.util.List;

public class StackWithQueue {
    class MyStack {

        List<Integer> list;

        public MyStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            int value = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return value;
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }
}
