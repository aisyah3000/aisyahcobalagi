import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0], col = point[1];

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != INF) continue;

                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }

    public void printRooms(int[][] rooms) {
        for (int[] row : rooms) {
            for (int val : row) {
                if (val == INF)
                    System.out.print("INF ");
                else
                    System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WallsAndGates solver = new WallsAndGates();

        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        solver.wallsAndGates(rooms);
        solver.printRooms(rooms);
    }
}
