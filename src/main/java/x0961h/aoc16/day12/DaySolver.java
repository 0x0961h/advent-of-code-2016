package x0961h.aoc16.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by 0x0961h on 12.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day12", "data.txt")));
        System.out.println("Result = " + Arrays.toString(solve(new Integer[]{0, 0, 0, 0}, input)));
    }

    public static Integer[] solve(Integer[] registers, String input) {
        String[] cmds = input.split("\r?\n");
        int i = 0;

        while (i >= 0 && i < cmds.length) {
            String cmd = cmds[i];

            if (cmd.startsWith("cpy")) {
                String[] spl = cmd.substring("cpy ".length()).split(" ");

                int regDst = spl[1].charAt(0) - 'a';
                if (spl[0].matches("\\d+")) {
                    int value = Integer.parseInt(spl[0]);
                    registers[regDst] = value;
                } else {
                    int regSrc = spl[0].charAt(0) - 'a';
                    registers[regDst] = registers[regSrc];
                }

                i++;
            } else if (cmd.startsWith("inc")) {
                int regDst = cmd.substring("inc ".length()).charAt(0) - 'a';
                registers[regDst]++;
                i++;
            } else if (cmd.startsWith("dec")) {
                int regDst = cmd.substring("inc ".length()).charAt(0) - 'a';
                registers[regDst]--;
                i++;
            } else if (cmd.startsWith("jnz")) {
                String[] spl = cmd.substring("jnz ".length()).split(" ");

                int cmpVal;
                if (spl[0].matches("\\d+")) {
                    cmpVal = Integer.parseInt(spl[0]);
                } else {
                    cmpVal = registers[spl[0].charAt(0) - 'a'];
                }

                if (cmpVal != 0) {
                    i += Integer.parseInt(spl[1]);
                } else {
                    i++;
                }
            } else {
                throw new RuntimeException("Unknown command: " + cmd);
            }
        }

        return registers;
    }
}
