package hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HappyNumber {

    @ParameterizedTest
    @ValueSource(ints = {19})
    void test(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        Assertions.assertEquals(1, fast);
    }

    int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int s = n % 10;
            n = n / 10;
            total += s * s;
        }

        return total;
    }

}
