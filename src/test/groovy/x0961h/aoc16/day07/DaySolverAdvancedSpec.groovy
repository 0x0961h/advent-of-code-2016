package x0961h.aoc16.day07

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 06.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def tlsCheckTest() {
        expect:

            DaySolverAdvanced.checkSslSupport(ipv7) == result

        where:

            ipv7            || result

            "aba[bab]xyz"   || true
            "xyx[xyx]xyx"   || false
            "aaa[kek]eke"   || true
            "zazbz[bzb]cdb" || true
    }
}
