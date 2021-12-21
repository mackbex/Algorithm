package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import kotlin.test.assertEquals
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class HashDuplicated {


    companion object {
        @JvmStatic fun arrayProvider(): Stream<Arguments> {
            return Stream.of(arguments(arrayOf(9, 2, 4, 5, 10, 3, 7, 40, 40)))
        }

    }


    @ParameterizedTest
    @MethodSource("arrayProvider")
    internal fun duplicatedWithQuadra(ar:Array<Int>) {

        var steps = 0
        for(i in ar.indices) {
            for(j in ar.indices) {
                println(steps++)
                if(i != j && ar[i] == ar[j]) {
//                    assertEquals(ar[i], ar[j])

                    println("found")
                    return
                }
            }
        }
        return
    }


    @ParameterizedTest
    @MethodSource("arrayProvider")
    fun duplicateWithSet(ar:Array<Int>) {
        var steps = 0

        var set = HashSet<Int>()

        for(i in ar.indices) {
            println(steps)
            set.add(ar[i])
        }

        print(set)

    }

}