package hashmap;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] a = sc.nextLine().toUpperCase().toCharArray();
        char[] b = sc.nextLine().toUpperCase().toCharArray();


        int cnt = 0;
        int threshold = b.length - 1;
        int sum = 0;
        for(char c : b) { sum += c; }

        int curSum = 0;
        for(int i = 0; i < a.length; i++) {
            curSum += a[i];
            if(i >= threshold) {
                if(curSum == sum) {
                    cnt ++;
                }
                curSum -= a[i-threshold];
            }
        }

        System.out.println(cnt);

    }
}
