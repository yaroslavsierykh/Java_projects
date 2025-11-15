import utilityLab5.task4.AcademicGroup;
import utilityLab5.task4.SerializationUtil;
import utilityLab5.task4.Student;

public class Lab5Task4 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Олександр", 20, 4.5),
                new Student("Марія", 19, 4.8),
                new Student("Іван", 21, 3.9)
        };

        AcademicGroup group = new AcademicGroup("ІПЗ-23", students);

        // Серіалізація
        SerializationUtil.saveToFile(group, "group.dat");

        // Десеріалізація
        AcademicGroup loadedGroup = (AcademicGroup) SerializationUtil.loadFromFile("group.dat");

        System.out.println("\nВідновлена з файлу група:");
        System.out.println(loadedGroup);
    }
}
