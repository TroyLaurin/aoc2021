import java.io.File

class Day1 {
    companion object {
        fun part1(input: List<String>): Int =
            input.map(String::toInt)
                .zipWithNext()
                .count { (a, b) -> b > a }

        fun part2(input: List<String>): Int =
            input.asSequence()
                .map(String::toInt)
                .windowed(3)
                .map(Iterable<Int>::sum)
                .zipWithNext()
                .count { (a, b) -> b > a }
    }
}

fun main() {
    val input = File("day1.txt").readLines()
    println("Day 1")
    println("  part 1: ${Day1.part1(input)}")
    println("  part 2: ${Day1.part2(input)}")
}
