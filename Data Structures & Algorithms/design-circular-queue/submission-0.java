class ListNode{
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val, ListNode next, ListNode prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularQueue {

    int space;
    ListNode left;
    ListNode right;

    public MyCircularQueue(int k) {
        this.space = k;
        left = new ListNode(0, null, null);
        right = new ListNode(0, null, left);
        left.next = right;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode cur = new ListNode(value, right, right.prev);
        right.prev.next = cur;
        right.prev = cur;
        space--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        left.next = left.next.next;
        left.next.prev = left;
        space++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return left.next.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return right.prev.val;
    }
    
    public boolean isEmpty() {
        return left.next == right;
    }
    
    public boolean isFull() {
        return space == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */