**Assignment 3**

**Hash Table**

The 'MyHashTable' class uses a hash table data structure. It includes methods for: inserting, retrieving, removing key - value pairs, checking if a value exists.

Usage:
```
        MyHashTable<Integer, String> table = new MyHashTable<>();

        table.put(1, "Name1");
        table.put(2, "Name2");
        table.put(3, "Name3");

        System.out.println("Value for key 1: " + table.get(1));
        System.out.println("Value for key 2: " + table.get(2));
        System.out.println("Value for key 3: " + table.get(3));

        System.out.println("Size of the hash table: " + table.size());

        String removedValue = table.remove(2);
        System.out.println("Removed value for key 2: " + removedValue);
        System.out.println("Size after removal: " + table.size());

        boolean containsValue = table.contains("Name1");
        System.out.println("Hash table contains Name1: " + containsValue);

        Integer integerKey = table.getKey("Name3");
        System.out.println("Key for Name3: " + integerKey);
```

**Binary Search Tree (BST)** 

The 'BST' class is a binary search tree data structure. It includes operations such as insertion, retrieval, deletion of key - value pairs, iteration through the tree in-order.

Usage:
```
BST<Integer, String> tree = new BST<>();
        tree.put(5, "Dana");
        tree.put(3, "Zhanerke");
        tree.put(1, "Aman");
        tree.put(4, "Azat");
        tree.put(2, "Dauren");

        String valueKey5 = tree.get(5);
        System.out.println(valueKey5);
        tree.delete(5);

        for (var elem : tree) {
            System.out.println("Key is " + elem.getKey() + " and value is " + elem.getValue());
        }
```
