import java.util.Arrays;

public class Game {

    int[] rolls = new int[21];
    int index = 0;
    int individualFrameScore[] = new int[10];

    public void roll(int pinsKnockedDown) {
        rolls[index] = pinsKnockedDown;
        index++;
    }

    public int score() {

        for (int rollIndex = 0, frameIndex = 0; frameIndex < 10; frameIndex++) {

            if (rolls[rollIndex] == 10) {
                individualFrameScore[frameIndex] = 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex++;
            } else if (rolls[rollIndex] + rolls[rollIndex + 1] == 10) {
                individualFrameScore[frameIndex] = 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                individualFrameScore[frameIndex] = rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }

        }

        return Arrays.stream(individualFrameScore).sum();
    }


}
