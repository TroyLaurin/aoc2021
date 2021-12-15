import java.io.File

class Day3 {
    companion object {
        fun part1(input: List<String>): Pair<Int, Int> {
            val occurrences = input.fold(Array<Pair<Int, Int>>(input[0].length) { Pair(0, 0) }) { acc, s ->
                acc.apply {
                    for ((i, ch) in s.withIndex()) {
                        if (ch == '1')
                            this[i] = Pair(this[i].first, this[i].second + 1)
                        else
                            this[i] = Pair(this[i].first + 1, this[i].second)
                    }
                }
            }

            val gamma = occurrences.fold("") { acc, (zeroes, ones) ->
                acc + if (zeroes > ones) '0' else '1'
            }
            val epsilon = occurrences.fold("") { acc, (zeroes, ones) ->
                acc + if (zeroes > ones) '1' else '0'
            }

            return Pair(gamma.toInt(2), epsilon.toInt(2))
        }

        fun part2(input: List<String>): Pair<Int, Int> {
            fun List<String>.findRating(keep: Pair<Int, Int>.(Char) -> Boolean): String {
                val remaining = this.toMutableList()
                for (i in this[0].indices) {
                    if (remaining.size == 1) return remaining[0]

                    val counts = input.fold(Pair(0, 0)) { (zeroes, ones), str ->
                        if (str[i] == '1')
                            Pair(zeroes, ones + 1)
                        else
                            Pair(zeroes + 1, ones)
                    }

                    remaining.removeIf { !counts.keep(it[i]) }
                }
                throw IllegalStateException("Still have ${remaining.size} lines left")
            }

            val oxyGenRating = input.findRating { it == if (first > second) '0' else '1' }
            val co2ScrubRating = input.findRating { it == if (second > first) '0' else '1' }

            return Pair(oxyGenRating.toInt(2), co2ScrubRating.toInt(2))
        }
    }
}

fun main() {
    val input = File("day3.txt").readLines()
    println("Day 3")
    val part1 = Day3.part1(input)
    println("  part 1: $part1 (${part1.first * part1.second})")
    val part2 = Day3.part2(input)
    println("  part 2: $part2 (${part2.first * part2.second})")
}
