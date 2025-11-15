package utilityLab3.task2;

public class Citizen extends Person {
    private String nationality;
    private String passportNumber;

    public String getNationality() {
        return nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPerson(String name, int age, String nationality, String passportNumber) {
        super.setPerson(name, age);
        this.nationality = nationality;
        this.passportNumber = passportNumber;

    }

    @Override
    public String toString() {
        return super.toString() + "\nNationality: " + nationality + "\nPassportNumber: " + passportNumber;
    }
}
