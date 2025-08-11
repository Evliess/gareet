package leetcode;

public class BT_Leet79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, word, visited, i, j, 0)) return true; //注意参数
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int wIdx) {
        if (wIdx == word.length()) return true;
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || visited[i][j]
                || board[i][j] != word.charAt(wIdx))
            return false;

        visited[i][j] = true;
        boolean found = backtrack(board, word, visited, i - 1, j, wIdx + 1)
                || backtrack(board, word, visited, i + 1, j, wIdx + 1)
                || backtrack(board, word, visited, i, j - 1, wIdx + 1)
                || backtrack(board, word, visited, i, j + 1, wIdx + 1);
        visited[i][j] = false; //重置状态
        return found;
    }


}