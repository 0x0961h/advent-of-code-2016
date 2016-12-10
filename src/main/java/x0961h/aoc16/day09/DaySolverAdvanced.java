package x0961h.aoc16.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 09.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day09", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    private static List<MultiplierStruct> multipliers;

    public static long solve(String input) {
        long length = 0;
        multipliers = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                String instructions = input.substring(i + 1, input.indexOf(')', i));
                String[] spl = instructions.split("x");
                i += instructions.length() + 1;

                int blockSize = Integer.parseInt(spl[0]);
                int repeatTimes = Integer.parseInt(spl[1]);

                decMultipliers(instructions.length() + 2);
                multipliers.add(new MultiplierStruct(blockSize, repeatTimes));
            } else {
                Integer mlt = getMultiplier();
                length += mlt;

                decMultipliers();
            }
        }

        return length;
    }

    private static void decMultipliers(int i) {
        multipliers = multipliers.stream().
                map(m -> {
                    m.dec(i);
                    return m;
                }).
                filter(m -> !m.done()).
                collect(Collectors.toList());
    }

    private static void decMultipliers() {
        decMultipliers(1);
    }

    private static Integer getMultiplier() {
        return multipliers.stream().
                map(m -> m.multiplier).
                collect(Collectors.toList()).
                stream().
                reduce((i, j) -> i * j).
                orElseGet(() -> 1);
    }

    private static class MultiplierStruct {
        final int multiplier;
        int charsLeft;

        MultiplierStruct(int charsLeft, int multiplier) {
            this.multiplier = multiplier;
            this.charsLeft = charsLeft;
        }

        void dec(int i) {
            charsLeft -= i;
            if (charsLeft < 0) throw new RuntimeException("charsLeft is negative");
        }

        boolean done() {
            return charsLeft == 0;
        }

        @Override
        public String toString() {
            return "(x" + multiplier +
                    ", " + charsLeft +
                    ")";
        }
    }
}
