package x0961h.aoc16.day19;

public class Elf {
    public final int index;
    public int presents;
    public Elf neighbour;

    public Elf(int index) {
        this.index = index;
        this.presents = 1;
    }

    public void takePresentsFromNeighbour() {
        Elf finalNeighbour = getNeighbour();

        this.presents += finalNeighbour.presents;
        finalNeighbour.presents = 0;
    }

    public Elf getNeighbour() {
        Elf finalNeighbour = neighbour;
        while (!finalNeighbour.hasPresents()) finalNeighbour = finalNeighbour.neighbour;
        return finalNeighbour;
    }

    public boolean hasPresents() {
        return this.presents != 0;
    }


    @Override
    public String toString() {
        return "#" + index +
                " (" + presents +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elf elf = (Elf) o;

        return index == elf.index;

    }

    @Override
    public int hashCode() {
        return index;
    }
}
