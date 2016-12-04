package x0961h.aoc16.day04

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 04.12.16.
 */
class DaySolverAdvancedSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolverAdvanced.decrypt(new RoomIdStruct(encryptedName)).realName == decryptedName

        where:

            encryptedName                    || decryptedName

            "qzmt-zixmtkozy-ivhz-343[check]" || "very encrypted name"
    }
}
