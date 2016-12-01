package x0961h.aoc16.day01

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 01.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(input) == distance

        where:

            input            || distance

            "R8, R4, R4, R8" || 4
    }
}
