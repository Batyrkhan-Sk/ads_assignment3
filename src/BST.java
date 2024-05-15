import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root; // Root of the bst
    private int size; // Number of elements in the tree

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Inserting a key - value pair into the BST
    public void put(K key, V value) {
        root = put(root, key, value);
    }
    // Recursively inserting a key - value pair into the BST
    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        return node;
    }

    // Retrieving the value associated with a key
    public V get(K key) {
        Node<K, V> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.value;
        }
        return null;
    }

    // Deleting a key - value pair from the BST
    public void delete(K key) {
        root = delete(root, key);
    }

    // Recursively deleting a key - value pair from the BST
    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node<K, V> temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
            size--;
        }
        return node;
    }

    // Finding the minimum node in a subtree
    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    // Deleting the minimum node in a subtree
    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    // Getting the number of elements in the BST
    public int size() {
        return size;
    }

    // Class with an entry (key-value pair) in the BST
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // Iterator for in-order traversal of the BST
    private class InOrderIterator implements Iterator<Entry<K, V>> {
        private Stack<Node<K, V>> stack;

        public InOrderIterator(Node<K, V> root) {
            stack = new Stack<>();
            pushLeft(root);
        }
        // Pushing nodes of a subtree onto the stack starting from the leftmost node
        private void pushLeft(Node<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        // Checking if there are more elements to iterate over
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Retrieving the next element in the in-order traversal
        public Entry<K, V> next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node<K, V> node = stack.pop();
            Entry<K, V> entry = new Entry<>(node.key, node.value);
            pushLeft(node.right);
            return entry;
        }
    }

    // Obtaining an iterator for in-order traversal of the BST
    public Iterator<Entry<K, V>> iterator() {
        return new InOrderIterator(root);
    }
}
