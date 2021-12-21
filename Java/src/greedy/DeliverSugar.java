package greedy;

import org.junit.Test;

public class DeliverSugar {

    @Test
    public void test(){
        int res = 0;
        int n = 18;
        if(n == 4 || n == 7) res = -1;
        else if(n % 5 == 0) res = n/5;
        else if(n % 5 == 1 || n % 5 == 3) res = n / 5 + 1;
        else if(n % 5 == 2 || n % 5 == 4) res = n / 5 + 2;
    }
}
