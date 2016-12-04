package x0961h.aoc16.day04

import spock.lang.Specification
import spock.lang.Unroll

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

            "aaaaa-bbb-z-y-x-123[abxyz]"           || 123

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]"   || 123 + 987

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]\n" +
                    "not-a-real-room-404[oarel]"   || 123 + 987 + 404

            "aaaaa-bbb-z-y-x-123[abxyz]\n" +
                    "a-b-c-d-e-f-g-h-987[abcde]\n" +
                    "not-a-real-room-404[oarel]\n" +
                    "totally-real-room-200[decoy]" || 123 + 987 + 404
    }

    @Unroll
    def isRealTest() {
        expect:

            DaySolver.isReal(new RoomIdStruct(roomId)) == isReal

        where:

            roomId                         || isReal

            "aaaaa-bbb-z-y-x-123[abxyz]"   || true
            "a-b-c-d-e-f-g-h-987[abcde]"   || true
            "not-a-real-room-404[oarel]"   || true
            "totally-real-room-200[decoy]" || false
    }
}
