package groupserialization.groupmanagement;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Студента " + student.getSurname() + " додано до групи " + groupName);
    }

    public void removeStudent(String surname) {
        boolean removed = students.removeIf(s -> s.getSurname().equalsIgnoreCase(surname));
        if (removed) {
            System.out.println("Студента з прізвищем " + surname + " видалено.");
        } else {
            System.out.println("Студента з прізвищем " + surname + " не знайдено.");
        }
    }

    public double getAverageGroupMark() {
        if (students.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : students) {
            sum += s.getAverageMark();
        }
        return sum / students.size();
    }

    public void printAllStudents() {
        System.out.println("\nСписок студентів групи " + groupName + ":");
        if (students.isEmpty()) {
            System.out.println("Немає студентів у групі");
            return;
        }
        for (Student s : students) {
            System.out.printf("%s %s, %d років, спеціальність: %s, середній бал: %.2f%n",
                    s.getName(), s.getSurname(), s.getAge(), s.getMajor(), s.getAverageMark());
        }
    }

    public int getStudentCount() {
        return students.size();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public String getGroupName() {
        return groupName;
    }
}
