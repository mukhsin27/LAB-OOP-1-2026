public abstract class BaseProcessor{
    protected String processorName;

    BaseProcessor(String processorName){
        this.processorName = processorName;
    }

    public abstract int process(String fileName)throws InterruptedException;

    public String getProcessorName(){
        return processorName;
    }
}