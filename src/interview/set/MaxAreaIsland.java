package interview.set;

public class MaxAreaIsland {
    public int maxArea(int[][] area) {
        int max = 0;
        for(int i = 0; i < area.length; i++) {
            for(int j = 0; j < area[i].length; j++) {
                if(area[i][j] == 1) {
                    max = Math.max(max, dfs(area, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }

    public static void main(String[] args) {
        MaxAreaIsland mai = new MaxAreaIsland();
        int[][] input = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(mai.maxArea(input));
    }
}
