import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1Test {
    val input: List<String> = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
        """.trimIndent().split("\n")

    @Test
    fun part1() {
        assertEquals(7, Day1.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(5, Day1.part2(input))
    }
}
