public class Kelas {
    siswa pertama;
    siswa terakhir;

    public Kelas(siswa x) {
        pertama = x;
        terakhir =  x;
    }

    public siswa ambilDi(Integer index){
        if (index < 0){
        return null;
    }
    siswa sekarang = pertama;
    int hitung = 0;

    while (sekarang != null && hitung < index);{
        sekarang = sekarang.berikutnya;
        hitung++;
        }
        return (sekarang == null) ? null : sekarang;
    }

    public Integer urutan(String nama){
        siswa sekarang = pertama;
        int urutan =0;

        while (sekarang != null){
            if (sekarang.nama.equals(nama)){
                return urutan;
            }
            sekarang = sekarang.berikutnya;
            urutan++;
        }
        return null;
    }

    public Integer jumlahsiswa(){
        siswa sekarang = pertama;
        int jumlah = 0;

        while (sekarang != null){
            jumlah++;
            sekarang = sekarang.berikutnya;
        }
        return jumlah;
    }

    public void tambahSetelah(String nama, siswa s){
        siswa sekarang = pertama;

        while (sekarang != null){
            if (sekarang.nama.equals(nama)){
                s.berikutnya = sekarang.berikutnya;
                sekarang.berikutnya = s;
                return;
            }
            sekarang = sekarang.berikutnya;
        }
    }

    public void hapus(String nama){
        if (pertama == null){
            return;
        }
        if (pertama.nama.equals(nama)){
            return;
        }
        siswa sekarang =pertama;
        while (sekarang.berikutnya != null){
            if (sekarang.berikutnya.nama.equals(nama)){
                sekarang.berikutnya = sekarang.berikutnya.berikutnya;
                return;
            }
            sekarang = sekarang.berikutnya;
        }
    }

    public void tambahDiBelakang(siswa s){
        siswa terakhir = cariTerakhir();
        terakhir.berikutnya = s;
    }
    
    public void tampilkansemua() {
        Integer urutan = 0;
        System.out.println("sekarang urutan ke :"+urutan);

        siswa sekarang = pertama; //Rahma
        System.out.println("siswa sekarang :"+sekarang.nama);

        while(sekarang.berikutnya != null) {
            urutan++;
            System.out.println("sekarang urutan :"+urutan);
            // pindah ke recodr berikutnya
            sekarang = sekarang.berikutnya;
            System.out.println("siswa sekarang :"+sekarang.nama);

        }

    }
    private siswa cariTerakhir(){
        siswa sekarang = pertama;
        while(sekarang.berikutnya != null){
            sekarang = sekarang.berikutnya;
        }
        return sekarang;
    }

}