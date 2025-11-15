package utilityLab3.task2;

public class Employee extends Person {
    private String company;
    private String position;
    private double salary;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPerson(String name, int age, String company, String position, double salary) {
        super.setPerson(name, age);
        this.company = company;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompany: " + company + "\nPosition: " + position + "\nSalary " + salary;
    }
}
