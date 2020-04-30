class Solution {

    List<String> result;
    String[] record = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void getres(String digits, int index, String first) {
        if (index == digits.length()) {
            result.add(first);
            return;
        }
         for (int i = 0; i < record[digits.charAt(index) - '0'].length(); i++) {
            getres(digits, index + 1, first + record[digits.charAt(index) - '0'].charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList();
        if (digits.length() == 0) {
            return result;
        }

        for (int i = 0; i < record[digits.charAt(0) - '0'].length(); i++) {
            getres(digits, 1, String.valueOf(record[digits.charAt(0) - '0'].charAt(i)));
        }
        return result;
    }
}