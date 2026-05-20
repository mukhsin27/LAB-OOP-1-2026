public class ProcessingResult{
    String docName;
    String threadName;
    int wordCount;
    long duration;

    ProcessingResult(String docName, String threadName, int wordCount, long duration){
        this.docName = docName;
        this.threadName = threadName;
        this.wordCount = wordCount;
        this.duration = duration;
    }
}