package x0961h.aoc16.day05;

import x0961h.aoc16.utils.MD5;

import java.io.IOException;

/**
 * Created by 0x0961h on 05.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve("ojvtpuvg"));
    }

    public static String solve(String input) {
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (sb.length() < 8) {
            String source = input + i;
            String hash = MD5.get(source);

            if (hash.startsWith("00000")) {
                sb.append(hash.charAt(5));
            }

            i++;
        }

        return sb.toString();
    }
}
