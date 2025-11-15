package groupserialization.groupmanagement;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String major;
    private double averageMark;

    public Student(String name, String surname, LocalDate birthdate, String major, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.major = major;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return String.format(
                "Студент: %s %s, Вік: %d років, Спеціальність: %s, Середній бал: %.2f",
                name, surname, getAge(), major, averageMark
        );
    }
}
