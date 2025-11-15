package academic;

import java.io.Serializable;

/**
 * Represents a student with name, age, and average grade.
 */
public class Student implements Serializable {

    private final String name;
    private final int age;
    private final double averageGrade;

    /**
     * Constructs a student instance.
     *
     * @param name         student name
     * @param age          student age
     * @param averageGrade student's average grade
     */
    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student: " + name +
                ", age: " + age +
                ", average grade: " + averageGrade;
    }
}
