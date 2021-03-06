package x0961h.aoc16.utils;

/**
 * Created by 0x0961h on 02.12.16.
 */
public class Point {
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point cpy() {
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point up() {
        y++;
        return this;
    }

    public Point down() {
        y--;
        return this;
    }

    public Point left() {
        x--;
        return this;
    }

    public Point right() {
        x++;
        return this;
    }

    public int manhattan(int x1, int y1) {
        return Math.abs(x1 - x) + Math.abs(y1 - y);
    }

    public int manhattan(Point p) {
        return Math.abs(p.x - x) + Math.abs(p.y - y);
    }
}
