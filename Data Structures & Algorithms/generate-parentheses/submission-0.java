class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return ans;
        generateParenthesis2(n, new StringBuilder() , 0, 0, 0);
        return ans;
    }
    public void generateParenthesis2(int n, StringBuilder str, int idx, int open, int close) {
        if(str.length() == n * 2 ) {
            ans.add(str.toString());
            return;
        }
        if(open < n) {
            str.append('(');
            generateParenthesis2(n, str, idx + 1, open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }
        if(open > close) {
            str.append(')');
            generateParenthesis2(n, str, idx + 1, open, close + 1);
            str.deleteCharAt(str.length() - 1);

        }

    }

}
