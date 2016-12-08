package x0961h.aoc16.day08

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by 0x0961h on 08.12.16.
 */
class DaySolverSpec extends Specification {
    @Unroll
    def drawRectTest() {
        given:

            Boolean[][] screen = new Boolean[screenHeight][screenWidth]

        when:

            DaySolver.drawRect(screen, rectWidth, rectHeight)

        then:

            println "Result:\n"
            println DaySolver.render(screen)
            println ""

            println "Expected:\n"
            println expectedResult
            println ""

            DaySolver.render(screen) == expectedResult

        where:

            screenWidth || screenHeight || rectWidth || rectHeight || expectedResult

            4           || 3            || 1         || 1          || "#...\n" +
                                                                      "....\n" +
                                                                      "...."

            4           || 3            || 2         || 1          || "##..\n" +
                                                                      "....\n" +
                                                                      "...."

            4           || 3            || 1         || 2          || "#...\n" +
                                                                      "#...\n" +
                                                                      "...."

            4           || 3            || 2         || 2          || "##..\n" +
                                                                      "##..\n" +
                                                                      "...."

            4           || 3            || 3         || 2          || "###.\n" +
                                                                      "###.\n" +
                                                                      "...."

            4           || 3            || 9         || 9          || "####\n" +
                                                                      "####\n" +
                                                                      "####"
    }

    @Unroll
    def rotateTest() {
        given:

            Boolean[][] screen = new Boolean[screenHeight][screenWidth]
            DaySolver.drawRect(screen, 3, 2)

        when:

            DaySolver.rotateScreen(screen, byColumn, index, amount)

        then:

            println "Result:\n"
            println DaySolver.render(screen)
            println ""

            println "Expected:\n"
            println expectedResult
            println ""

            DaySolver.render(screen) == expectedResult

        where:

            screenWidth || screenHeight || byColumn || index || amount || expectedResult

            4           || 3            || true     || 0     || 1      || ".##.\n" +
                                                                          "###.\n" +
                                                                          "#..."

            4           || 3            || true     || 2     || 1      || "##..\n" +
                                                                          "###.\n" +
                                                                          "..#."

            4           || 3            || true     || 1     || 1      || "#.#.\n" +
                                                                          "###.\n" +
                                                                          ".#.."

            4           || 3            || true     || 1     || 2      || "###.\n" +
                                                                          "#.#.\n" +
                                                                          ".#.."

            4           || 3            || true     || 1     || 3      || "###.\n" +
                                                                          "###.\n" +
                                                                          "...."

            4           || 3            || false    || 0     || 1      || ".###\n" +
                                                                          "###.\n" +
                                                                          "...."

            4           || 3            || false    || 2     || 1      || "###.\n" +
                                                                          "###.\n" +
                                                                          "...."

            4           || 3            || false    || 1     || 1      || "###.\n" +
                                                                          ".###\n" +
                                                                          "...."

            4           || 3            || false    || 1     || 2      || "###.\n" +
                                                                          "#.##\n" +
                                                                          "...."

            4           || 3            || false    || 1     || 3      || "###.\n" +
                                                                          "##.#\n" +
                                                                          "...."

            4           || 3            || false    || 1     || 4      || "###.\n" +
                                                                          "###.\n" +
                                                                          "...."

    }

    @Unroll
    def solveTest() {
        given:

            Boolean[][] screen = new Boolean[screenHeight][screenWidth]

        when:

            DaySolver.solve(screen, input)

        then:

            println "Result:\n"
            println DaySolver.render(screen)
            println ""

            println "Expected:\n"
            println expectedResult
            println ""

            DaySolver.render(screen) == expectedResult

        where:

            screenWidth || screenHeight || input                        || expectedResult

            7           || 3            || "rect 3x2"                   || "###....\n" +
                                                                           "###....\n" +
                                                                           "......."

            7           || 3            || "rect 3x2\n" +
                                           "rotate column x=1 by 1"     || "#.#....\n" +
                                                                           "###....\n" +
                                                                           ".#....."

            7           || 3            || "rect 3x2\n" +
                                           "rotate column x=1 by 1\n" +
                                           "rotate row y=0 by 4"        || "....#.#\n" +
                                                                           "###....\n" +
                                                                           ".#....."

            7           || 3            || "rect 3x2\n" +
                                           "rotate column x=1 by 1\n" +
                                           "rotate row y=0 by 4\n" +
                                           "rotate column x=1 by 1"     || ".#..#.#\n" +
                                                                           "#.#....\n" +
                                                                           ".#....."
    }
}
