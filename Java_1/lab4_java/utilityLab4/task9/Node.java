package utilityLab4.task9;

public class Node<K extends Comparable<K>, V> {
    public K key;
    public V value;
    public Node<K,V> left;
    public Node<K,V> right;
    public boolean color;

    public Node(K key, V value, boolean color)
    {
        this.key = key;
        this.value = value;
        this.color = color;
    }
}
