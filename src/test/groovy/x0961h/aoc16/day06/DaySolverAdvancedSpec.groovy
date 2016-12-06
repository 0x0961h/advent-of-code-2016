package x0961h.aoc16.day06

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 06.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(input) == message

        where:

            input    || message

            "eedadn\n" +
            "drvtee\n" +
            "eandsr\n" +
            "raavrd\n" +
            "atevrs\n" +
            "tsrnev\n" +
            "sdttsa\n" +
            "rasrtv\n" +
            "nssdts\n" +
            "ntnada\n" +
            "svetve\n" +
            "tesnvt\n" +
            "vntsnd\n" +
            "vrdear\n" +
            "dvrsen\n" +
            "enarar" || "advent"
    }
}
