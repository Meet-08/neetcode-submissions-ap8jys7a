/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(0);
        Node cur = head;
        Node tail = dummy;


        while(cur != null){
            tail.next = new Node(cur.val);
            tail = tail.next;
            map.put(cur, tail);
            cur = cur.next;
        }

        cur = head;
        tail = dummy.next;

        while(cur != null){
            tail.random = map.getOrDefault(cur.random, null);
            tail = tail.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
