package x0961h.aoc16.day15;

/**
 * Created by 0x0961h on 15.12.16.
 */
public class Disc {
    public final int index;
    public final int posCount;
    public int currPos;

    public Disc(int index, int posCount, int currPos) {
        this.index = index;
        this.posCount = posCount;
        this.currPos = currPos;
    }

    public Disc(String index, String posCount, String currPos) {
        this(Integer.parseInt(index), Integer.parseInt(posCount), Integer.parseInt(currPos));
    }

    public Disc cpy() {
        return new Disc(index, posCount, currPos);
    }

    public Disc inc() {
        if (++currPos == posCount) currPos = 0;
        return this;
    }

    @Override
    public String toString() {
        return "Disc #" + index + ": " + currPos + "/" + posCount;
    }
}
