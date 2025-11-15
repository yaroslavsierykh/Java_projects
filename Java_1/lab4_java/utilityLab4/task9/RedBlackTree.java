package utilityLab4.task9;

public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<K, V> root;

    public void put(K key, V value) {
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node<K, V> insert(Node<K, V> h, K key, V value) {
        if (h == null) {
            return new Node<>(key, value, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = insert(h.left, key, value);
        } else if (cmp > 0) {
            h.right = insert(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    private boolean isRed(Node<K, V> node) {
        return node != null && node.color == RED;
    }

    private Node<K, V> rotateLeft(Node<K, V> h) {
        Node<K, V> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<K, V> rotateRight(Node<K, V> h) {
        Node<K, V> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<K, V> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void deleteMin() {
        if (root == null) return;
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (root != null) root.color = BLACK;
    }

    private Node<K, V> deleteMin(Node<K, V> h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void delete(K key) {
        if (root == null) return;
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (root != null) root.color = BLACK;
    }

    private Node<K, V> delete(Node<K, V> h, K key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && h.right == null) {
                return null;
            }
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                Node<K, V> min = getMin(h.right);
                h.key = min.key;
                h.value = min.value;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    private Node<K, V> moveRedLeft(Node<K, V> h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node<K, V> moveRedRight(Node<K, V> h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node<K, V> balance(Node<K, V> h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    private Node<K, V> getMin(Node<K, V> h) {
        while (h.left != null) {
            h = h.left;
        }
        return h;
    }
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node<K, V> node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R── ");
                indent += "   ";
            } else {
                System.out.print("L── ");
                indent += "|  ";
            }

            String color = node.color == RED ? "RED" : "BLACK";
            System.out.println("(" + node.key + ", " + node.value + ") [" + color + "]");

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

}
