public class Pair<V, E> {

    private final V key;
    private final E value;

    public Pair(V key, E value) {
        this.key = key;
        this.value = value;
    }

    public V getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}
