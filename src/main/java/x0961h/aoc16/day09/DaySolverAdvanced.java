package x0961h.aoc16.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 09.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day09", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    private static Pattern pat = Pattern.compile("\\((\\d+)x(\\d+)\\)");

    public static long solve(String input) {
        simplifyInput(input, 1);

        return -1;
    }

    private static String simplifyInput(String input, int baseCoef) {
        System.out.println("===");
        String firstInput = input;

        StringBuilder stable = new StringBuilder();

        stable.append(input.substring(0, input.indexOf('(')));
        input = input.substring(input.indexOf('('));

        System.out.println("Stable part: " + stable);
        System.out.println("Processing part: " + input);

        Matcher mat = pat.matcher(input);
        while (mat.find()) {
            System.out.println("  Found: " + mat.group());
            int blockSize = Integer.parseInt(mat.group(1));
            int repeatTimes = Integer.parseInt(mat.group(2));
            String checkingPart = input.substring(mat.end(), Math.min(mat.end() + blockSize, input.length()));
            System.out.println("    " + checkingPart);
            int partEnd = mat.end() + checkingPart.length();
            if (checkingPart.contains("(")) {
                System.out.println("    Increasing internal coefficients (x" + baseCoef * repeatTimes + ")...");
                stable.append(simplifyInput(checkingPart, repeatTimes));
            } else {
                stable.append(mat.group()).append(checkingPart);
            }
            input = input.substring(partEnd);
            mat = pat.matcher(input);
        }

        stable.append(input);

        System.out.println("Input:  " + firstInput);
        System.out.println("Result: " + stable.toString());
        System.out.println("===");

        return stable.toString();
    }
}
