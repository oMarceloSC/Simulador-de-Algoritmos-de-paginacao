import java.util.*;

public class simuladorClock {
    public static int simulate(List<Integer> pages, int frameCount){
        int faults = 0;
        int[] frames = new int[frameCount];
        boolean[] referenceBits = new boolean[frameCount];
        Arrays.fill(frames, -1);

        int pointer = 0;
        for (int page : pages) {
            boolean found = false;
            for (int i = 0; i < frameCount; i++) {
                if (frames[i] == page){
                    referenceBits[i] = true;
                    found = true;
                    break;
                }
            }
        
            if (!found) {
                faults++;
                while (referenceBits[pointer]) {
                    referenceBits[pointer] = false;
                    pointer = (pointer + 1) % frameCount;
                }
                frames[pointer] = page;
                referenceBits[pointer] = true;
                pointer = (pointer + 1) % frameCount;
            }
        }
        return faults;
    }
}