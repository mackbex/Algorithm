package string;

import org.junit.Test;

import java.util.Scanner;

public class CharCnt {

    @Test
    void test() {
        int cnt = 0;

        Scanner in=new Scanner(System.in);
        char[] a = in.nextLine().toUpperCase().toCharArray();
        char b = in.nextLine().toUpperCase().charAt(0);

        for(int i = 0; i < a.length; i++) {
            if(a[i] == b) {
                cnt ++;
            }
        }
        System.out.println(cnt);
    }

//    System.out.println(input1 + input2);
}
