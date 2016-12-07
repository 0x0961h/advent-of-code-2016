package x0961h.aoc16.day07

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 06.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def tlsCheckTest() {
        expect:

            DaySolver.checkTlsSupport(ipv7) == result

        where:

            ipv7                   || result

            "abba[mnop]qrst"       || true
            "abcd[bddb]xyyx"       || false
            "aaaa[qwer]tyui"       || false
            "ioxxoj[asdfgh]zxcvbn" || true
    }
}
