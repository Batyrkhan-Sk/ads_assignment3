public class Main {
    public static void main(String[] args) {
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
    }
}
