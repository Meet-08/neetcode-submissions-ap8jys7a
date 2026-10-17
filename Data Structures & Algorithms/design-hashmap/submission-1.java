class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] map;

    public MyHashMap() {
        map = new Node[10000];

        for (int i = 0; i < map.length; i++) {
            map[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = key % map.length;

        Node curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                System.out.println("Updating Value : " + key);
                curr.next.value = value;
                return;
            }

            curr = curr.next;
        }
        System.out.println("Adding Key : " + key);
        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = key % map.length;

        Node curr = map[hash];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;

            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % map.length;

        Node curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */