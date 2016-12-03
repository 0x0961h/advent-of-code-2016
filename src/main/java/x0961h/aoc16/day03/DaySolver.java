package x0961h.aoc16.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 03.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day03", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                map(String::trim).
                map(
                        triangle -> Arrays.stream(triangle.split("\\s+")).
                                map(Integer::valueOf).
                                collect(Collectors.toList()).
                                toArray(new Integer[3])
                ).
                filter(triangle -> triangle[0] + triangle[1] > triangle[2]).
                filter(triangle -> triangle[0] + triangle[2] > triangle[1]).
                filter(triangle -> triangle[1] + triangle[2] > triangle[0]).
                count();
    }
}
