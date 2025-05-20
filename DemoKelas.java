public class DemoKelas {
    public static void main(String[] args) {
        siswa Rahma = new siswa("Rahma");

        Kelas k = new Kelas(Rahma);

        siswa Rizka = new siswa("Rizka");
        k.tambahDiBelakang(new siswa ("Rizka"));
        k.tambahDiBelakang(new siswa("Amanda"));
        k.tambahDiBelakang(new siswa("Aisyah"));
        k.tambahDiBelakang(new siswa("Jingga"));
        k.hapus("Rizka");
        k.tampilkansemua(); 

        System.out.println("jumlah siswa: " + k.jumlahsiswa());
        System.out.println("urutan Riska: " + k.urutan("Rizka"));
        System.out.println("siswa di index 2: " + k.ambilDi(2).nama);

        k.hapus("Rizka");
        System.out.println("setelah hapus Rizka:");
        k.tampilkansemua();
    }
}