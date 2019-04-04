public class Game {

    private int[] rolls = new int[21];
    private int index = 0;

    public void roll(int pinsKnockedDown) {
        rolls[index] = pinsKnockedDown;
        index++;
    }

    public int score() {
        int totalScore = 0;

        for (int rollIndex = 0, frameIndex = 0; frameIndex < 10; frameIndex++) {

            if (isAStrike(rollIndex)) {
                totalScore += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isASpare(rollIndex)) {
                totalScore += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                totalScore += frameScore(rollIndex);
                rollIndex += 2;
            }

        }

        return totalScore;
    }

    private int frameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isASpare(int rollIndex) {
        return frameScore(rollIndex) == 10;
    }

    private boolean isAStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }


}
