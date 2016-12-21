package x0961h.aoc16.day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 21.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day21", "data.txt")));
        System.out.println("Result = " + solve("fbgdceah", input));
    }

    public static String solve(String input, String algorithm) {
        StringBuilder result = new StringBuilder(input);

        Pattern swapPosPat = Pattern.compile("swap position (\\d+) with position (\\d+)");
        Pattern swapLetPat = Pattern.compile("swap letter (\\w) with letter (\\w)");
        Pattern rotPat = Pattern.compile("rotate (left|right) (\\d+) steps?");
        Pattern revPat = Pattern.compile("reverse positions (\\d+) through (\\d+)");
        Pattern movPat = Pattern.compile("move position (\\d+) to position (\\d+)");

        List<String> cmds = Arrays.asList(algorithm.split("\r?\n"));
        Collections.reverse(cmds);

        for (String cmd : cmds) {
            if (cmd.startsWith("swap position ")) {
                Matcher mat = swapPosPat.matcher(cmd);
                mat.find();
                int posOrig = Integer.parseInt(mat.group(1));
                int posSwap = Integer.parseInt(mat.group(2));

                DaySolver.swapPositions(result, posSwap, posOrig);
            } else if (cmd.startsWith("swap letter ")) {
                Matcher mat = swapLetPat.matcher(cmd);
                mat.find();
                char chOrig = mat.group(1).charAt(0);
                char chSwap = mat.group(2).charAt(0);

                DaySolver.swapLetters(result, chSwap, chOrig);
            } else if (cmd.startsWith("rotate based on position of letter ")) {
                char ch = cmd.substring("rotate based on position of letter ".length()).charAt(0);
                int index = result.indexOf(String.valueOf(ch));

                if (index % 2 == 1) {
                    DaySolver.rotate(result, true, (index + 1) / 2);
                } else {
                    if (index == 0) {
                        DaySolver.rotate(result, true, 1);
                    } else {
                        DaySolver.rotate(result, false, index % 3);
                    }
                }
            } else if (cmd.startsWith("rotate ")) {
                Matcher mat = rotPat.matcher(cmd);
                mat.find();

                boolean isLeft = mat.group(1).equals("left");
                int stepsCount = Integer.parseInt(mat.group(2));

                DaySolver.rotate(result, !isLeft, stepsCount);
            } else if (cmd.startsWith("reverse ")) {
                Matcher mat = revPat.matcher(cmd);
                mat.find();
                int posFrom = Integer.parseInt(mat.group(1));
                int posTo = Integer.parseInt(mat.group(2));

                DaySolver.reverse(result, posFrom, posTo);
            } else if (cmd.startsWith("move position ")) {
                Matcher mat = movPat.matcher(cmd);
                mat.find();
                int posSrc = Integer.parseInt(mat.group(1));
                int posDst = Integer.parseInt(mat.group(2));

                DaySolver.move(result, posDst, posSrc);
            }
        }

        return result.toString();
    }
}
