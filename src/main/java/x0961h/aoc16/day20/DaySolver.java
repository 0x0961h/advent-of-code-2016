package x0961h.aoc16.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 20.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day20", "data.txt")));
        solve(input);
    }

    public static void solve(String input) {
        List<IpRange> ranges = extractRanges(input);
        optimizeRanges(ranges);
        ranges.forEach(System.out::println);
    }

    public static void optimizeRanges(List<IpRange> ranges) {
        for (int i = 0; i < ranges.size(); i++) {
            IpRange r1 = ranges.get(i);

            for (int j = i + 1; j < ranges.size(); j++) {
                IpRange r2 = ranges.get(j);

                if (r2.high < r1.high) {
                    ranges.remove(j);
                    j--;
                } else if (r2.low < r1.high) {
                    r1.high = r2.high;
                    ranges.remove(j);
                    j--;
                } else if (r2.low == r1.high + 1) {
                    r1.high = r2.high;
                    ranges.remove(j);
                    j--;
                }
            }
        }
    }

    public static List<IpRange> extractRanges(String input) {
        return Arrays.stream(input.split("\r?\n")).
                    map(line -> new IpRange(line.split("\\s*-\\s*"))).
                    collect(Collectors.toList());
    }
}
