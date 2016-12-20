package x0961h.aoc16.day19;

public class ElfAdvanced {
    public final int index;
    public int presents;
    public float angle;
    public ElfAdvanced neighbour;

    public ElfAdvanced(int index) {
        this.index = index;
        this.presents = 1;
    }

    @Override
    public String toString() {
        return "#" + index + " " + angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElfAdvanced that = (ElfAdvanced) o;

        return index == that.index;

    }

    @Override
    public int hashCode() {
        return index;
    }

    public ElfAdvanced getNeighbour() {
        ElfAdvanced finalNeighbour = neighbour;
        while (!finalNeighbour.hasPresents()) finalNeighbour = finalNeighbour.neighbour;
        return finalNeighbour;
    }

    private boolean hasPresents() {
        return presents != 0;
    }
}
