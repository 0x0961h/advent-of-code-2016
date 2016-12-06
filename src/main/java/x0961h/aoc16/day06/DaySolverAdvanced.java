package x0961h.aoc16.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 06.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day06", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    private static Map<Character, Integer>[] charsFrequency;

    public static String solve(String input) {
        String[] lines = input.split("\n");
        charsFrequency = new HashMap[lines[0].length()];

        Arrays.stream(lines).forEach(line -> {
            for (int i = 0; i < line.length(); i++) {
                saveChar(i, line.charAt(i));
            }
        });

        return Arrays.
                stream(charsFrequency).
                map(
                        freq -> freq.entrySet().stream().
                                sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).
                                findFirst().
                                get().
                                getKey().
                                toString()
                ).
                collect(Collectors.joining());
    }

    private static void saveChar(int index, char ch) {
        if (charsFrequency[index] == null) charsFrequency[index] = new HashMap<>();
        if (!charsFrequency[index].containsKey(ch)) charsFrequency[index].put(ch, 0);
        charsFrequency[index].put(ch, charsFrequency[index].get(ch) + 1);
    }
}
