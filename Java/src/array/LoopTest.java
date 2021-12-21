package array;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LoopTest {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<Integer> n1 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> n2 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //1 : Scissors
        //2 : Rock
        //3 : Paper
        List<Character> res = new ArrayList<>();
        for(int i = 0; i < n1.size(); i++) {

            if(n1.get(i) > n2.get(i)) res.add('A');
            else if(n1.get(i) == 1 && n2.get(i) == 3) res.add('A');
            else if(n1.get(i) == 2 && n2.get(i) == 1) res.add('A');
            else if(n1.get(i) == 3 && n2.get(i) == 2) res.add('A');
            else res.add('B');

        }

        for(char c : res) {
            System.out.println(c);
        }
    }
}
