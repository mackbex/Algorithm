import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class LRUTest {
    
    @Test
    public void test() {
    
        LRUTest test = new LRUTest();
        int[] t = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        System.out.println(test.solution(5, 9, t));
    }

    int[] solution(int size, int n, int[] arr) {
        int[] bucket = new int[size];

        for(int i = 0; i < n; i++) {
            int cur = arr[i];
            int pos = size - 1;
            for(int j = 0; j < size; j++) if(cur == bucket[j]) {
                pos = j;
                break;
            }
            for(int j = pos; j >= 1; j--) bucket[j] = bucket[j-1];
        
            bucket[0] = cur;
        }

        return bucket;
    }
}
