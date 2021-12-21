package hashmap;

import java.util.Scanner;

public class StudentPresident {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.nextLine();
        s = sc.nextLine();

        int[] list = new int[26];
        for(char c : s.toCharArray()) {
            list[c-'A'] ++;
        }

        int idx = 0;
        for(int i = 0; i < 5 ; i++) {
            idx = list[idx] < list[i] ? i : idx;
        }



        char c = (char) (idx + 'A');

        System.out.println(c);

    }
}
