import utilityLab5.task4.AcademicGroup;
import utilityLab5.task4.Student;
import utilityLab5.task5.ZipUtil;

public class Lab5Task5 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ярослав", 20, 90.5),
                new Student("Анна", 19, 87.0),
                new Student("Олег", 21, 78.2)
        };

        AcademicGroup group = new AcademicGroup("ІТ-202", students);

        String zipFile = "group.zip";
        String entryName = "group.dat";

        // Запис до ZIP
        ZipUtil.writeObjectToZip(zipFile, entryName, group);

        // Читання з ZIP
        AcademicGroup readGroup = (AcademicGroup) ZipUtil.readObjectFromZip(zipFile, entryName);
        if (readGroup != null) {
            System.out.println("Десеріалізована група:\n" + readGroup);
        }
    }
}
