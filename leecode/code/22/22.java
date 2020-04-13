class Solution {

    ArrayList<String> strs = null;

    public void gene(int n, int left, int right, String str) {
        if (n == right) {
            strs.add(str);
            return;
        }
        if (left < n) {
            gene(n, left + 1, right, str + '(');
        }
        if (right < left) {
            gene(n, left, right + 1, str + ')');
        }
    }


    public List<String> generateParenthesis(int n) {
        strs = new ArrayList();
        gene(n, 0, 0, "");
        return strs;
    }
}
