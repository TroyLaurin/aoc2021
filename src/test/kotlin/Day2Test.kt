import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {
    val input = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.trimIndent().split("\n")

    @Test
    fun part1() {
        assertEquals(Pair(15, 10), Day2.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(Pair(15, 60), Day2.part2(input))
    }

}