package lab3.task2_lab3;

public class Main {
    public static void main(String[] args) {
        People people = new People();

        // Створення екземплярів
        Person person = new Person();
        person.setPerson("Іван Іванов", 40);

        Employee employee = new Employee();
        employee.setPerson("Ольга Петрівна", 35, "SoftServe", "HR-менеджер", 25000);

        Student student = new Student();
        student.setStudent("Андрій Коваль", 20, "КНУ", 3, "ST12345", "КН-31");

        Citizen citizen = new Citizen();
        citizen.setPerson("Марія Ткач", 50, "Україна", "AA987654");

        // Ще один об'єкт Person
        Person anotherPerson = new Person();
        anotherPerson.setPerson("Петро Сидоренко", 60);

        // Додавання до масиву
        people.getPeople()[0] = person;
        people.getPeople()[1] = employee;
        people.getPeople()[2] = student;
        people.getPeople()[3] = citizen;
        people.getPeople()[4] = anotherPerson;

        // Виведення
        people.showPeople();
    }
}
