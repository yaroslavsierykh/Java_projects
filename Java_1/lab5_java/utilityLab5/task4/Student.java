package utilityLab5.task4;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private double averageGrade;

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
        return "Студент: " + name + ", вік: " + age + ", середній бал: " + averageGrade;
    }
}

