package utilityLab5.task4;

import java.io.Serializable;
import java.util.Arrays;

public class AcademicGroup implements Serializable {
    private String groupName;
    private Student[] students;

    public AcademicGroup(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Група: " + groupName + "\n" + Arrays.toString(students);
    }
}

