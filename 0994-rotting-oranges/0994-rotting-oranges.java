class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        // Put all rotten oranges into queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }            }        }       
                 int minutes = 0;
        int[][] directions = {
            {-1, 0},   // up
            {1, 0},    // down
            {0, -1},   // left
            {0, 1}     // right
        };
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
               int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
               for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        if (fresh == 0) {
            return minutes;
        }
        return -1;
    }
}