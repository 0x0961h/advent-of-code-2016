package x0961h.aoc16.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 0x0961h on 01.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day01", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    private static final int NORTH = 0;
    private static final int WEST = 1;
    private static final int SOUTH = 2;
    private static final int EAST = 3;

    private static Set<Point> visitedPoints;

    public static int solve(String input) {
        visitedPoints = new HashSet<>();

        String[] commands = input.split(", ");

        int direction = NORTH;
        Point p = new Point();

        main_cycle: for (String command : commands) {
            char rotCmd = command.charAt(0);
            if (rotCmd == 'L') {
                if (++direction > EAST) direction = NORTH;
            } else if (rotCmd == 'R') {
                if (--direction < NORTH) direction = EAST;
            } else {
                throw new RuntimeException("Unknown rotation command: " + rotCmd);
            }

            int distance = Integer.parseInt(command.substring(1));

            for (int i = 0; i < distance; i++) {
                switch (direction) {
                    case NORTH:
                        p.y++;
                        break;
                    case WEST:
                        p.x--;
                        break;
                    case SOUTH:
                        p.y--;
                        break;
                    case EAST:
                        p.x++;
                        break;
                }

                if (visitedPoints.contains(p)) {
                    break main_cycle;
                }

                visitedPoints.add(p.cpy());
            }
        }

        return manhattan(0, 0, p.x, p.y);
    }

    private static int manhattan(int x0, int y0, int x1, int y1) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    private static class Point {
        public int x;
        public int y;

        public Point() {
            this(0, 0);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point cpy() {
            return new Point(x, y);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
