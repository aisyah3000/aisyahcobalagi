package algoritmaquicksort;
import java.util.Random;
import java.util.Scanner;

public class QuickSortVideo {

    // Fungsi utama quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Fungsi partisi
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Tukar arr[i] dan arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Tukar arr[i+1] dan arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Tampilkan sebagian isi array (misalnya 20 elemen pertama)
    public static void previewArray(int[] arr, int count) {
        for (int i = 0; i < Math.min(count, arr.length); i++) {
            System.out.print(arr[i] + " ");
        }
        if (arr.length > count) {
            System.out.print("... (+" + (arr.length - count) + " data)");
        }
        System.out.println();
    }

    // Cetak isi array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Program utama
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah data
        System.out.print("Masukkan jumlah data yang ingin diurutkan: ");
        int size = scanner.nextInt();

        // Buat data acak
        int[] data = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(10000);  // Batas maksimum nilai random
        }

        // Tampilkan data sebelum sorting
        System.out.println("\nData sebelum sorting:");
        if (size <= 50) {
            // 👉 Data KECIL (<= 50), tampilkan seluruh elemen
            printArray(data);
        } else {
            // 👉 Data BESAR (> 50), tampilkan sebagian (preview)
            previewArray(data, 20);
        }

        // Waktu mulai
        long startTime = System.nanoTime();

        // Proses Quick Sort
        quickSort(data, 0, data.length - 1);

        // Waktu selesai
        long endTime = System.nanoTime();

        // Tampilkan data setelah sorting
        System.out.println("\nData setelah sorting:");
        if (size <= 50) {
            // 👉 Data KECIL (<= 50), tampilkan seluruh elemen
            printArray(data);
        } else {
            // 👉 Data BESAR (> 50), tampilkan sebagian (preview)
            previewArray(data, 20);
        }

        // Hitung dan tampilkan durasi
        double durationMs = (endTime - startTime) / 1e6;
        System.out.printf("\nDurasi eksekusi: %.3f ms\n", durationMs);

        scanner.close();
    }
}
