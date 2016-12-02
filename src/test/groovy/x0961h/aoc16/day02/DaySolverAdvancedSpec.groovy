package x0961h.aoc16.day02

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 02.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(input) == code

        where:

            input   || code

            "ULL\n" +
            "RRDDD\n" +
            "LURDL\n" +
            "UUUUD" || "5DB3"
    }
}
