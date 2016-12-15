package x0961h.aoc16.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 15.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day15", "data.txt")));
        System.out.println("Result = " + DaySolver.solve(input + "\nDisc #7 has 11 positions; at time=0, it is at position 0."));
    }
}
