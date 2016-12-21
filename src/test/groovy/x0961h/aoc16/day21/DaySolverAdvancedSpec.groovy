package x0961h.aoc16.day21

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 21.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def letterBasedRotateTest() {
        when:

            def result = DaySolver.solve("abcdefgh", "rotate based on position of letter " + letter)

        then:

            result == expectedResult

            def i0 = "abcdefgh".indexOf(letter)
            def i1 = result.indexOf(letter)

            println "${i0} -> ${i1} (${i0 - i1})"

        where:

            letter || expectedResult

            "a"    || "habcdefg"
            "b"    || "ghabcdef"
            "c"    || "fghabcde"
            "d"    || "efghabcd"

            "e"    || "cdefghab"
            "f"    || "bcdefgha"
            "g"    || "abcdefgh"
            "h"    || "habcdefg"
    }

    @Unroll
    def letterBasedRotateDecryptionTest() {
        expect:

            DaySolverAdvanced.solve(input, "rotate based on position of letter " + letter) == "abcdefgh"

        where:

            letter || input

            "a"    || "habcdefg"
            "b"    || "ghabcdef"
            "c"    || "fghabcde"
            "d"    || "efghabcd"

            "e"    || "cdefghab"
            "f"    || "bcdefgha"
            "g"    || "abcdefgh"
            "h"    || "habcdefg"
    }

    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(input, algorithm) == "abcde"

        where:

            algorithm                                   || input

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


