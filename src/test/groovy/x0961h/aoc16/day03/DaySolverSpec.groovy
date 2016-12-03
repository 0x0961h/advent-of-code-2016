package x0961h.aoc16.day03

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 03.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == count

        where:

            input     || count

            "5 10 25" || 0
    }
}
