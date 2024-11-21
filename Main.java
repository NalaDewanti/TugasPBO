import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean ulang = true;
            
            while (ulang) {
                try {
                    // Input data transaksi
                    System.out.print("Masukkan No Faktur: ");
                    int noFaktur = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    System.out.print("Masukkan Kode Barang: ");
                    String kodeBarang = scanner.nextLine();
                    
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    
                    System.out.print("Masukkan Harga Barang: ");
                    double hargaBarang = scanner.nextDouble();
                    
                    Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang);
                    
                    System.out.print("Masukkan Jumlah Beli: ");
                    int jumlahBeli = scanner.nextInt();
                    transaksi.setJumlahBeli(jumlahBeli);
                    
                    // Menampilkan detail transaksi
                    System.out.println("\n--- Detil Transaksi ---");
                    transaksi.tampilkanTransaksi();
                    
                    // Menanyakan apakah ingin transaksi lain
                    System.out.print("\nApakah Anda ingin melakukan transaksi lain? (ya/tidak): ");
                    scanner.nextLine(); // Clear buffer
                    String pilihan = scanner.nextLine().toLowerCase();
                    
                    if (pilihan.equals("tidak")) {
                        System.out.println("Terima kasih telah menggunakan layanan kami.");
                        ulang = false;
                    }
                    
                } catch (IllegalArgumentException e) {
                    // Menangani input invalid
                    System.out.println("Error: " + e.getMessage());
                    System.out.print("\nApakah Anda ingin melakukan transaksi lain? (ya/tidak): ");
                    scanner.nextLine(); // Clear buffer
                    String pilihan = scanner.nextLine().toLowerCase();
                    
                    if (pilihan.equals("tidak")) {
                        System.out.println("Terima kasih telah menggunakan layanan kami.");
                        ulang = false;
                    }
                    
                } catch (Exception e) {
                    // Menangani kesalahan umum
                    System.out.println("\nTerjadi kesalahan input. Silakan coba lagi.");
                    scanner.nextLine(); // Clear buffer
                }
            }
        }
    }
}
