package x0961h.aoc16.day14;

import x0961h.aoc16.utils.MD5;

import java.io.IOException;

/**
 * Created by 0x0961h on 16.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve("qzyelonm"));
    }

    public static int solve(String salt) {
        int keysGenerated = 0;
        int index = 0;
        while (keysGenerated < 64) {
            String hash = MD5.get(salt + index);

            for (int i = 0; i < hash.length() - 2; i++) {
                if (hash.charAt(i) == hash.charAt(i + 1) && hash.charAt(i) == hash.charAt(i + 2)) {
                    cycle2:
                    for (int index2 = index + 1; index2 <= index + 1000; index2++) {
                        String hash2 = MD5.get(salt + index2);

                        for (int j = 0; j < hash2.length() - 4; j++) {
                            if (hash2.charAt(j) == hash.charAt(i) &&
                                    hash2.charAt(j) == hash2.charAt(j + 1) &&
                                    hash2.charAt(j) == hash2.charAt(j + 2) &&
                                    hash2.charAt(j) == hash2.charAt(j + 3) &&
                                    hash2.charAt(j) == hash2.charAt(j + 4)) {

                                System.out.println("Index " + index2 + " generated a key for index " + index);
                                keysGenerated++;
                                break cycle2;
                            }
                        }
                    }

                    break;
                }
            }

            index++;
        }

        return index - 1;
    }
}
