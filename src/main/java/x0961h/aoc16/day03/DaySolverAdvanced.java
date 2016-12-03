package x0961h.aoc16.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 03.12.16.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day03", "data.txt")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        List<Integer> l = Arrays.
                stream(
                        input.
                                trim().
                                replaceAll("\r", "").
                                replaceAll("\n", " ").
                                split(" +")
                ).
                filter(s->!s.trim().isEmpty()).
                map(Integer::valueOf).
                collect(Collectors.toList());

        return IntStream.
                range(0, l.size() / (3 * 3)).
                mapToObj(i -> IntStream.
                        range(0, 3).
                        mapToObj(j -> {
                            Integer p0 = l.get(i * 9 + j);
                            Integer p1 = l.get(i * 9 + 3 + j);
                            Integer p2 = l.get(i * 9 + 6 + j);

                            return new int[]{p0, p1, p2};
                        }).
                        collect(Collectors.toList())
                ).
                flatMap(Collection::stream).
                filter(triangle -> triangle[0] + triangle[1] > triangle[2]).
                filter(triangle -> triangle[0] + triangle[2] > triangle[1]).
                filter(triangle -> triangle[1] + triangle[2] > triangle[0]).
                count();
    }
}
