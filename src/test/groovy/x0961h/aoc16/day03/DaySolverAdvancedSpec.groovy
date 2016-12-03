package x0961h.aoc16.day03

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 03.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.solve(
                    "  101 301  501\n" +
                            "  102  302 502\n" +
                            "  103   303   503\n" +
                            "  201 401 601\n" +
                            "  202  402 602\n" +
                            "  203 403    603"
            )
    }
}
