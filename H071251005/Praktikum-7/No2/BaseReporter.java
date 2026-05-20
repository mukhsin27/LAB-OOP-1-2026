
public abstract class BaseReporter {
    protected String reporterName;

    BaseReporter(String reporterName) {
        this.reporterName = reporterName;
    }

    public abstract void report(Object... args);

    public String getReporterName() {
        return reporterName;
    }
}