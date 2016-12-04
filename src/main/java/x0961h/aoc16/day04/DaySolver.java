package x0961h.aoc16.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 04.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day04", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                map(RoomIdStruct::new).
                filter(DaySolver::isReal).
                mapToInt(s -> s.sectorId).
                sum();
    }

    public static Boolean isReal(RoomIdStruct struct) {
        String name = struct.name.replaceAll("-", "");
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!freqMap.containsKey(ch)) freqMap.put(ch, 0);
            freqMap.put(ch, freqMap.get(ch) + 1);
        }

        String calculatedChecksum = freqMap.entrySet().stream().
                sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return -o1.getValue().compareTo(o2.getValue());
                    }
                }).
                map(e -> String.valueOf(e.getKey())).
                collect(Collectors.joining("")).
                substring(0, 5);

        return calculatedChecksum.equals(struct.checksum);
    }
}
