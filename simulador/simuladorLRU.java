import java.util.*;

public class simuladorLRU {
    public static int simulate(List<Integer> pages, int frameCount) {
        Set<Integer> frames = new HashSet<>();
        Map<Integer, Integer> recentUse = new HashMap<>();
        int faults = 0;
        int time = 0;

        for (int page : pages) {
            if (!frames.contains(page)) {
                faults++;
                if (frames.size() == frameCount) {
                    int lruPage = Collections.min(recentUse.entrySet(), Map.Entry.comparingByValue()).getKey();
                    frames.remove(lruPage);
                    recentUse.remove(lruPage);
                }
                frames.add(page);
            }
            recentUse.put(page, time++);
        }
        return faults;
    }
}