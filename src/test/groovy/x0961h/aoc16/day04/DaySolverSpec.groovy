package x0961h.aoc16.day04

import spock.lang.Specification
import spock.lang.Unroll

import java.util.regex.Matcher

/**
 * Created by 0x0961h on 04.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def solveTest() {
        expect:

            DaySolver.solve(input) == count

        where:

            input                                  || count

            "aaaaa-bbb-z-y-x-123[abxyz]"           || 1

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]"   || 2

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]\n" +
                    "not-a-real-room-404[oarel]"   || 3

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]\n" +
                    "not-a-real-room-404[oarel]\n" +
                    "totally-real-room-200[decoy]" || 3
    }

    @Unroll
    def isRealTest() {
        when:

            Matcher mat = DaySolver.roomIdPattern.matcher(roomId)

            if (!mat.find()) throw new RuntimeException("Incorrect input: " + roomId)

            String name = mat.group(1)
            String checksum = mat.group(3)

        then:

            DaySolver.isReal(name, checksum) == isReal

        where:

            roomId                         || isReal

            "aaaaa-bbb-z-y-x-123[abxyz]"   || true
            "a-b-c-d-e-f-g-h-987[abcde]"   || true
            "not-a-real-room-404[oarel]"   || true
            "totally-real-room-200[decoy]" || false
    }
}
