import java.util.*;

class simuladorAging {
    static class Frame {
        int page = -1;
        int age = 0;
    }

    public static int simulate(List<Integer> pages, int frameCount) {
        int faults = 0;
        Frame[] frames = new Frame[frameCount];
        for (int i = 0; i < frameCount; i++) frames[i] = new Frame();

        for (int page : pages) {
            boolean found = false;
            for (Frame frame : frames) {
                if (frame.page == page) {
                    frame.age |= 0b10000000;
                    found = true;
                    break;
                }
            }

            if (!found) {
                faults++;
                Frame toReplace = frames[0];
                for (Frame frame : frames) {
                    if (frame.page == -1 || frame.age < toReplace.age) {
                        toReplace = frame;
                    }
                }
                toReplace.page = page;
                toReplace.age = 0b10000000;
            }

            for (Frame frame : frames) {
                frame.age >>>= 1;
            }
        }
        return faults;
    }
}