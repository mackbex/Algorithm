package sort

import org.junit.jupiter.params.ParameterizedTest
import org.junit.Assert.*
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class BubbleSortTest {

    companion object {
        @JvmStatic fun arrayProvider(): Stream<Arguments> {
            return Stream.of(arguments(arrayOf(9,2,4,5,10,3,7,40)))
        }
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun BubbleSort(array:Array<Int>) {

        var unsortedUntilIndex = array.size - 1
        var sorted = false

        while (!sorted) {
            sorted = true
            for(i in 0 until unsortedUntilIndex) {
                if(array[i] > array[i+1]) {
                    sorted = false
                    val temp = array[i]
                    array[i] = array[i+1]
                    array[i+1] = temp
                }
            }
            unsortedUntilIndex -= 1
        }

        assertTrue(array.contentEquals(arrayOf(2,3,4,5,7,9,10,40)))

    }
}