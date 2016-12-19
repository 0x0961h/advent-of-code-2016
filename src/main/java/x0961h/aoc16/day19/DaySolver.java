package x0961h.aoc16.day19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 0x0961h on 19.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(3004953));
    }

    public static int solve(int elvesCount) {
        List<Elf> elves = new ArrayList<>();
        for (int i = 0; i < elvesCount; i++) elves.add(new Elf(i + 1));
        for (int i = 0; i < elvesCount; i++) elves.get(i).neighbour = elves.get(i == elvesCount - 1 ? 0 : i + 1);

        Elf activeElf = elves.get(elvesCount - 1);
        while (!activeElf.getNeighbour().equals(activeElf)) {
            activeElf = activeElf.getNeighbour();
            activeElf.takePresentsFromNeighbour();
        }

        return activeElf.index;
    }
}
