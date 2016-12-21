package x0961h.aoc16.day21

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 21.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve("abcde", algorithm) == result

        where:

            algorithm                                   || result

            "swap position 4 with position 0"           || "ebcda"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b"               || "edcba"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4"             || "abcde"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step"                        || "bcdea"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step\n" +
            "move position 1 to position 4"             || "bdeac"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step\n" +
            "move position 1 to position 4\n" +
            "move position 3 to position 0"             || "abdec"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step\n" +
            "move position 1 to position 4\n" +
            "move position 3 to position 0\n" +
            "rotate based on position of letter b"      || "ecabd"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step\n" +
            "move position 1 to position 4\n" +
            "move position 3 to position 0\n" +
            "rotate based on position of letter b\n" +
            "rotate based on position of letter d"      || "decab"

            "swap position 4 with position 0\n" +
            "swap letter d with letter b\n" +
            "reverse positions 0 through 4\n" +
            "rotate left 1 step\n" +
            "move position 1 to position 4\n" +
            "move position 3 to position 0\n" +
            "rotate based on position of letter b\n" +
            "rotate based on position of letter d\n" +
            "rotate right 2 steps"                      || "abdec"
    }
}


