package x0961h.aoc16.day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 21.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day21", "data.txt")));
        System.out.println("Result = " + solve("abcdefgh", input));
    }

    public static String solve(String input, String algorithm) {
        StringBuilder result = new StringBuilder(input);

        Pattern swapPosPat = Pattern.compile("swap position (\\d+) with position (\\d+)");
        Pattern swapLetPat = Pattern.compile("swap letter (\\w) with letter (\\w)");
        Pattern rotPat = Pattern.compile("rotate (left|right) (\\d+) steps?");
        Pattern revPat = Pattern.compile("reverse positions (\\d+) through (\\d+)");
        Pattern movPat = Pattern.compile("move position (\\d+) to position (\\d+)");

        for (String cmd : algorithm.split("\r?\n")) {
            if (cmd.startsWith("swap position ")) {
                Matcher mat = swapPosPat.matcher(cmd);
                mat.find();
                int posOrig = Integer.parseInt(mat.group(1));
                int posSwap = Integer.parseInt(mat.group(2));

                swapPositions(result, posOrig, posSwap);
            } else if (cmd.startsWith("swap letter ")) {
                Matcher mat = swapLetPat.matcher(cmd);
                mat.find();
                char chOrig = mat.group(1).charAt(0);
                char chSwap = mat.group(2).charAt(0);

                swapLetters(result, chOrig, chSwap);
            } else if (cmd.startsWith("rotate based on position of letter ")) {
                char ch = cmd.substring("rotate based on position of letter ".length()).charAt(0);
                rotateBasedOnLetterPos(result, ch);
            } else if (cmd.startsWith("rotate ")) {
                Matcher mat = rotPat.matcher(cmd);
                mat.find();

                boolean isLeft = mat.group(1).equals("left");
                int stepsCount = Integer.parseInt(mat.group(2));

                rotate(result, isLeft, stepsCount);
            } else if (cmd.startsWith("reverse ")) {
                Matcher mat = revPat.matcher(cmd);
                mat.find();
                int posFrom = Integer.parseInt(mat.group(1));
                int posTo = Integer.parseInt(mat.group(2));

                reverse(result, posFrom, posTo);
            } else if (cmd.startsWith("move position ")) {
                Matcher mat = movPat.matcher(cmd);
                mat.find();
                int posSrc = Integer.parseInt(mat.group(1));
                int posDst = Integer.parseInt(mat.group(2));

                move(result, posSrc, posDst);
            }
        }

        return result.toString();
    }

    private static void move(StringBuilder result, int posSrc, int posDst) {
        char tmp = result.charAt(posSrc);
        result.deleteCharAt(posSrc);
        result.insert(posDst, tmp);
    }

    private static void reverse(StringBuilder result, int posFrom, int posTo) {
        String tmp = result.substring(posFrom, posTo + 1);
        for (int i = posFrom; i <= posTo; i++) result.setCharAt(i, tmp.charAt(posTo - i));
    }

    private static void rotate(StringBuilder result, boolean isLeft, int stepsCount) {
        String tmp = result.toString();
        result.setLength(0);

        if (isLeft) {
            result.
                    append(tmp.substring(stepsCount)).
                    append(tmp.substring(0, stepsCount));
        } else {
            result.
                    append(tmp.substring(tmp.length() - stepsCount % tmp.length())).
                    append(tmp.substring(0, tmp.length() - stepsCount % tmp.length()));
        }
    }

    private static void rotateBasedOnLetterPos(StringBuilder result, char ch) {
        int index = result.indexOf(String.valueOf(ch));
        int rotationsCount = 1 + index + (index >= 4 ? 1 : 0);

        rotate(result, false, rotationsCount);
    }

    private static void swapLetters(StringBuilder result, char chOrig, char chSwap) {
        String tmp = result.toString();
        result.setLength(0);

        result.append(
                tmp.
                        replaceAll(String.valueOf(chOrig), "!").
                        replaceAll(String.valueOf(chSwap), String.valueOf(chOrig)).
                        replaceAll("!", String.valueOf(chSwap))
        );
    }

    private static void swapPositions(StringBuilder result, int posOrig, int posSwap) {
        char tmp = result.charAt(posOrig);
        result.setCharAt(posOrig, result.charAt(posSwap));
        result.setCharAt(posSwap, tmp);
    }
}
