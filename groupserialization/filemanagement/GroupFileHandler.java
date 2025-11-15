package groupserialization.filemanagement;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import groupserialization.groupmanagement.Group;
import groupserialization.groupmanagement.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class GroupFileHandler {

    public static void saveGroupToXML(Group group, String filename) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypesByWildcard(new String[]{"lab3.task4.**"});
        xstream.alias("student", Student.class);
        xstream.alias("group", Group.class);

        try (FileWriter fileWriter = new FileWriter(filename)) {
            xstream.toXML(group, fileWriter);
            System.out.println("Записано у файл: " + Path.of(filename).toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static Group loadGroupFromXML(String filename) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypesByWildcard(new String[]{"lab3.task4.**"});
        xstream.alias("student", Student.class);
        xstream.alias("group", Group.class);

        try (FileReader fileReader = new FileReader(filename)) {
            return (Group) xstream.fromXML(fileReader);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
            return null;
        }
    }

    public static void saveGroupToJSON(Group group, String filename) {
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.allowTypesByWildcard(new String[]{"lab3.task4.**"});
        xstream.alias("student", Student.class);
        xstream.alias("group", Group.class);

        try (FileWriter fileWriter = new FileWriter(filename)) {
            xstream.toXML(group, fileWriter);
            System.out.println("Записано у файл: " + Path.of(filename).toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static Group loadGroupFromJSON(String filename) {
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.allowTypesByWildcard(new String[]{"lab3.task4.**"});
        xstream.alias("student", Student.class);
        xstream.alias("group", Group.class);

        try (FileReader fileReader = new FileReader(filename)) {
            return (Group) xstream.fromXML(fileReader);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
            return null;
        }
    }
}
