package x0961h.aoc16.day14;

import x0961h.aoc16.utils.MD5;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 0x0961h on 16.12.16.
 */
public class DaySolver {
    private static final String SALT = "qzyelonm";
    private static Map<Integer, String> hashCache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        long time = new Date().getTime();
        System.out.println("Result = " + solve());
        System.out.println("Time elapsed: " + (new Date().getTime() - time) + "ms");
    }

    public static int solve() {
        int keysGenerated = 0;
        int index = 0;
        while (keysGenerated < 64) {
            String hash = getHash(index);

            for (int i = 0; i < hash.length() - 2; i++) {
                if (hash.charAt(i) == hash.charAt(i + 1) && hash.charAt(i) == hash.charAt(i + 2)) {
                    cycle2:
                    for (int index2 = index + 1; index2 <= index + 1000; index2++) {
                        String hash2 = getHash(index2);

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

    private static String getHash(int index) {
        if (!hashCache.containsKey(index)) hashCache.put(index, MD5.get(SALT + index));
        return hashCache.get(index);
    }
}
