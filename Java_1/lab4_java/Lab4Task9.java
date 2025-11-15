import utilityLab4.task9.RedBlackTree;

public class Lab4Task9 {
    public static void main(String[] args) {
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        System.out.println("Вставка елементів:");
        tree.put(10, "Ten");
        tree.put(5, "Five");
        tree.put(15, "Fifteen");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(1, "One");
        tree.put(20, "Twenty");

        tree.printTree();

        System.out.println("\nВидалення мінімального елемента:");
        tree.deleteMin();
        tree.printTree();

        System.out.println("\nВидалення елемента з ключем 15:");
        tree.delete(15);
        tree.printTree();

        System.out.println("\nВставка елементу з ключем 6:");
        tree.put(6, "Six");
        tree.printTree();
        tree.put(26, "TwentySix");
        tree.printTree();
    }

}
