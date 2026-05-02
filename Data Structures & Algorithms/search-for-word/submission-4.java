class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            solve(board, word, i, j, 0, new boolean[board.length][board[0].length]);
            if(flag) return true;
        }
    }        
    return flag;
    }
    public void solve(char[][] board, String word, int i, int j, int idx, boolean [][] visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(visited[i][j]) return;
        
        if (board[i][j] != word.charAt(idx)) return;

        if(idx == word.length() - 1) {
            flag = true;
            return;
        }
        
        if(board[i][j] == word.charAt(idx)) {
            visited[i][j] = true;
            solve(board, word, i + 1, j, idx + 1, visited);
            solve(board, word, i - 1, j, idx + 1, visited);
            solve(board, word, i, j + 1, idx + 1, visited);
            solve(board, word, i, j - 1, idx + 1, visited);
            visited[i][j] = false;
        }
    return;
    }

}
