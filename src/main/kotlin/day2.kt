import java.io.File

data class Instruction(val direction: String, val distance: Int)

fun String.toInstruction(): Instruction {
    val (direction, distance) = split(" ")
    return Instruction(direction, distance.toInt())
}

class Day2 {
    companion object {
        fun part1(input: List<String>): Pair<Int, Int> =
            input.map(String::toInstruction)
                .fold(Pair(0, 0)) { location, instruction ->
                    when (instruction.direction) {
                        "up" -> Pair(location.first, location.second - instruction.distance)
                        "down" -> Pair(location.first, location.second + instruction.distance)
                        "forward" -> Pair(location.first + instruction.distance, location.second)
                        else -> throw IllegalArgumentException("Unknown direction ${instruction.direction}")
                    }
                }

        fun part2(input: List<String>): Pair<Int, Int> {
            data class Sub(val horizontal: Int, val depth: Int, val aim: Int)

            fun Sub.toPosition(): Pair<Int, Int> = Pair(this.horizontal, this.depth)
            return input.map(String::toInstruction)
                .fold(Sub(0, 0, 0)) { sub, instruction ->
                    when (instruction.direction) {
                        "up" -> Sub(sub.horizontal, sub.depth, sub.aim - instruction.distance)
                        "down" -> Sub(sub.horizontal, sub.depth, sub.aim + instruction.distance)
                        "forward" -> Sub(
                            sub.horizontal + instruction.distance,
                            sub.depth + sub.aim * instruction.distance,
                            sub.aim
                        )
                        else -> throw IllegalArgumentException("Unknown direction ${instruction.direction}")
                    }
                }.toPosition()
        }
    }
}

fun main() {
    val input = File("day2.txt").readLines()
    println("Day 2")
    val part1 = Day2.part1(input)
    println("  part 1: $part1 (${part1.first * part1.second})")
    val part2 = Day2.part2(input)
    println("  part 1: $part2 (${part2.first * part2.second})")
}
