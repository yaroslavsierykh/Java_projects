package academic;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Represents an academic group consisting of multiple students.
 */
public class AcademicGroup implements Serializable {

    private final String groupName;
    private final Student[] students;

    /**
     * Constructs an academic group.
     *
     * @param groupName name of the group
     * @param students  array of students in this group
     */
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
        return "Group: " + groupName + "\n" + Arrays.toString(students);
    }
}
