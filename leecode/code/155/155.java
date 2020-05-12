class MinStack {
    Stack<Integer> s;
    Stack<Integer> q;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack();
        q = new Stack();
    }
    
    public void push(int x) {
        s.push(x);
        if (!q.isEmpty())
            q.push(Math.min(x, q.peek()));
        else
            q.push(x);
    }
    
    public void pop() {
        if (!s.isEmpty() && !q.isEmpty()) {
            s.pop();
            q.pop();
        }
    }
    
    public int top() {
        if (!s.isEmpty())
            return s.peek();
        return 0;
    }
    
    public int getMin() {
        if (!q.isEmpty())
            return q.peek();
        return 0;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */