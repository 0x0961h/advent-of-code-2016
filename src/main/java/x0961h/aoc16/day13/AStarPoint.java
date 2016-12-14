package x0961h.aoc16.day13;

import x0961h.aoc16.utils.Point;

/**
 * Created by 0x0961h on 15.12.16.
 */
public class AStarPoint extends Point {
    public AStarPoint previous;

    public AStarPoint(int x, int y) {
        super(x, y);
    }

    public AStarPoint next() {
        AStarPoint p = new AStarPoint(x, y);
        p.previous = this;

        return p;
    }

    public AStarPoint up() {
        super.up();
        return this;
    }

    public AStarPoint down() {
        super.down();
        return this;
    }

    public AStarPoint left() {
        super.left();
        return this;
    }

    public AStarPoint right() {
        super.right();
        return this;
    }
}
