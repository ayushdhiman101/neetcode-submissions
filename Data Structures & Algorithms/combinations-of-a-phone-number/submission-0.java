class Solution {
    HashMap<Integer, String> map = new HashMap<Integer, String>(){{
       put(2, "abc");
       put(3, "def");
       put(4, "ghi");
       put(5, "jkl");
       put(6, "mno");
       put(7, "pqrs");
       put(8, "tuv");
       put(9, "wxyz");
    }};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        solve(digits, 0, new StringBuilder());   
        return ans; 
        
    }
    public void solve(String digits, int i, StringBuilder sb) {
        if(i == digits.length()) {
            ans.add(sb.toString());
        }
        if(i > digits.length() - 1) return;
        

        String str = map.get(Character.getNumericValue(digits.charAt(i)));
        for(int ch = 0; ch < str.length(); ch++) {
            sb.append(str.charAt(ch));
            solve(digits.substring(1), i , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
