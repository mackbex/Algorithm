package queue;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class NumberOfIsle {
    int[] nX = {0, 1, 0, -1};
    int[] nY = {-1, 0, 1, 0};

    static Stream<Arguments> mapProvider() {
        return Stream.of(
                Arguments.of((Object) new char[][] {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("mapProvider")
    void noi(char[][] grid) {
        int cnt = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    cnt ++;
                }
            }
        }


        Assertions.assertEquals(3,cnt);
    }

    void dfs(char[][] grid, int i,int j) {

        grid[i][j] = '0';
        for(int n_i = 0; n_i < 4; n_i++) {
            int r = i + nX[n_i];
            int c = j + nY[n_i];

            if(
                    r >= 0
                    && r < grid.length
                    && c >= 0
                    && c < grid[0].length
                    && grid[r][c] =='1'
            )
            {
                dfs(grid, r, c);
            }
        }
    }

    void bfs(char[][] grid, int i,int j) {

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j] = '2';

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int n_i = 0; n_i < 4; n_i ++) {
                int r = cur[0] + nX[n_i];
                int c = cur[1] + nY[n_i];

                if(
                        r >= 0
                        && r < grid.length
                        && c >= 0
                        && c < grid[0].length
                        && grid[r][c] =='1'
                ) {
                    grid[r][c] = '2';
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}
