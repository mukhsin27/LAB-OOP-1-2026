import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String borrow(LibraryItem item, int days) {
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        borrowedItems.remove(item);

        double fine = item.calculateFine(daysLate);

        String result = item.returnItem();

        return result + " dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {

        System.out.println("+-----+----------------------+");
        System.out.println("| ID  | Judul               |");
        System.out.println("+-----+----------------------+");

        if (borrowedItems.isEmpty()) {
            System.out.println("| Tidak ada item dipinjam  |");
        } else {
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-3d | %-20s |\n",
                        item.getItemId(),
                        item.getTitle());
            }
        }

        System.out.println("+-----+----------------------+");
    }
}