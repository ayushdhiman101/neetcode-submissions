class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            solve(board, word, i, j, 0);
            if(flag) return true;
        }
    }        
    return flag;
    }
    public void solve(char[][] board, String word, int i, int j, int idx) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(board[i][j] == '#') return;
        
        if (board[i][j] != word.charAt(idx)) return;

        if(idx == word.length() - 1) {
            flag = true;
            return;
        }
        
        if(board[i][j] == word.charAt(idx)) {
            char original = board[i][j];
            board[i][j] = '#';
            solve(board, word, i + 1, j, idx + 1);
            solve(board, word, i - 1, j, idx + 1);
            solve(board, word, i, j + 1, idx + 1);
            solve(board, word, i, j - 1, idx + 1);
            board[i][j] = original;
        }
    return;
    }

}
