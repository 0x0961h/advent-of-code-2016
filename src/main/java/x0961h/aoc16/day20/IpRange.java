package x0961h.aoc16.day20;

public class IpRange {
    public long low, high;

    public IpRange(String[] split) {
        low = Long.parseLong(split[0]);
        high = Long.parseLong(split[1]);
    }

    @Override
    public String toString() {
        return low + " - " + high;
    }
}
