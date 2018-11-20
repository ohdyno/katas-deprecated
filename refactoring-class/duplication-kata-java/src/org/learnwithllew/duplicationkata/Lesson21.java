package org.learnwithllew.duplicationkata;

public class Lesson21 extends Song {
    public void singSong(int style, String... names) {
        switch (style) {
            case 1:
                singAboutItAlready("L", 0, true, "Hip Hip Horray! For ", names);
                break;
            case 2:
                singAboutItAlready("am", 1, true, "Say yeah! Say yo! Say ", names);
                break;
            case 3:
                singAboutItAlready(null, 0, false, "Say yeah! Say yo! Say ", names);
                break;
        }
    }

    private void singAboutItAlready(String prefix, int offset, boolean shouldSingAboutSongName, String songLine, String[] names) {
        for (String name : names) {
            if (shouldSingAboutSongName && name.startsWith(prefix, offset)) {
                sing(songLine + name);
            } else {
                sing("Hello " + name + ", it's nice to meet you.");
            }
        }
    }
}
