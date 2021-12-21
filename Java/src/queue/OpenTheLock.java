package queue;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

public class OpenTheLock {

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[] {"0201","0101","0102","1212","2002"},
                        "0202")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void otl(String[] deadends, String target) {

        Queue<Integer> tries = new LinkedList<Integer>();
        Set<Integer> deadendLocks = new HashSet();

        int targetLock = Integer.parseInt(target);

        for(String deadend : deadends) {
            deadendLocks.add(Integer.parseInt(deadend));
        }

        int cnt = bfs(targetLock, tries, deadendLocks);

        Assert.assertEquals(6, cnt);
    }

    int bfs(int targetLock, Queue<Integer> tries, Set<Integer> deadendLocks) {

        int resCnt = 0;
        Set<Integer> triedLocks = new HashSet();

        tries.add(0000);

        while(!tries.isEmpty()) {
            int triesCnt = tries.size();

            for(int i = 0; i < triesCnt; i++) {
                int trying = tries.poll();
                if(deadendLocks.contains(trying) || triedLocks.contains(trying)) {
                    continue;
                }

                if(trying == targetLock) {
                    return resCnt;
                }

                int pos1 = trying % 10;
                tries.add((trying - pos1) + (pos1 + 1) % 10);
                tries.add((trying - pos1) + (pos1 - 1 + 10) % 10);

                int pos2 = ((trying - trying % 10) / 10) % 10;
                tries.add((trying - pos2 * 10) + ((pos2 + 1) % 10) * 10);
                tries.add((trying - pos2 * 10) + ((pos2 - 1 + 10) % 10) * 10);

                int pos3 = ((trying - trying % 100) / 100) % 10;
                tries.add((trying - pos3 * 100) + ((pos3 + 1) % 10) * 100);
                tries.add((trying - pos3 * 100) + ((pos3 - 1 + 10) % 10) * 100);

                int pos4 = ((trying - trying % 1000) / 1000) % 10;
                tries.add((trying - pos4 * 1000) + ((pos4 + 1) % 10) * 1000);
                tries.add((trying - pos4 * 1000) + ((pos4 - 1 + 10) % 10) * 1000);

                triedLocks.add(trying);

            }
            resCnt++;
        }

        return -1;
    }
}
