import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SpyTest {

    @Test
    public void run() {
        String[][] cloths = {
                {"yellowhat","headgear"},
                {"bluesunglasses","eyewear"},
                {"green_turban","headgear"}
        };

        SpyTest.solution(cloths);
//        Assert.assertEquals(SpyTest.solution(cloths), false);
    }


    public static String solution(String[][] cloths) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : cloths) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0) + 1);
        }

//        while(map.values().iterator().ne)

        return "true";
    }
}