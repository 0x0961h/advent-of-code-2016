package x0961h.aoc16.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 08.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day08", "data.txt")));

        Boolean[][] screen = new Boolean[6][50];
        solve(screen, input);
        System.out.println(render(screen));
        System.out.println();

        System.out.println("Result = " + Arrays.stream(screen).flatMap(Arrays::stream).filter(b -> b != null && b).count());
    }

    static Pattern pat = Pattern.compile("(column x|row y)=(\\d+) by (\\d+)");

    public static void solve(Boolean[][] screen, String input) {
        String[] cmds = input.split("\n");

        for (String cmd : cmds) {
            if (cmd.startsWith("rect ")) {
                String[] size = cmd.substring("rect ".length()).split("x");
                int width = Integer.parseInt(size[0]);
                int height = Integer.parseInt(size[1]);

                drawRect(screen, width, height);
            } else if (cmd.startsWith("rotate ")) {
                Matcher mat = pat.matcher(cmd.substring("rotate ".length()));
                if (!mat.find()) throw new RuntimeException("Invalid ROTATE command syntax: " + cmd);

                boolean byColumn = mat.group(1).equals("column x");
                int index = Integer.parseInt(mat.group(2));
                int amount = Integer.parseInt(mat.group(3));

                rotateScreen(screen, byColumn, index, amount);
            } else {
                throw new RuntimeException("Unknown command: " + cmd);
            }
        }
    }

    public static void drawRect(Boolean[][] screen, int width, int height) {
        for (int y = 0; y < Math.min(height, screen.length); y++) {
            for (int x = 0; x < Math.min(width, screen[y].length); x++) {
                screen[y][x] = true;
            }
        }
    }

    public static void rotateScreen(Boolean[][] screen, boolean byColumn, int index, int amount) {
        if (byColumn) {
            if (index >= screen[0].length) return;
            Boolean[] col = extractColumn(screen, index);
            shiftArrayRight(col, amount);
            replaceColumn(screen, index, col);
        } else {
            if (index >= screen.length) return;
            shiftArrayRight(screen[index], amount);
        }
    }

    private static void shiftArrayRight(Boolean[] arr, int amount) {
        amount = amount % arr.length;
        if (amount == 0) return;

        Boolean[] arrRight = Arrays.copyOfRange(arr, 0, (arr.length - amount));
        Boolean[] arrLeft = Arrays.copyOfRange(arr, (arr.length - amount), arr.length);

        System.arraycopy(arrLeft, 0, arr, 0, arrLeft.length);
        System.arraycopy(arrRight, 0, arr, arrLeft.length, arrRight.length);
    }

    private static Boolean[] extractColumn(Boolean[][] arr, int index) {
        Boolean[] res = new Boolean[arr.length];
        for (int i = 0; i < arr.length; i++) res[i] = arr[i][index];
        return res;
    }

    private static void replaceColumn(Boolean[][] arr, int index, Boolean[] col) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][index] = col[i];
        }
    }

    public static String render(Boolean[][] screen) {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < screen.length; y++) {
            for (int x = 0; x < screen[y].length; x++) {
                sb.append(screen[y][x] != null && screen[y][x] ? "#" : ".");
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
