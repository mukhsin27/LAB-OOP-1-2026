import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DocumentTask extends BaseProcessor implements Runnable {
    private final String                            docName;
    private final BaseProcessor                     processor;
    private final ConcurrentHashMap<String, Integer> wordCountMap;
    private final List<ProcessingResult>            resultList;
    private final SynchronizationBarrier            barrier;
    private final ProgressMonitor                   monitor;

    DocumentTask(String docName, BaseProcessor processor,
                 ConcurrentHashMap<String, Integer> wordCountMap,
                 List<ProcessingResult> resultList,
                 SynchronizationBarrier barrier,
                 ProgressMonitor monitor) {
        super("DocumentTask-" + docName);
        this.docName      = docName;
        this.processor    = processor;
        this.wordCountMap = wordCountMap;
        this.resultList   = resultList;
        this.barrier      = barrier;
        this.monitor      = monitor;
    }

    @Override
    public int process(String fileName) throws InterruptedException {
        return processor.process(fileName);
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        long   startTime  = System.currentTimeMillis();

        try {
            int  wordCount = process(docName);
            long duration  = System.currentTimeMillis() - startTime;

            wordCountMap.put(docName, wordCount);
            resultList.add(new ProcessingResult(docName, threadName, wordCount, duration));
            monitor.reportProgress(threadName, docName, wordCount, duration);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("[%s] ERROR: %s%n", threadName, e.getMessage());
        } finally {
            barrier.countDown();
        }
    }
}
