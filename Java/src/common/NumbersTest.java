import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class NumbersTest {

    @Test
    public void run() {
        NumbersTest test = new NumbersTest();
        test.solution("12");
    }

    HashSet<Integer> set = new HashSet<>();
    public void recursive(String comb, String others) {
        if(!comb.equals("")) {
            System.out.println(comb);
            set.add(Integer.valueOf(comb));
        }
        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i),
                    others.substring(0, i) + others.substring(i+1));
        }

    }

    public int solution(String numbers) {
        recursive("", numbers);


        int answer = 0;
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()) {
            int num = it.next();
            if(num == 2) answer++;
            if(num%2 != 0 && isPrime(num)) answer ++;

        }
        return answer;
    }

    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;

        int lim = (int)Math.sqrt(num);

        for(int i = 3; i <= lim; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }


}