package interview.set;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int current = image[sr][sc];
        dfs(image, visited, sr, sc, newColor, current);
        return image;
    }

    public void dfs(int[][] input, boolean[][] visited, int sr, int sc, int color, int current) {
        if(sr < 0 || sc < 0 || sr == input.length || sc == input[0].length || visited[sr][sc] == true || input[sr][sc] != current) return;
        visited[sr][sc] = true;
        input[sr][sc] = color;
        dfs(input, visited, sr + 1, sc , color, current);
        dfs(input, visited, sr - 1, sc , color, current);
        dfs(input, visited, sr, sc + 1 , color, current);
        dfs(input, visited, sr, sc - 1 , color, current);
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] input = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] output = ff.floodFill(input, 1, 1, 2);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
