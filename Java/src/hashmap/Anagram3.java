package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();


        Map<Character, Integer> bm = new HashMap<>();
        for(char c : b) { bm.put(c, bm.getOrDefault(c,0)+1); }
        Map<Character, Integer> am = new HashMap<>();
        for(int i = 0; i< b.length - 1; i++) { am.put(a[i], am.getOrDefault(a[i],0)+1); }

        int cnt = 0;
        for(int i = b.length - 1; i < a.length; i++) {
            am.put(a[i],am.getOrDefault(a[i],0) + 1);
            if(am.equals(bm)) cnt ++;
            am.put(a[i], am.get(a[i])-1);
            if(am.get(a[i]) == 0) am.remove(a[i]);

        }

        System.out.println(cnt);

    }
}
