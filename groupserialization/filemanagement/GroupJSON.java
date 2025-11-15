package groupserialization.filemanagement;

import lab3.task4.Group;
import lab3.task4.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GroupJSON {
    public static JSONObject groupToJSON(Group group) {
        JSONObject groupJson = new JSONObject();
        groupJson.put("groupName", group.getGroupName());
        groupJson.put("avarageMark", group.getAverageGroupMark());

        JSONArray studentsArray = new JSONArray();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        for (Student s : group.getStudents()) {
            JSONObject studentJson = new JSONObject();
            studentJson.put("name", s.getName());
            studentJson.put("surname", s.getSurname());
            studentJson.put("birthdate", s.getBirthdate().format(formatter)); // LocalDate → String
            studentJson.put("major", s.getMajor());
            studentJson.put("averageMark", s.getAverageMark());
            studentsArray.put(studentJson);
        }

        groupJson.put("students", studentsArray);
        return groupJson;
    }

    public static void saveGroupToJSONFile(Group group, String filename) {
        JSONObject groupJson = groupToJSON(group);

        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(groupJson.toString(4));
            System.out.println("Групу збережено у JSON файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static Group loadGroupFromJSONFile(String filename) {
        try {
            String content = Files.readString(Path.of(filename));
            JSONObject groupJson = new JSONObject(content);

            Group group = new Group(groupJson.getString("groupName"));
            JSONArray studentsArray  = groupJson.getJSONArray("students");
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

            for (int i = 0; i < studentsArray.length(); i++) {
                JSONObject s = studentsArray.getJSONObject(i);
                Student student = new Student(
                        s.getString("name"),
                        s.getString("surname"),
                        LocalDate.parse(s.getString("birthdate"), formatter),
                        s.getString("major"),
                        s.getDouble("averageMark")
                );
                group.addStudent(student);
            }
            return group;
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Group group = new Group("КН-423б");
        group.addStudent(new Student("Андрій", "Петренко", LocalDate.of(2003,5,12), "Інформатика", 89.5));
        group.addStudent(new Student("Марія", "Іваненко", LocalDate.of(2004,3,25), "Кібербезпека", 93.2));

        saveGroupToJSONFile(group, "group.json");

        Group loadedGroup = loadGroupFromJSONFile("group.json");
        System.out.println("\nГрупа, завантажена з JSON");
        if (loadedGroup != null) loadedGroup.printAllStudents();
    }

}
