package queue;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

    @ParameterizedTest
    @ValueSource(ints = 13)
    void ps(int n) {

       int res = bfs(n);

        Assertions.assertEquals(3, res);
    }

    int bfs(int n) {
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        int level  = 0;

        while(!q.isEmpty()) {
            level++;
            int prev = q.size();
            for(int i = 0; i < prev; i++) {
                int base = q.poll();
                for(int sq = 1; sq * sq <= n - base; sq++ ) {
                    int sum = base + sq * sq;
                    if(visited.contains(sum) || sum > n) continue;;

                    if(sum == n)
                        return level;
                    else {
                        q.add(sum);
                        visited.add(sum);
                    }
                }
            }
        }

        return -1;
    }
}
