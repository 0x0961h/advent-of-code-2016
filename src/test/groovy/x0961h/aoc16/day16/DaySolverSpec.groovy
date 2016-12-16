package x0961h.aoc16.day16

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 16.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(20, "10000") == "01100"

    }

    @Unroll
    def dragonCurveTest() {
        expect:

            DaySolver.dragonCurve(input) == output

        where:

            input          || output

            "1"            || "100"
            "0"            || "001"
            "11111"        || "11111000000"
            "111100001010" || "1111000010100101011110000"
            "10000"        || "10000011110"
            "10000011110"  || "10000011110010000111110"
    }

    @Unroll
    def generateChecksumTest() {
        expect:

            DaySolver.generateChecksum(input) == checksum

        where:

            input                  || checksum

            "110010110100"         || "100"
            "10000011110010000111" || "01100"

    }
}
