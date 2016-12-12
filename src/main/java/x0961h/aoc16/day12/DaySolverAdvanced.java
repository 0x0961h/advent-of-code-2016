package x0961h.aoc16.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by 0x0961h on 12.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day12", "data.txt")));
        System.out.println("Result = " + Arrays.toString(DaySolver.solve(new Integer[]{0, 0, 1, 0}, input)));
    }
}
