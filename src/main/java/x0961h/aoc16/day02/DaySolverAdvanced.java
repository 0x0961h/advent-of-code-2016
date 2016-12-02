package x0961h.aoc16.day02;

import x0961h.aoc16.utils.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 02.12.16.
 */
public class DaySolverAdvanced {
    private static char[][] keypad;
    private static Point currButton;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day02", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static String solve(String input) {
        StringBuilder code = new StringBuilder();
        String[] digitsCmds = input.split("\\s*\n\\s*");

        String keypadStr =
                "  1  \n" +
                        " 234 \n" +
                        "56789\n" +
                        " ABC \n" +
                        "  D  ";

        keypad = Arrays.
                stream(keypadStr.split("\n")).
                map(String::toCharArray).
                collect(Collectors.toList()).toArray(new char[5][]);

        currButton = new Point(0, 2);

        for (String cmdLine : digitsCmds) {
            for (int i = 0; i < cmdLine.length(); i++) {
                Point np = currButton.cpy();

                switch (cmdLine.charAt(i)) {
                    case 'U':
                        np.up();
                        break;
                    case 'D':
                        np.down();
                        break;
                    case 'L':
                        np.left();
                        break;
                    case 'R':
                        np.right();
                        break;
                }

                if (isValid(np) && !isEmpty(np)) currButton = np;
            }

            code.append(getKeypadButton());
        }

        return code.toString();
    }

    private static char getKeypadButton() {
        return getKeypadButton(currButton);
    }

    private static char getKeypadButton(Point button) {
        return keypad[keypad.length - 1 - button.y][button.x];
    }

    private static boolean isValid(Point nextButton) {
        return nextButton.y >= 0 && nextButton.y < keypad.length && nextButton.x >= 0 && nextButton.x < keypad[0].length;
    }

    private static boolean isEmpty(Point nextButton) {
        return getKeypadButton(nextButton) == ' ';
    }
}
