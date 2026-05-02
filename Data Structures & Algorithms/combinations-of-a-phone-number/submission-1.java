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
        solve(digits,  new StringBuilder());   
        return ans; 
        
    }
    public void solve(String digits, StringBuilder sb) {
        if(digits.length() == 0) {
            ans.add(sb.toString());
        }
        if( digits.length() - 1 < 0) return;
        

        String str = map.get(Character.getNumericValue(digits.charAt(0)));
        for(int ch = 0; ch < str.length(); ch++) {
            sb.append(str.charAt(ch));
            solve(digits.substring(1), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
