package x0961h.aoc16.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 01.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day01", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    private static final int NORTH = 0;
    private static final int WEST = 1;
    private static final int SOUTH = 2;
    private static final int EAST = 3;

    public static int solve(String input) {
        String[] commands = input.split(", ");

        int direction = NORTH;
        int x = 0, y = 0;

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

            switch (direction) {
                case NORTH:
                    y += distance;
                    break;
                case WEST:
                    x -= distance;
                    break;
                case SOUTH:
                    y -= distance;
                    break;
                case EAST:
                    x += distance;
                    break;
            }
        }

        return manhattan(0, 0, x, y);
    }

    private static int manhattan(int x0, int y0, int x1, int y1) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }
}
