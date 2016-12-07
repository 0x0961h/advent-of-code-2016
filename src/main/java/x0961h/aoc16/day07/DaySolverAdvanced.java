package x0961h.aoc16.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 0x0961h on 06.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day07", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                filter(DaySolverAdvanced::checkSslSupport).
                count();
    }

    public static Boolean checkSslSupport(String ipv7) {
        String[] parts = ipv7.split("[\\[\\]]");

        Set<String> aba = new HashSet<>();
        Set<String> bab = new HashSet<>();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            for (int j = 0; j < part.length() - 2; j++) {
                String subpart = part.substring(j, j + 3);
                if (isAba(subpart)) {
                    (i % 2 == 1 ? bab : aba).add(subpart);
                }
            }
        }

        return aba.stream().map(DaySolverAdvanced::invertAba).anyMatch(bab::contains);
    }

    private static String invertAba(String input) {
        return "" + input.charAt(1) + input.charAt(0) + input.charAt(1);
    }

    private static boolean isAba(String input) {
        return input.charAt(0) == input.charAt(2) && input.charAt(0) != input.charAt(1);
    }
}
