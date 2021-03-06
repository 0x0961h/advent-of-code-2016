package x0961h.aoc16.day14

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 16.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        given:

            DaySolver.SALT = "abc"

        expect:

            DaySolver.solve() == 22728

    }
}
