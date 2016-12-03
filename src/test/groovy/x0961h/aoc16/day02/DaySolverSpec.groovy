package x0961h.aoc16.day02

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 02.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == code

        where:

            input                      || code

            "ULL\nRRDDD\nLURDL\nUUUUD" || "1985"
    }
}
