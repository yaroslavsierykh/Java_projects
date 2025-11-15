package lab5.task4_lab5;

import java.io.Serializable;
import java.util.Arrays;

public class AcademicGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    private Student[] students;

    public AcademicGroup(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "AcademicGroup{" +
                "Студенти=" + Arrays.toString(students) +
                '}';
    }
}

