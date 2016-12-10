package x0961h.aoc16.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 10.12.16.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day10", "data.txt")));
        solve(input);
    }

    public static void solve(String input) {
        Bot[] bots = initBots(input);

        int oc = getOutputCount(input);
        int[] outputs = IntStream.range(0, oc).map(operand -> -1).toArray();

        while (Arrays.stream(bots).anyMatch(Bot::isActive)) iterate(bots, outputs);

        System.out.println(Arrays.toString(outputs));
    }

    private static void iterate(Bot[] bots, int[] outputs) {
        Arrays.stream(bots).
                filter(Bot::isActive).
                forEach(bot -> bot.act(bots, outputs));
    }

    private static Bot[] initBots(String input) {
        Bot[] bots = new Bot[getBotCount(input)];

        Pattern valuePattern = Pattern.compile("value (\\d+) goes to bot (\\d+)");
        Pattern givingPattern = Pattern.compile("bot (\\d+) gives low to (bot|output) (\\d+) and high to (bot|output) (\\d+)");

        Arrays.stream(input.split("\r?\n")).
                forEach(cmd -> {
                    if (cmd.startsWith("bot ")) {
                        Matcher mat = givingPattern.matcher(cmd);
                        if (!mat.find()) throw new RuntimeException("Wrong command format: " + cmd);

                        int botIndex = Integer.parseInt(mat.group(1));

                        boolean isObjLowBot = mat.group(2).equals("bot");
                        int objLowIndex = Integer.parseInt(mat.group(3));

                        boolean isObjHighBot = mat.group(4).equals("bot");
                        int objHighIndex = Integer.parseInt(mat.group(5));

                        if (bots[botIndex] == null) bots[botIndex] = new Bot(botIndex);

                        bots[botIndex].givesHighTo = objHighIndex;
                        bots[botIndex].givesLowTo = objLowIndex;

                        bots[botIndex].givesHighToBot = isObjHighBot;
                        bots[botIndex].givesLowToBot = isObjLowBot;
                    } else if (cmd.startsWith("value ")) {
                        Matcher mat = valuePattern.matcher(cmd);
                        if (!mat.find()) throw new RuntimeException("Wrong command format: " + cmd);
                        int botIndex = Integer.parseInt(mat.group(2));
                        int value = Integer.parseInt(mat.group(1));

                        if (bots[botIndex] == null) bots[botIndex] = new Bot(botIndex);
                        bots[botIndex].passValue(value);
                    } else {
                        throw new RuntimeException("Unknown command: " + cmd);
                    }
                });

        return bots;
    }

    private static int getBotCount(String input) {
        int botMax = Integer.MIN_VALUE;
        Matcher mat = Pattern.compile("bot (\\d+)").matcher(input);
        while (mat.find()) botMax = Math.max(botMax, Integer.parseInt(mat.group(1)));
        return botMax + 1;
    }

    private static int getOutputCount(String input) {
        int outputMax = Integer.MIN_VALUE;
        Matcher mat = Pattern.compile("output (\\d+)").matcher(input);
        while (mat.find()) outputMax = Math.max(outputMax, Integer.parseInt(mat.group(1)));
        return outputMax + 1;
    }

    private static class Bot {
        private final int index;

        private int value1 = -1;
        private int value2 = -1;
        private boolean givesLowToBot;
        private boolean givesHighToBot;
        private int givesLowTo;
        private int givesHighTo;

        Bot(int index) {
            this.index = index;
        }

        void passValue(int value) {
            if (value1 == -1) value1 = value;
            else if (value2 == -1) value2 = value;
            else throw new RuntimeException("Bot can hold only two chips");
        }

        boolean isActive() {
            return value1 != -1 && value2 != -1;
        }

        void act(Bot[] bots, int[] outputs) {
            int low = Math.min(value1, value2);
            int high = Math.max(value1, value2);

            value1 = -1;
            value2 = -1;

            if (givesLowToBot)
                bots[givesLowTo].passValue(low);
            else
                outputs[givesLowTo] = low;

            if (givesHighToBot)
                bots[givesHighTo].passValue(high);
            else
                outputs[givesHighTo] = high;

            if (low == 17 && high == 61) {
                System.err.println("BOT #" + index + " JUST COMPARED 2 AND 5");
            }
        }
    }
}
