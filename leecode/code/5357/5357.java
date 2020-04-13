class CustomStack {
    
    int size = 0;
    int MaxSize = 0;
    int [] a = new int[1000];

    public CustomStack(int maxSize) {
        MaxSize = maxSize;
    }
    
    public void push(int x) {
        if (size < MaxSize) {
            a[size] = x;
            size++;
        }
        
    }
    
    public int pop() {
        if (size == 0) {
            return -1;
        } else {
            size--;
            int temp = a[size];
            a[size] = 0;
            return temp;
        }

    }
    
    public void increment(int k, int val) {
        if (k < size) {
            for (int i = 0; i < k; i++) {
                a[i] += val;
            }
        } else {
            for (int i = 0; i < size; i++) {
                a[i] += val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
