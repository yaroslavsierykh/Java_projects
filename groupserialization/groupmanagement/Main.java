package groupserialization.groupmanagement;

import groupserialization.filemanagement.GroupFileHandler;
import groupserialization.filemanagement.GroupToFile;
import groupserialization.filemanagement.StudentsFile;
import groupserialization.filemanagement.GroupJSON;

import java.nio.file.Path;
import java.time.LocalDate;

/**
 * Demonstrates working with a student group and saving/loading data in different formats.
 * <p>
 * This class shows how to:
 * - Add and remove students in a group
 * - Save and read group data to/from TXT, XML, and JSON files
 */
public class Main {

    /**
     * Main method demonstrating:
     * - Adding and removing students
     * - Saving and loading group data in TXT, XML, and JSON formats
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // ================= Create Group =================
        lab3.task4.Group group = new Group("CS-423B");

        group.addStudent(new Student("Andrew", "Petrenko", LocalDate.of(2003, 5, 12), "Computer Science", 89.5));
        group.addStudent(new Student("Maria", "Ivanenko", LocalDate.of(2004, 3, 25), "Cybersecurity", 93.2));
        group.addStudent(new Student("Oleg", "Koval", LocalDate.of(2002, 9, 7), "Software Engineering", 76.8));

        // Print all students
        group.printAllStudents();
        System.out.printf("%nAverage group mark for %s: %.2f%n%n", group.getGroupName(), group.getAverageGroupMark());

        // Remove a student
        group.removeStudent("Koval");
        group.printAllStudents();

        // ================= TXT =================
        Path txtPath = Path.of("students.txt");
        StudentsFile.writeToFile(group, txtPath);

        System.out.println("\n--- TXT file content ---");
        StudentsFile.readFromFile(txtPath);

        // ================= XML =================
        String xmlFile = "group.xml";
        GroupFileHandler.saveGroupToXML(group, xmlFile);

        Group loadedXMLGroup = GroupFileHandler.loadGroupFromXML(xmlFile);
        System.out.println("\n--- Group loaded from XML ---");
        if (loadedXMLGroup != null) loadedXMLGroup.printAllStudents();

        GroupToFile.readAndAddNewStudent(xmlFile, "Yaroslav", "Serikh", "2006-06-05", "Development and Startup", "97.4");
        System.out.println("\n--- New XML file content after adding a student ---");
        GroupToFile.readFromFile("group_new.xml");

        // ================= JSON =================
        String jsonFile = "group.json";
        GroupJSON.saveGroupToJSONFile(group, jsonFile);

        Group loadedJSONGroup = GroupJSON.loadGroupFromJSONFile(jsonFile);
        System.out.println("\n--- Group loaded from JSON ---");
        if (loadedJSONGroup != null) loadedJSONGroup.printAllStudents();
    }
}
