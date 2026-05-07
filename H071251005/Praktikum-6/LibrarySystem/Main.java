import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Library library = new Library();

        // DATA AWAL
        library.addItem(new Book("Buku Java", 101, "Andi"));
        library.addItem(new DVD("Film Naruto", 201, 120));

        library.addMember(new Member("Budi", 1));
        library.addMember(new Member("Aldi", 2));

        while (true) {

            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");

            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine();

            try {

                switch (pilih) {

                    case 1:

                        System.out.println("1. Book");
                        System.out.println("2. DVD");

                        System.out.print("Pilih jenis: ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Judul: ");
                        String title = input.nextLine();

                        System.out.print("ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {

                            System.out.print("Author: ");
                            String author = input.nextLine();

                            library.addItem(
                                    new Book(title, id, author));

                        } else {

                            System.out.print("Durasi: ");
                            int durasi = input.nextInt();

                            library.addItem(
                                    new DVD(title, id, durasi));
                        }

                        System.out.println("Item berhasil ditambahkan");
                        break;

                    case 2:

                        System.out.print("Nama anggota: ");
                        String nama = input.nextLine();

                        System.out.print("ID anggota: ");
                        int memberId = input.nextInt();

                        library.addMember(
                                new Member(nama, memberId));

                        System.out.println("Member berhasil ditambahkan");
                        break;

                    case 3:

                        System.out.print("ID Member: ");
                        int mid = input.nextInt();

                        System.out.print("ID Item: ");
                        int iid = input.nextInt();

                        System.out.print("Lama pinjam: ");
                        int days = input.nextInt();

                        Member member =
                                library.findMemberById(mid);

                        LibraryItem item =
                                library.findItemById(iid);

                        String hasil =
                                member.borrow(item, days);

                        System.out.println(hasil);

                       library.getLogger().logActivity(
                                item.getTitle(),
                                member.getName());

                        break;

                    case 4:

                        System.out.print("ID Member: ");
                        int m = input.nextInt();

                        System.out.print("ID Item: ");
                        int i = input.nextInt();

                        System.out.print("Hari terlambat: ");
                        int late = input.nextInt();

                        Member mem =
                                library.findMemberById(m);

                        LibraryItem it =
                                library.findItemById(i);

                        String res =
                                mem.returnItem(it, late);

                        System.out.println(res);

                       library.getLogger().getLogs(
                                it.getTitle());

                        break;

                    case 5:
                        library.getLibraryStatus();
                        break;

                    case 6:
                        library.getLogger().showLogs();
                        break;

                    case 7:

                        System.out.print("ID Member: ");
                        int idMember = input.nextInt();

                        Member anggota =
                                library.findMemberById(idMember);

                        anggota.getBorrowedItems();

                        break;

                    case 8:

                        System.out.println("Program selesai");
                        input.close();

                        return;

                    default:
                        System.out.println("Menu tidak tersedia");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}