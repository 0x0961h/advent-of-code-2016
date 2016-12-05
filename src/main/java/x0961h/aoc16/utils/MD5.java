package x0961h.aoc16.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 0x0961h on 05.12.16.
 */
public class MD5 {
    public static String get(String input) {
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("what");
        }

        md.update(input.getBytes());
        byte[] digest = md.digest();
        BigInteger number = new BigInteger(1, digest);
        return String.format("%1$32s", number.toString(16)).replaceAll(" ", "0");
    }
}
