package x0961h.aoc16.day05;

import x0961h.aoc16.utils.MD5;

import java.io.IOException;

/**
 * Created by 0x0961h on 05.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve("ojvtpuvg"));
    }

    public static String solve(String input) {
        char[] password = new char[8];

        int charsGuessed = 0;
        int i = 0;

        while (charsGuessed < 8) {
            String source = input + i;
            String hash = MD5.get(source);

            if (hash.startsWith("00000")) {
                int pos = hash.charAt(5) - '0';
                if (pos < password.length && password[pos] == 0) {
                    password[pos] = hash.charAt(6);
                    charsGuessed++;
                }
            }

            i++;
        }

        return new String(password);
    }
}
