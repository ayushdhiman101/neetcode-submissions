class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String [][] board = new String[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        solve(board, n, 0);
        return ans;
    }
    public void solve(String [][] board, int n, int i) {
        if(i == n) {
            List<String> temp = new ArrayList<>();

            for (int k = 0; k < n; k++) {
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    sb.append(board[k][l]);
                }
                temp.add(sb.toString());
            }

            ans.add(temp);
            return;
        }

        for(int j = 0; j < n; j++) {
            if(isValid(board, n, i, j)) {
                board[i][j] = "Q";
                solve(board, n, i + 1);
                board[i][j] = ".";
            }

        }
    return;
    }
    public boolean isValid (String [][] board, int n, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(board[i][col].equals("Q")) return false;
        }
        for(int j = 0; j < col; j++) {
            if(board[row][j].equals("Q")) return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j-- ) {
            if(board[i][j].equals("Q")) return false;
        }
        for(int i = row, j = col; i >= 0 && j < n; i--, j++ ) {
            if(board[i][j].equals("Q")) return false;
        }
        return true;

    }
}