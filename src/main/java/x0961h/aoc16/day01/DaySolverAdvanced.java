package x0961h.aoc16.day01;

import x0961h.aoc16.utils.Point;

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

    public static int solve(String input) {
        Set<Point> visitedPoints = new HashSet<>();

        String[] commands = input.split(", ");

        int direction = NORTH;
        Point p = new Point();

        main_cycle:
        for (String command : commands) {
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
}
