package x0961h.aoc16.day13;

import x0961h.aoc16.utils.Point;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 0x0961h on 14.12.16.
 */
public class DaySolver {
    private static final double TIE_BREAKER = 1.0 / 100.0;
    private static TreeSet<AStarPoint> queue;
    private static Set<AStarPoint> visited;

    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(1358, 31, 39));
    }

    public static long solve(int favNum, int xt, int yt) {
        AStarPoint p0 = new AStarPoint(1, 1);
        AStarPoint pt = new AStarPoint(xt, yt);

        queue = new TreeSet<>(
                (o1, o2) -> (o1.manhattan(pt) * (1.0 + TIE_BREAKER)) < (o2.manhattan(pt) * (1.0 + TIE_BREAKER)) ? -1 : +1
        );

        visited = new HashSet<>();
        visited.add(p0);

        pushToQueue(favNum, p0.next().right());
        pushToQueue(favNum, p0.next().left());
        pushToQueue(favNum, p0.next().up());
        pushToQueue(favNum, p0.next().down());

        while (!queue.isEmpty() && !queue.first().equals(pt)) {
            AStarPoint q = queue.pollFirst();

            pushToQueue(favNum, q.next().right());
            pushToQueue(favNum, q.next().left());
            pushToQueue(favNum, q.next().up());
            pushToQueue(favNum, q.next().down());

            visited.add(q);
        }

        int steps = -1;
        AStarPoint p = queue.pollFirst();
        while (p != null) {
            steps++;
            p = p.previous;
        }

        return steps;
    }

    private static void pushToQueue(int favNum, AStarPoint p) {
        if (p.x < 0 || p.y < 0) return;
        if (isWall(favNum, p)) return;
        if (visited.contains(p)) return;
        queue.add(p);
    }

    public static Boolean isWall(int favNum, Point p) {
        return Long.
                toBinaryString(p.x * p.x + 3 * p.x + 2 * p.x * p.y + p.y + p.y * p.y + favNum).
                replaceAll("0", "").
                length() % 2 == 1;
    }
}
