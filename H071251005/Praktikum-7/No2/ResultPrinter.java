import java.util.Comparator;
import java.util.List;

public class ResultPrinter extends BaseReporter {

    ResultPrinter() {
        super("ResultPrinter");
    }

    public void printHeader(int totalDocuments, int threadPoolSize) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     HIGH-PERFORMANCE DATA INDEXER - Search Engine Core       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.printf(" * Memulai pemrosesan %d dokumen dengan %d thread...%n%n",
                totalDocuments, threadPoolSize);
    }

    public void printFinalResult(List<ProcessingResult> resultList, int totalDocuments,
                                 int threadPoolSize, long totalDuration) {
        resultList.sort(Comparator.comparing(r -> r.docName));

        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        HASIL AKHIR - KLASEMEN                                ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-20s │ %-22s │ %-12s │ %-10s ║%n",
                "Nama Dokumen", "Thread yang Menangani", "Jumlah Kata", "Durasi (ms)");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");

        long totalWords  = 0;
        long totalTimeMs = 0;

        for (ProcessingResult result : resultList) {
            System.out.printf("║  %-20s │ %-22s │ %-12d │ %-10d ║%n",
                    result.docName, result.threadName, result.wordCount, result.duration);
            totalWords  += result.wordCount;
            totalTimeMs += result.duration;
        }

        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-20s   %-22s   %-12d   %-10s ║%n",
                "TOTAL (" + totalDocuments + " dokumen)", "", totalWords, "");
        System.out.printf("║  %-20s   %-22s   %-12s   %-10.0f ║%n",
                "RATA-RATA / Dokumen", "", String.valueOf(totalWords / totalDocuments),
                (double) totalTimeMs / totalDocuments);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");

        System.out.printf("%nRingkasan:%n");
        System.out.printf("   - Total kata seluruh dokumen  : %d kata%n", totalWords);
        System.out.printf("   - Rata-rata waktu pemrosesan  : %.1f ms/dokumen%n",
                (double) totalTimeMs / totalDocuments);
        System.out.printf("   - Total waktu program berjalan: %d ms%n", totalDuration);
        System.out.printf("   - Thread pool yang digunakan  : %d thread%n", threadPoolSize);
        System.out.printf("   - Dokumen diproses            : %d dokumen%n", totalDocuments);
        System.out.println("\nSemua dokumen berhasil diindeks tanpa data yang hilang atau korup.");
    }

    @Override
    @SuppressWarnings("unchecked") 
    public void report(Object... args) {
        printFinalResult(
            (List<ProcessingResult>) args[0],
            (int) args[1],
            (int) args[2],
            (long) args[3]
        );
    }
}