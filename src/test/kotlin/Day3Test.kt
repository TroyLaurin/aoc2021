import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day3Test {
    val input = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent().split("\n")

    @Test
    fun part1() {
        assertEquals(Pair(22, 9), Day3.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(Pair(23, 10), Day3.part2(input))
    }

}