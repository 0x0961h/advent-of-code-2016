package x0961h.aoc16.day13

import spock.lang.Specification
import spock.lang.Unroll
import x0961h.aoc16.utils.Point

/**
 * Created by 0x0961h on 12.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(10, 7, 4) == 11

    }

    @Unroll
    def wallTest() {
        expect:

            DaySolver.isWall(10, new Point(x, y)) == result

        where:

            x || y || result

            0 || 0 || false
            0 || 1 || false
            1 || 1 || false
            7 || 5 || false
            9 || 2 || false

            1 || 0 || true
            1 || 3 || true
            9 || 0 || true
            0 || 6 || true
            4 || 3 || true
    }
}
