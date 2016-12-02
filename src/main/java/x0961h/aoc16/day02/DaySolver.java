package x0961h.aoc16.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by 0x0961h on 02.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day02", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static String solve(String input) {
        StringBuilder code = new StringBuilder();
        String[] digitsCmds = input.split("\\s*\n\\s*");

        int currDigit = 5;
        for (String cmdLine : digitsCmds) {
            for (int i = 0; i < cmdLine.length(); i++) {
                switch (cmdLine.charAt(i)) {
                    case 'U':
                        if (currDigit - 3 > 0) currDigit -= 3;
                        break;
                    case 'D':
                        if (currDigit + 3 <= 9) currDigit += 3;
                        break;
                    case 'L':
                        if (currDigit % 3 != 1) currDigit--;
                        break;
                    case 'R':
                        if (currDigit % 3 != 0) currDigit++;
                        break;
                }
            }

            code.append(currDigit);
        }

        return code.toString();
    }
}
