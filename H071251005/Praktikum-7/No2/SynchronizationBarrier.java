import java.util.concurrent.CountDownLatch;

public class SynchronizationBarrier extends BaseConcurrencyTool {
    private CountDownLatch latch;

    SynchronizationBarrier(int totalTasks) {
        super("SynchronizationBarrier");
        initialize(totalTasks);
    }

    @Override
    public void initialize(int count) {
        this.latch = new CountDownLatch(count);
    }

    public void countDown() {
        latch.countDown();
    }

    public void waitForAll() throws InterruptedException {
        latch.await();
    }

    @Override
    public void shutdown() {
        // tidak perlu shutdown untuk CountDownLatch
    }
}