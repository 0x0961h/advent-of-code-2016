package x0961h.aoc16.day17;

import x0961h.aoc16.utils.MD5;
import x0961h.aoc16.utils.Point;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by 0x0961h on 21.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve("udskfozm"));
    }

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    public static String solve(String input) {
        MemoryPoint pos = new MemoryPoint(0, 0);

        TreeSet<MemoryPoint> queue = new TreeSet<>();

        Boolean[] doors = getDoorsStatus(input);

        if (doors[UP]) addToQueue(pos.cpy().up());
        if (doors[DOWN]) addToQueue(pos.cpy().down());
        if (doors[LEFT]) addToQueue(pos.cpy().left());
        if (doors[RIGHT]) addToQueue(pos.cpy().right());

        return null;
    }

    public static void addToQueue(MemoryPoint nextPoint) {
        if (nextPoint.x < 0 || nextPoint.y < 0) return;
        if (nextPoint.x == 4 || nextPoint.y == 4) return;

        // TODO

        System.out.println(nextPoint);
    }

    private static Boolean[] getDoorsStatus(String currentInput) {
        return MD5.get(currentInput).
                    substring(0, 4).
                    chars().
                    mapToObj(i -> i == 'b' || i == 'c' || i == 'd' || i == 'e' || i == 'f').
                    map(Boolean::new).
                    toArray(Boolean[]::new);
    }
}
