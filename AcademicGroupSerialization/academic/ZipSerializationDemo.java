package academic;

/**
 * Demonstrates writing and reading an AcademicGroup object inside a ZIP archive.
 */
public class ZipSerializationDemo {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Yaroslav", 20, 90.5),
                new Student("Anna", 19, 87.0),
                new Student("Oleh", 21, 78.2)
        };

        AcademicGroup group = new AcademicGroup("IT-202", students);

        String zipFile = "group.zip";
        String entryName = "group.dat";

        ZipSerializationUtil.writeObjectToZip(zipFile, entryName, group);

        AcademicGroup readGroup =
                (AcademicGroup) ZipSerializationUtil.readObjectFromZip(zipFile, entryName);

        if (readGroup != null) {
            System.out.println("Deserialized group:\n" + readGroup);
        }
    }
}
