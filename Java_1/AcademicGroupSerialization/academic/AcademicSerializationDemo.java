package academic;

/**
 * Demonstration class for serialization and deserialization
 * of {@link AcademicGroup} objects.
 */
public class AcademicSerializationDemo {
    public static void main(String[] args) {

        Student[] students = {
                new Student("Alexander", 20, 4.5),
                new Student("Maria", 19, 4.8),
                new Student("John", 21, 3.9)
        };

        AcademicGroup group = new AcademicGroup("CS-23", students);

        // Serialization
        SerializationUtil.saveToFile(group, "group.dat");

        // Deserialization
        AcademicGroup loadedGroup = (AcademicGroup) SerializationUtil.loadFromFile("group.dat");

        System.out.println("\nGroup restored from file:");
        System.out.println(loadedGroup);
    }
}
