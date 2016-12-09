package x0961h.aoc16.day09

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 09.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def decompressTest() {
        expect:

            DaySolverAdvanced.solve(input) == length

        where:

            input                     || length

            "ABC(10x3)XYZ(2x2)QZ(3x3)MMNATRA" || -1
//            "X(8x2)(3x3)ABCY"                                          || 20
//            "(27x12)(20x12)(13x14)(7x10)(1x12)A"                       || 241920
//            "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN" || 445
    }
}
