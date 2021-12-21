package string;

import org.junit.Test;

import java.util.Scanner;

public class OppositeCase {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        char[] a = in.nextLine().toCharArray();
        for(int i = 0; i < a.length; i++) {
            if(65 <= a[i] && 90 >= a[i]) {
                a[i] += 32;
            }
            else if(97 <= a[i] && a[i] <= 122) {
                a[i] -= 32;
            }
        }
        System.out.println(a);
    }

//    System.out.println(input1 + input2);
}
