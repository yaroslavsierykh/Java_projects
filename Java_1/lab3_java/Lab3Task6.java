import utilityLab3.task6.Triangle;
import utilityLab3.task6.Triangles;

public class Lab3Task6 {
    public static void main(String[] argv) {
        Triangles triangles = new Triangles();

        System.out.println("====================== До сортування ======================\n");
        for (Triangle triangle : triangles.getTriangles()) {
            System.out.println(triangle);
        }

        triangles.sortTriangles();

        System.out.print("\n\n");

        System.out.println("============== Після сортування(за зменшенням) ==============\n");
        for (Triangle triangle : triangles.getTriangles()) {
            System.out.println(triangle);
        }
    }
}
