class ListNode {
    int key = 0;
    int val = 0;
    ListNode pre = null;
    ListNode next = null;


    public ListNode(int a, int b) {
        key = a;
        val = b;
    }
}



class LRUCache {
    int cap = 0;
    Map<Integer, ListNode> map;
    
    ListNode head, tail;


    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap();
        head = new ListNode(-3, -3);
        tail = new ListNode(-2, -2);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // 调换位置
            int res = map.get(key).val;
            ListNode k = map.get(key);
            ListNode kpre = k.pre;
            ListNode knext = k.next;
            knext.pre = kpre;
            kpre.next = knext;
            k.next = null;
            k.pre = null;
            ListNode npre = tail.pre;
            npre.next = k;
            k.pre = npre;
            k.next = tail;
            tail.pre = k;
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.size() < cap) {
            if (map.containsKey(key)) {
                ListNode k = map.get(key);
                k.val = value;
                ListNode kpre = k.pre;
                ListNode knext = k.next;
                knext.pre = kpre;
                kpre.next = knext;
                k.next = null;
                k.pre = null;
                ListNode npre = tail.pre;
                npre.next = k;
                k.pre = npre;
                k.next = tail;
                tail.pre = k;
                map.put(key, k);
            } else {
                // 直接加入
                ListNode k = new ListNode(key, value);
                ListNode m = tail.pre;
                m.next = k;
                k.pre = m;
                k.next = tail;
                tail.pre = k;
                map.put(key, k);
            }
        } else {
            if (map.containsKey(key)) {
                ListNode k = map.get(key);
                k.val = value;
                ListNode kpre = k.pre;
                ListNode knext = k.next;
                knext.pre = kpre;
                kpre.next = knext;
                k.next = null;
                k.pre = null;
                ListNode npre = tail.pre;
                npre.next = k;
                k.pre = npre;
                k.next = tail;
                tail.pre = k;
                map.put(key, k);
            } else {
                // 删除头结点
                ListNode n = head.next;
                ListNode l = n.next;
                head.next = l;
                l.pre = head;
                n.next = null;
                n.pre = null;
                map.remove(n.key);
                // 插入尾节点
                ListNode k = new ListNode(key, value);
                ListNode m = tail.pre;
                m.next = k;
                k.pre = m;
                k.next = tail;
                tail.pre = k;
                map.put(key, k);
            }
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */