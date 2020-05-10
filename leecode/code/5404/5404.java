class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> a = new ArrayList();
        Stack<Integer> s = new Stack();
        int count = 0;
        int i = 0;
        for(i = 1; i <= n; i++) {
            a.add("Push");
            if (i < target[count]) {
                a.add("Pop");
            } else if (i == target[count]) {
                count++;
                if (count == target.length) {
                    break;
                }
            }
        }
        return a;
    }
}