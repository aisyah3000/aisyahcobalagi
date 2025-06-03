public class DemoKelas {
    public static void main(String[] args) {
        Siswa Upin = new Siswa("Upin");

        Kelas k = new Kelas(Upin);

        Siswa Ipin = new Siswa("Ipin");
        k.tambahDiBelakang(new Siswa ("Ipin"));
        k.tambahDiBelakang(new Siswa("Apin"));
        k.tambahDiBelakang(new Siswa("Susanti"));
        k.tambahDiBelakang(new Siswa("Fizi"));
        k.hapus("Ipin");
        k.tampilkansemua(); 

        k.tambahDiDepan(new Siswa("Ehsan"));
        System.out.println("===========================");
        k.tampilkansemua();

        Integer urutan = 7;
        Siswa x = k.ambilDi(urutan);
        if(x != null) {
            System.out.println("Siswa urutan "+ urutan +" : "+x.nama);
        } else {
            System.out.println("Siswa urutan "+urutan+" tidak ada");  
        }

        System.out.println("======================");
        System.out.println("jumlah Siswa : "+k.jumlahSiswa());

        Kelas k1 = new Kelas(null);
        System.out.println("jumlah Siswa : "+k1.jumlahSiswa());

        System.out.println("======================");
        System.out.println("Cari nama Mail di kelas kosong : " +k1.urutan("Mail"));
        System.out.println("Cari nama Mail di kelas berisi : " +k.urutan("Mail"));
        System.out.println("Cari nama Upin di kelas berisi : " +k.urutan("Upin"));
        System.out.println("Cari nama Ipin di kelas berisi : " +k.urutan("Ipin"));
        System.out.println("Cari nama Ehsan di kelas berisi : " +k.urutan("Ehsan"));

        System.out.println("======================");
        k.tambahSetelah("Apin", new Siswa("Jarjit"));
        k.tampilkansemua();
        System.out.println("jumlah Siswa : "+k.jumlahSiswa());

        System.out.println("======================");
        k1.hapus("Meimei");
        k1 = new Kelas(new Siswa("Meimei"));
        System.out.println("Setelah di-add");
        k1.tampilkansemua();
        k1.hapus("Meimei");
        System.out.println("Setelah dihapus");
        k1.tampilkansemua();

        System.out.println("===== Sebelum dihapus =====");
        k.tampilkansemua();
        k.hapus("Ehsan");
        System.out.println("===== Setelah hapus pertama =====");
        k.tampilkansemua();
        k.hapus("Susanti");
        System.out.println("===== Setelah hapus tengah =====");
        k.tampilkansemua();
        k.hapus("Fizi");
        System.out.println("===== Setelah hapus akhir =====");
        k.tampilkansemua();
    }    
}
