package hashmap;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] a = sc.nextLine().toUpperCase().toCharArray();
        char[] b = sc.nextLine().toUpperCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        String res = "YES";
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) res = "NO";
        }

//        System.out.println(c);

    }
}
