package x0961h.aoc16.day13;

import x0961h.aoc16.utils.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by 0x0961h on 13.12.16.
 */
public class DaySolver {
    private static TreeSet<Point> queue;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day12", "data.txt")));
        System.out.println("Result = " + solve(1358, 31, 39));
    }

    public static long solve(int favNum, int xt, int yt) {
        Point p0 = new Point(1, 1);
        Point pt = new Point(xt, yt);

        queue = new TreeSet<>((o1, o2) -> -Integer.compare(o1.manhattan(pt), o2.manhattan(pt)));

        pushToQueue(p0.cpy().right());
        pushToQueue(p0.cpy().left());
        pushToQueue(p0.cpy().up());
        pushToQueue(p0.cpy().down());

        // TODO

        return -1;
    }

    private static void pushToQueue(Point p) {
        if (p.x < 0 || p.y < 0) return;
        queue.add(p);
    }

    public static Boolean isWall(int favNum, Point p) {
        return Long.
                toBinaryString(p.x * p.x + 3 * p.x + 2 * p.x * p.y + p.y + p.y * p.y + favNum).
                replaceAll("0", "").
                length() % 2 == 1;
    }
}
