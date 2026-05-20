public abstract class BaseConcurrencyTool {
    protected String toolName;

    BaseConcurrencyTool(String toolName) {
        this.toolName = toolName;
    }

    public abstract void initialize(int count);
    public abstract void shutdown() throws InterruptedException;

    public String getToolName() {
        return toolName;
    }
}