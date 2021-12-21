package hashmap;

import java.util.*;

public class SalesTypeForEachConsecutive4DaysSection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int section = sc.nextInt();
        int[] amount = new int[days];
        for(int i = 0; i < days; i++) {
            amount[i] = sc.nextInt();
        }


        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < section-1; i++) {
            map.put(amount[i], map.getOrDefault(amount[i],0)+1);
        }

        int lt = 0;
        List<Integer> res = new ArrayList<>();
        for(int rt = section - 1; rt < days; rt++) {
            map.put(amount[rt],map.getOrDefault(amount[rt],0)+1);
            res.add(map.size());
            map.put(amount[lt], map.get(amount[lt]) - 1);
            if(map.get(amount[lt]) == 0) map.remove(amount[lt]);
            lt++;
        }




        for(int n : res) {
            System.out.print(n + " ");
        }
    }
}
