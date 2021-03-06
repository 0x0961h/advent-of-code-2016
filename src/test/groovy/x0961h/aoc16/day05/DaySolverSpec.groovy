package x0961h.aoc16.day05

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 05.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == code

        where:

            input || code

            "abc" || "18f47a30"
    }
}
