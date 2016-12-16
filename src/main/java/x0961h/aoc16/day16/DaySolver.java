package x0961h.aoc16.day16;

import java.io.IOException;

/**
 * Created by 0x0961h on 16.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(272, "01111010110010011"));
    }

    public static String solve(int diskSize, String input) {
        while (input.length() < diskSize) input = dragonCurve(input);
        return generateChecksum(input.substring(0, diskSize));
    }

    public static String generateChecksum(String input) {
        StringBuilder sb = new StringBuilder(input);

        while (sb.length() % 2 == 0) {
            input = sb.toString();
            sb.setLength(0);

            for (int i = 0; i < input.length() / 2; i++) {
                sb.append(input.charAt(i * 2) == input.charAt(i * 2 + 1) ? 1 : 0);
            }
        }

        return sb.toString();
    }

    public static String dragonCurve(String input) {
        char[] inputCh = input.toCharArray();
        char[] reversedInputCh = new char[inputCh.length];

        for (int i = 0; i < inputCh.length; i++) {
            reversedInputCh[(inputCh.length - 1) - i] = inputCh[i] == '0' ? '1' : '0';
        }

        return input + "0" + new String(reversedInputCh);
    }
}
