package x0961h.aoc16.day12

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 12.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == result

        where:

            input            || result

            "cpy 41 a\n" +
            "inc a\n" +
            "inc a\n" +
            "dec a\n" +
            "jnz a 2\n" +
            "dec a"          || [42, 0, 0, 0]
    }
}
