import java.util.Random;

public class DataProcessor extends BaseProcessor{
    private static final Random random = new Random();

    DataProcessor(){
        super("DataProcessor");
    }
    @Override
    public int process(String fileName) throws InterruptedException {
        int sleepTime = 500 + (random.nextInt(1501));
        Thread.sleep(sleepTime);
        return 50 + random.nextInt(451);
    }
}