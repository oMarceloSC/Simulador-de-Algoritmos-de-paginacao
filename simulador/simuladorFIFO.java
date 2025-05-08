import java.util.*;

public class simuladorFIFO {
    public static int simulate(List<Integer> pages, int frameCount){
        Set<Integer> frames = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int faults = 0;

        for (int page : pages) {
            if (!frames.contains(page)) {
                faults++;
                if (frames.size() == frameCount) {
                    int oldest = queue.poll();
                    frames.remove(oldest);
                }
                frames.add(page);
                queue.add(page);
            }
        }
        return faults;
    }
}