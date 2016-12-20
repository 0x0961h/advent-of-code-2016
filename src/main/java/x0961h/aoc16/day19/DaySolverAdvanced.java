package x0961h.aoc16.day19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 0x0961h on 19.12.16.
 */
public class DaySolverAdvanced {
    private static float SECTOR;

    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(3004953));
    }

    public static int solve(int elvesCount) {
        SECTOR = (1f / elvesCount * 360);

        long time = new Date().getTime();

        List<ElfAdvanced> elves = new LinkedList<>();
        for (int i = 0; i < elvesCount; i++) {
            ElfAdvanced ea = new ElfAdvanced(i + 1);
            if (i != 0) elves.get(i - 1).neighbour = ea;
            elves.add(ea);
        }
        elves.get(elvesCount - 1).neighbour = elves.get(0);

        recalculateAngles(elves);

        ElfAdvanced activeElf = elves.get(0);
        while (elves.size() > 1) {
            System.out.println(elves);

            int index = getOppositeIndex(activeElf, elves);
            elves.get(index).presents = 0;
//            elves.remove(index);
            recalculateAngles(elves);
            activeElf = activeElf.getNeighbour();
        }

        System.out.println((new Date().getTime() - time) / 1000 + "s elapsed");
        System.out.println(((float) ((new Date().getTime() - time)) / elvesCount) + "ms per elf");

        return activeElf.index;
    }

    private static int getOppositeIndex(ElfAdvanced activeElf, List<ElfAdvanced> elves) {
        float targetAngle = activeElf.angle + 180;
        return (int) Math.floor(targetAngle / SECTOR) % elves.size();
    }

    private static void recalculateAngles(List<ElfAdvanced> elves) {
        for (int i = 0; i < elves.size(); i++) {
            elves.get(i).angle = (float) i * SECTOR;
        }
    }
}
