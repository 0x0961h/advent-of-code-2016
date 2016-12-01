package x0961h.aoc16.day01

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 01.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == distance

        where:

            input            || distance

            "R2, L3"         || 5
            "R2, R2, R2"     || 2
            "R5, L5, R5, R3" || 12

    }
}
