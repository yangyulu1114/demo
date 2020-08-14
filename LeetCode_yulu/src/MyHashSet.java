public class MyHashSet {
    private int[] set;
    public MyHashSet() {
        set = new int[1000001];
    }

    public void add(int key) {
        set[key] = 1;
    }

    public void remove(int key) {
        set[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] == 1;
    }
}
