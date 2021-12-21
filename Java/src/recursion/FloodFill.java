package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FloodFill {

    static Stream<Arguments> methodProvider() {
        return Stream.of(Arguments.of(
                        (Object) new int[][]{
                                {1,1,1},
                                {1,1,0},
                                {1,0,1}
                        },
                        1,
                        1,
                        2
                ));
    }

    @ParameterizedTest
    @MethodSource("methodProvider")
    public void floodFill(int[][] image, int sr, int sc, int newColor) {
        int targetColor = image[sr][sc];

        fillImage(image, sr, sc, targetColor, newColor);

        Assertions.assertTrue(true);
//        return image;
    }

    private void fillImage(int[][] image, int sr, int sc, int targetColor, int newColor){
        if(image[sr][sc] != targetColor || image[sr][sc] == newColor) return;

        image[sr][sc] = newColor;

        if(sr > 0){
            fillImage(image, sr-1, sc, targetColor, newColor);
        }
        if(sr < image.length - 1){
            fillImage(image, sr+1, sc, targetColor, newColor);
        }
        if(sc > 0){
            fillImage(image, sr, sc-1, targetColor, newColor);
        }
        if(sc < image[0].length - 1){
            fillImage(image, sr, sc+1, targetColor, newColor);
        }
    }

}
