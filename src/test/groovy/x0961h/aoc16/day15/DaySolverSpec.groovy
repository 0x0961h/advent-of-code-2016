package x0961h.aoc16.day15

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 15.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve("Disc #1 has 5 positions; at time=0, it is at position 4.\n" +
                            "Disc #2 has 2 positions; at time=0, it is at position 1.") == 5

    }
}
