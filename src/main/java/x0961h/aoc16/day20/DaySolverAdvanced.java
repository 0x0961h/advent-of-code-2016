package x0961h.aoc16.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 20.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day20", "data.txt")));
        solve(input);
    }

    public static void solve(String input) {
        List<IpRange> ranges = DaySolver.extractRanges(input);
        DaySolver.optimizeRanges(ranges);
        System.out.println(ranges.size());
    }
}
