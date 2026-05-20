import java.util.concurrent.atomic.AtomicInteger;

public class ProgressMonitor extends BaseReporter {
    private final AtomicInteger completedCount = new AtomicInteger(0);
    private final int           totalDocuments;

    ProgressMonitor(int totalDocuments) {
        super("ProgressMonitor");
        this.totalDocuments = totalDocuments;
    }

    public void reportProgress(String threadName, String docName, int wordCount, long duration) {
        int done = completedCount.incrementAndGet();
        System.out.printf("[%s] Selesai memproses %s (%d kata) | Durasi: %dms | Progres: %d/%d%n",
                threadName, docName, wordCount, duration, done, totalDocuments);
    }

    @Override
    public void report(Object... args) {
        reportProgress((String) args[0], (String) args[1], (int) args[2], (long) args[3]);
    }
}