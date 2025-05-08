import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a sequencia de paginas: ");
        String input = scanner.nextLine();
        String[] pages = input.trim().split("\\s+");
        List<Integer> pageSequence = new ArrayList<>();
        for (String page : pages) {
            pageSequence.add(Integer.parseInt(page));
        }

        System.out.println("Digite o tamanho da memoria: ");
        int frameCount = scanner.nextInt();

        int fifoFaults = simuladorFIFO.simulate(pageSequence, frameCount);
        int lruFaults = simuladorLRU.simulate(pageSequence, frameCount);
        int clockFaults = simuladorClock.simulate(pageSequence, frameCount);
        int agingFaults = simuladorAging.simulate(pageSequence, frameCount);

        System.out.println("Resultados:");
        System.out.println("FIFO: " + fifoFaults + " faltas de pagina");
        System.out.println("LRU: " + lruFaults + " faltas de pagina");
        System.out.println("Clock: " + clockFaults + " faltas de pagina");
        System.out.println("Aging: " + agingFaults + " faltas de pagina");
    }
}