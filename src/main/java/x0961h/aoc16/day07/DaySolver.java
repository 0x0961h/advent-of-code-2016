package x0961h.aoc16.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by 0x0961h on 06.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day07", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                filter(DaySolver::checkTlsSupport).
                count();
    }

    public static Boolean checkTlsSupport(String ipv7) {
        String[] parts = ipv7.split("[\\[\\]]");

        boolean result = false;
        for (int i = 0; i < parts.length; i++) {
            if (checkPartForAbba(parts[i])) {
                if (i % 2 == 1) return false;
                result = true;
            }
        }

        return result;
    }

    private static boolean checkPartForAbba(String input) {
        for (int i = 0; i < input.length() - 3; i++) {
            String abbaCandidate = input.substring(i, i + 4);
            if (abbaCandidate.charAt(0) == abbaCandidate.charAt(3) &&
                    abbaCandidate.charAt(1) == abbaCandidate.charAt(2) &&
                    abbaCandidate.charAt(0) != abbaCandidate.charAt(1)) return true;
        }

        return false;
    }
}
