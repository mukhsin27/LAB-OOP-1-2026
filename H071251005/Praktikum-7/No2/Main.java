import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<String> documents = Arrays.asList(
            "Dokumen_A.txt", "Dokumen_B.txt", "Dokumen_C.txt",
            "Dokumen_D.txt", "Dokumen_E.txt", "Dokumen_F.txt",
            "Dokumen_G.txt", "Dokumen_H.txt", "Dokumen_I.txt",
            "Dokumen_J.txt"
        );

        DataProcessor          dataProcessor = new DataProcessor();
        ThreadManager          threadManager = new ThreadManager(4);
        SynchronizationBarrier barrier       = new SynchronizationBarrier(documents.size());
        ProgressMonitor        monitor       = new ProgressMonitor(documents.size());
        ResultPrinter          printer       = new ResultPrinter();

        ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();
        List<ProcessingResult> resultList = Collections.synchronizedList(new ArrayList<>());

        printer.printHeader(documents.size(), threadManager.getThreadPoolSize());

        long programStart = System.currentTimeMillis();

        for (String docName : documents) {
            DocumentTask task = new DocumentTask(
                docName, dataProcessor, wordCountMap, resultList, barrier, monitor
            );
            threadManager.submit(task);
        }

        barrier.waitForAll();
        threadManager.shutdown();

        long totalDuration = System.currentTimeMillis() - programStart;
        printer.printFinalResult(resultList, documents.size(), threadManager.getThreadPoolSize(), totalDuration);
    }
}