import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    // Nilai besar (tak terhingga) untuk menandai ruangan kosong.
    private static final int INF = 2147483647; 
    // -1: tembok, tidak bisa dilewati.
    // 0: gerbang, titik awal BFS.

    public void fillDistanceToGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int numRows = rooms.length;
        int numCols = rooms[0].length;
        
        // Deklarasi antrian untuk BFS.
        Queue<int[]> antrian = new LinkedList<>(); 

        // Inisialisasi antrian dengan semua gerbang (nilai 0).
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (rooms[i][j] == 0) {
                    antrian.offer(new int[]{i, j});
                }
            }
        }

        // Arah gerakan: atas, bawah, kiri, kanan.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Proses BFS.
        while (!antrian.isEmpty()) {
            int[] current = antrian.poll();
            int row = current[0];
            int col = current[1];

            // Jelajahi semua arah.
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Cek apakah posisi baru masih dalam batas peta.
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                    // Jika ruangan kosong (INF), isi dengan jarak dan tambahkan ke antrian.
                    if (rooms[newRow][newCol] == INF) {
                        rooms[newRow][newCol] = rooms[row][col] + 1;
                        antrian.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] peta = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        System.out.println("Peta sebelum dihitung jarak dari gerbang:");
        printPeta(peta);

        WallsAndGates solver = new WallsAndGates();
        solver.fillDistanceToGates(peta);

        System.out.println("\nPeta setelah dihitung jarak dari gerbang:");
        printPeta(peta);
    }

    // Fungsi bantu untuk mencetak peta.
    private static void printPeta(int[][] peta) {
        for (int[] row : peta) {
            for (int cell : row) {
                if (cell == INF) {
                    System.out.print("INF\t"); // Untuk tampilan yang lebih mudah dibaca
                } else {
                    System.out.print(cell + "\t");
                }
            }
            System.out.println();
        }
    }
}
