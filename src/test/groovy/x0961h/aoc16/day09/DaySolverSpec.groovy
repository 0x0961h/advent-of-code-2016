package x0961h.aoc16.day09

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 09.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def decompressTest() {
        expect:

            DaySolver.decompress(input) == result

        where:

            input               || result

            "ADVENT"            || "ADVENT"
            "A(1x5)BC"          || "ABBBBBC"
            "(3x3)XYZ"          || "XYZXYZXYZ"
            "A(2x2)BCD(2x2)EFG" || "ABCBCDEFEFG"
            "(6x1)(1x3)A"       || "(1x3)A"
            "X(8x2)(3x3)ABCY"   || "X(3x3)ABC(3x3)ABCY"
    }
}
