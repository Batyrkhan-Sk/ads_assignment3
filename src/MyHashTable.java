public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] table;
    private int M = 11; // Initial size of the hash - table
    private int size; // Number of the elements in the hash table

    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int M) {
        this.M = M; // Setting the initial size of the hash table
        table = new HashNode[M];
    }

    // Hash function to calculate index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Inserting a key - value pair into the hash table
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    // Retrieving the value associated with a key
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // Removing a key - value pair from the hash - table
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> prev = null;
        HashNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    // Checking if the hash - table contains a value
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    // Retrieving the key associated with a specific value
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
    // Getting the number of elements in the hash table
    public int size() {
        return size;
    }
}
