import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {

    private List<String[]> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public void logActivity(String title, String member) {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String borrowTime =
                LocalDateTime.now().format(format);

        logs.add(new String[]{
                borrowTime,
                title,
                member,
                "-"
        });
    }

    public void getLogs(String title) {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String returnTime =
                LocalDateTime.now().format(format);

        for (String[] log : logs) {

            if (log[1].equals(title) && log[3].equals("-")) {
                log[3] = returnTime;
                break;
            }
        }
    }

    public void showLogs() {

        System.out.println(
                "+---------------------+----------------------+------------+---------------------+");

        System.out.println(
                "| Dipinjam pada       | Judul               | Member     | Dikembalikan pada   |");

        System.out.println(
                "+---------------------+----------------------+------------+---------------------+");

        for (String[] log : logs) {

            System.out.printf(
                    "| %-19s | %-20s | %-10s | %-19s |\n",
                    log[0],
                    log[1],
                    log[2],
                    log[3]
            );
        }

        System.out.println(
                "+---------------------+----------------------+------------+---------------------+");
    }

    public void clearLogs() {
        logs.clear();
    }
}