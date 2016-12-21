package x0961h.aoc16.day17;

import x0961h.aoc16.utils.Point;

public class MemoryPoint extends Point {
    private String path;

    public MemoryPoint() {
        this("");
    }

    public MemoryPoint(int x, int y) {
        this(x, y, "");
    }

    public MemoryPoint(String path) {
        this.path = path;
    }

    public MemoryPoint(int x, int y, String path) {
        super(x, y);
        this.path = path;
    }

    public String path() {
        return path;
    }

    @Override
    public MemoryPoint cpy() {
        return new MemoryPoint(x, y, path);
    }

    @Override
    public MemoryPoint up() {
        y--;
        path += "U";
        return this;
    }

    @Override
    public MemoryPoint down() {
        y++;
        path += "D";
        return this;
    }

    @Override
    public MemoryPoint left() {
        x--;
        path += "L";
        return this;
    }

    @Override
    public MemoryPoint right() {
        x++;
        path += "R";
        return this;
    }


    @Override
    public String toString() {
        return x + "x" + y + " (" + path + ")";
    }
}
