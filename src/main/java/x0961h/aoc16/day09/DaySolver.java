package x0961h.aoc16.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 09.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day09", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return decompress(input).length();
    }

    public static String decompress(String data) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        while (index < data.length()) {
            char ch = data.charAt(index);

            if (ch == '(') {
                tmp.setLength(0);

                index++;
                char tmpch = data.charAt(index);
                while (tmpch != 'x') {
                    tmp.append(tmpch);
                    tmpch = data.charAt(++index);
                }

                int blockLength = Integer.parseInt(tmp.toString());

                tmp.setLength(0);

                index++;
                tmpch = data.charAt(index);
                while (tmpch != ')') {
                    tmp.append(tmpch);
                    tmpch = data.charAt(++index);
                }

                int repeatTimes = Integer.parseInt(tmp.toString());
                String block = data.substring(index + 1, index + 1 + blockLength);

                for (int i = 0; i < repeatTimes; i++) sb.append(block);
                index = index + blockLength;
            } else {
                sb.append(ch);
            }

            index++;
        }

        return sb.toString();
    }
}
