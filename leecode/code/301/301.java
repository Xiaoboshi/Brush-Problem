class Solution {


    public Set<String> set = new HashSet();


    public boolean istrue(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return true;
    }


    public void dfs(String s, int index, int left, int right) {
        if (index == s.length())
            if (left == 0 && right == 0) {
                if (istrue(s))
                    set.add(s);
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && left > 0)
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()), i, left - 1, right);
            else if (s.charAt(i) == ')' && right > 0)
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()), i, left, right - 1);
            else 
                dfs(s, i + 1, left, right);
        }
    }


    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else{
                if (s.charAt(i) == ')' && left > 0) {
                    left--;
                } else if (s.charAt(i) == ')'){
                    right++;
                }
            }
        }
        dfs(s, 0, left, right);
        return new ArrayList<String>(set);
    }
}