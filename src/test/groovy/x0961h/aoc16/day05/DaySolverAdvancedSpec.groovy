package x0961h.aoc16.day05

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 05.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(input) == code

        where:

            input || code

            "abc" || "05ace8e3"
    }
}
