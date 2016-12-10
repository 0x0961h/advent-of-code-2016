package x0961h.aoc16.day10

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 10.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def decompressTest() {
        when:

            DaySolver.solve("value 5 goes to bot 2\n" +
                    "bot 2 gives low to bot 1 and high to bot 0\n" +
                    "value 3 goes to bot 1\n" +
                    "bot 1 gives low to output 1 and high to bot 0\n" +
                    "bot 0 gives low to output 2 and high to output 0\n" +
                    "value 2 goes to bot 2")

        then:

            true
    }
}
