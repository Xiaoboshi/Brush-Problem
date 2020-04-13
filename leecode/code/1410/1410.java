class Solution {

    public String entityParser(String text) {
        String result = "";
        String[] ref = {"quot", "apos", "amp", "gt", "lt", "frasl"};
        char[] ins = {'"', '\'', '&', '>', '<', '/'};
        int[] refnum = {4, 4, 3, 2, 2, 5};
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '&') {
                result = result + text.charAt(i);
            } else {
                int j = 0;
                for (; j < 6; j++) {
                    if (i + 1 + refnum[j] <= text.length()) {
                        String temp = text.substring(i + 1, i + 1 + refnum[j]);
                        if (ref[j].equals(temp)) {
                            result = result + ins[j];
                            i += refnum[j] + 1;
                            break;
                        }
                    }
                }
                if (j >= 6) {
                    result = result + '&';
                }
            }
            
        }
        return result;
    }
}
