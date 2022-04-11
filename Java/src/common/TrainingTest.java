import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class TrainingTest {

    @Test
    public void run() {
        
        TrainingTest test = new TrainingTest();
        int[] lost = {2,4};
        int[] res = {1,3,5};
        assertEquals(test.solution(5,lost,res), 5);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
    
        int[] student = new int[n+2];

        for(int i = 0; i < reserve.length; i++) {
            student[reserve[i]] ++;
        }

        for(int i = 0; i < lost.length; i++) {
            student[lost[i]] --;
        }
        

        int left = 0;
        for(int i = 0; i < student.length; i++) {
            if(student[i] == -1) {
                if(student[i-1] == 1) {
                    student[i-1]--;
                    student[i]++;
                }
                else if(student[i+1] == 1) {
                    student[i+1]--;
                    student[i]++;
                }
                else {
                    left++;
                }
            }
        }

        return n - left;
    }
}