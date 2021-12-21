package queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.stream.Stream;

public class ZeroOneMatrix {

    static Stream<Arguments> methodProvider() {
        return Stream.of(Arguments.of(
                (Object) new int[][]{
                        {0,0,0},
                        {0,1,0},
                        {1,1,1}
                }
        ));
    }

    @ParameterizedTest
    @MethodSource("methodProvider")
    public void updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        LinkedList<Integer[]> queue = new LinkedList<>();

        int[][] result = new int[rows][cols];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == 0) {
                    result[row][col] = 0;
                    queue.add(new Integer[]{row,col});
                }
                else {
                    result[row][col] = 10000;
                }
            }
        }

        while(queue.size() > 0){
            Integer[] location = queue.pop();
            int currentRow = location[0];
            int currentCol = location[1];

            if(currentRow > 0){
                if(result[currentRow-1][currentCol] > result[currentRow][currentCol]+1){
                    result[currentRow-1][currentCol] = result[currentRow][currentCol]+1;
                    queue.add(new Integer[]{currentRow-1,currentCol});
                }
            }
            if(currentRow < rows-1){
                if(result[currentRow+1][currentCol] > result[currentRow][currentCol]+1){
                    result[currentRow+1][currentCol] = result[currentRow][currentCol]+1;
                    queue.add(new Integer[]{currentRow+1,currentCol});
                }
            }
            if(currentCol > 0){
                if(result[currentRow][currentCol-1] > result[currentRow][currentCol]+1){
                    result[currentRow][currentCol-1] = result[currentRow][currentCol]+1;
                    queue.add(new Integer[]{currentRow,currentCol-1});
                }
            }
            if(currentCol < cols-1){
                if(result[currentRow][currentCol+1] > result[currentRow][currentCol]+1){
                    result[currentRow][currentCol+1] = result[currentRow][currentCol]+1;
                    queue.add(new Integer[]{currentRow,currentCol+1});
                }
            }
        }

//        return result;
    }
}
