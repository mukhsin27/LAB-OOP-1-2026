import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

   public void addMember(Member member) {

    for (Member m : members) {

        if (m.getMemberId() == member.getMemberId()) {

            throw new IllegalArgumentException(
                    "ID member sudah digunakan!");
        }
    }

        members.add(member);
    }

    public String addItem(LibraryItem item) {

        for (LibraryItem i : items) {

            if (i.getItemId() == item.getItemId()) {

                throw new IllegalArgumentException(
                        "Nomor seri / ID item sudah digunakan!");
            }
        }

        items.add(item);

        return "Item berhasil ditambahkan";
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public LibraryItem findItemById(int itemId) {

        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }

        throw new NoSuchElementException("Item tidak ditemukan!");
    }

    public Member findMemberById(int memberId) {

        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        throw new NoSuchElementException("Member tidak ditemukan!");
    }

    public void getLibraryStatus() {

        System.out.println("+-----+----------------------+------------+");
        System.out.println("| ID  | Judul               | Status     |");
        System.out.println("+-----+----------------------+------------+");

        for (LibraryItem item : items) {

            String status =
                    item.isBorrowed() ? "Dipinjam" : "Tersedia";

            System.out.printf("| %-3d | %-20s | %-10s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    status);
        }

        System.out.println("+-----+----------------------+------------+");
    }
}
