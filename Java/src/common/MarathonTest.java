import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MarathonTest {

    @Test
    public void run() {
        String[] p = {"a","b","c"};
        String[] c = {"b","c"};
        Assert.assertEquals(MarathonTest.solution(p, c), "a");
    }

    public static String solution(String[] part, String[] comp) {
        Arrays.sort(part);
        Arrays.sort(comp);

        String r = "";
        for(int i = 0; i < part.length; i++) {
            if(!part[i].equals(comp[i])) {
                r = part[i];
                break;
            }
        }
        return r;
    }
}