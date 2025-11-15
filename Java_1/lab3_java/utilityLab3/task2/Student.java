package utilityLab3.task2;

public class Student extends Person {
    private String university;
    private int course;
    private String studentId;
    private String group;

    public String getStudentId() {
        return studentId;
    }

    public int getCourse() {
        return course;
    }

    public String getUniversity() {
        return university;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudent(String name, int age, String university, int course, String studentId, String group)  {
        super.setPerson(name, age);
        this.university = university;
        this.course = course;
        this.studentId = studentId;
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversity: " + university + "\nCourse: " + course + "\nStudentId: " + studentId + "\nGroup:" + group;
    }
}
