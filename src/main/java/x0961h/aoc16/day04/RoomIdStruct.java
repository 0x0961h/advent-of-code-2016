package x0961h.aoc16.day04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 04.12.16.
 */
public class RoomIdStruct {
    private static Pattern roomIdPattern = Pattern.compile("^([a-z-]+)(\\d+)\\[([a-z]+)]");

    public final String roomId;
    public final String name;
    public final int sectorId;
    public final String checksum;
    public String realName;

    public RoomIdStruct(String roomId) {
        this.roomId = roomId;
        Matcher mat = roomIdPattern.matcher(roomId);

        if (!mat.find()) throw new RuntimeException("Incorrect input: " + roomId);

        name = mat.group(1);
        sectorId = Integer.parseInt(mat.group(2));
        checksum = mat.group(3);
    }
}
