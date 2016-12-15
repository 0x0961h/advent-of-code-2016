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
public class DaySolver {
    private static List<Disc> discs;
    private static int startTime;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day15", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        Pattern pat = Pattern.compile("Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).");

        discs = Arrays.stream(input.split("\n")).
                map(line -> {
                    Matcher mat = pat.matcher(line);
                    if (!mat.find()) throw new RuntimeException("Unknown disc description line format: " + line);
                    return new Disc(mat.group(1), mat.group(2), mat.group(3));
                }).
                sorted((o1, o2) -> Integer.compare(o1.index, o2.index)).
                collect(Collectors.toList());

        for (int i = 0; i < discs.size(); i++) {
            Disc disc = discs.get(i);
            for (int j = 0; j < i; j++) disc.inc();
        }

        startTime = 0;
        while (true) {
            rotateDiscs();

            if (checkFullCombo()) {
                return startTime;
            }

            startTime++;
        }
    }

    private static boolean checkFullCombo() {
        return discs.stream().filter(d->d.currPos == 0).count() == discs.size();
    }

    private static void rotateDiscs() {
        discs.stream().forEach(Disc::inc);
    }
}
