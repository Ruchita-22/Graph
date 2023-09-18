import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        return true;
    }

    public void dfs(int row, int col, int[][] grid, boolean[][] visited, List<Position> visitedPosition) {
        if (!isValid(row, col, grid) || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        visitedPosition.add(new Position(row, col));
        dfs(row + 1, col, grid, visited, visitedPosition);
        dfs(row - 1, col, grid, visited, visitedPosition);
        dfs(row, col + 1, grid, visited, visitedPosition);
        dfs(row, col - 1, grid, visited, visitedPosition);
    }

    public int bfs(int[][] grid, boolean[][] visited, List<Position> visitedPosition) {
        int flip = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Deque<Position> deque = new LinkedList<Position>(visitedPosition);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Position position = deque.pollFirst();
                int row = position.row;
                int col = position.col;
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (!isValid(newRow, newCol, grid) || visited[newRow][newCol]) {
                        continue;
                    }
                    if (grid[newRow][newCol] == 1) {
                        return flip;
                    }
                    deque.add(new Position(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
            flip++;
        }
        return flip;
    }

    public int shortestBridge(int[][] grid) {
        int result = 0;
        List<Position> visitedPosition = new ArrayList<Position>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col, grid, visited, visitedPosition);
                    return bfs(grid, visited, visitedPosition);
                }
            }
        }
        return result;
    }

}
