package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReversedPrime {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        List<Integer> n = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ReversedPrime T = new ReversedPrime();
        List<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < n.size(); i ++) {
            int cur = n.get(i);
            int resVal = 0;
            while(cur > 0) {
                int t = cur % 10;
                resVal = resVal * 10 + t;
                cur = cur / 10;
            }

            if(T.isPrime(cur)) res.add(cur);
        }
    }

    public boolean isPrime(int n) {

        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for(int i = 5; i * i  <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }
}
