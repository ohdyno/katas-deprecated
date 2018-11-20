package org.learnwithllew.duplicationkata;

public class Lesson2Variable extends Song {
    public void singBottlesOfBeer() {

        bottlesOfBeerSong(100);
        bottlesOfBeerSong(99);
    }

    private void bottlesOfBeerSong(int bottlesOfBeer) {
        sing(bottlesOfBeer + " bottles of beer on the wall");
        sing(bottlesOfBeer + " bottles of beer");
        sing("Take one down, pass it around");
        sing(bottlesOfBeer - 1 + " bottles of beer on the wall");
    }
}
