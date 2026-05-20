import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager extends BaseConcurrencyTool {
    private ExecutorService executor;
    private int threadPoolSize;

    ThreadManager(int threadPoolSize) {
        super("ThreadManager");
        this.threadPoolSize = threadPoolSize;
        initialize(threadPoolSize);
    }

    @Override
    public void initialize(int count) {
        this.executor = Executors.newFixedThreadPool(count);
    }

    public void submit(Runnable task) {
        executor.submit(task);
    }

    @Override
    public void shutdown() throws InterruptedException {
        executor.shutdown();
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }
}