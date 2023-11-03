package interview.set;

/**
 * Link: https://leetcode.com/problems/number-of-islands/
 * Level: Medium
 */
public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int counter = 0;
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    counter++;
                    bfs(grid, i, j);
                }
            }
        }
        return counter;
    }

    public void bfs(char[][] grid, int i , int j) {
        if(i < 0 || i >= grid.length || j >= grid[i].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i, j - 1);
    }
    public static void main(String[] args) {
        NumberOfIsland noi = new NumberOfIsland();
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '1', '0', '0'},
        };

        int result = noi.numIslands(input);
        System.out.println("Total islands >> " + result);
    }
}
