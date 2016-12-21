package x0961h.aoc16.day17

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 21.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == path

        where:

            input   || path

            "hijkl" || null
//            "ihgpwlah" || "DDRRRD"
//            "kglvqrro" || "DDUDRLRRUDRD"
//            "ulqzkmiv" || "DRURDRUDDLLDLUURRDULRLDUUDDDRR"
    }
}
