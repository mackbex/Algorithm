package queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyCircularQueue {

    int[] queue;
    int size;
    int head;
    int tail;
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.size = k;
        this.head = -1;
        this.tail = -1;
    }

    public boolean enQueue(int value) {
       if(isFull()) return false;
       if(isEmpty()) head = 0;

       tail = (tail + 1) % size;
       queue[tail] = value;
       return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        if(head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return queue[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return !isEmpty() && (tail + 1) % size == head;
    }
}


