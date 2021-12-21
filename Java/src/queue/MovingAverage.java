package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size;
    Queue<Integer> q;
    int sum;
    public MovingAverage(int size) {
        this.size = size;
        this.q = new LinkedList<>();
    }


    double next(int val) {
        // write your code here
        q.add(val);
        sum += val;
        if(q.size() > size) {
            sum -= q.poll();
        }

        return (double) sum / q.size();
    }
}

class test {
    @ParameterizedTest
    @ValueSource(ints = 3)
    void test(int n) {

        MovingAverage ma = new MovingAverage(n);
        Assertions.assertEquals(1,ma.next(1));
        Assertions.assertEquals(5.5,ma.next(10));
        Assertions.assertEquals(4.6,ma.next(3),0.1);
        Assertions.assertEquals(7,ma.next(8));

    }
}
