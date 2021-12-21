package queue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.LinkedList;
import java.util.Stack;

public class QueueWithStack {
    class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        int front;
        public MyQueue() {
            this.s1 = new Stack();
            this.s2 = new Stack();
        }

        public void push(int x) {
            if(s1.empty()) {
                front = x;
            }
            s1.push(x);

//            if (s1.empty())
//                front = x;
//            while (!s1.isEmpty())
//                s2.push(s1.pop());
//            s2.push(x);
//            while (!s2.isEmpty())
//                s1.push(s2.pop());
        }

        public int pop() {
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        public int peek() {
            if(!s2.isEmpty()) {
                return s2.peek();
            }
            return front;
        }
    }

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

}
