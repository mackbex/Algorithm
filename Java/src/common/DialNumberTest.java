import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DialNumberTest {

    @Test
    public void run() {
        String[] ex = {"12", "123", "1235", "567", "88"};
        DialNumberTest.solution(ex);
    }

    public static boolean solution(String[] phone_book) {

        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}