package x0961h.aoc16.day14

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 16.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        given:

            DaySolverAdvanced.SALT = "abc"

        expect:

            DaySolverAdvanced.solve() == 22551

    }
}
