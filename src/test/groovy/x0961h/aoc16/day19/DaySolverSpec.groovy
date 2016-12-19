package x0961h.aoc16.day19

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 19.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(5) == 3

    }
}
