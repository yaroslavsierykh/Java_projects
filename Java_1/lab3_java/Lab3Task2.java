import utilityLab3.task2.*;

public class Lab3Task2 {
    public static void main(String[] args) {
        People peopleList = new People();
        Person[] people = peopleList.getPeople();

        // Створюємо різних людей
        Person p1 = new Person();
        p1.setPerson("Ivan Savenko", 40);

        Citizen c1 = new Citizen();
        c1.setPerson("Anna Shevchenko", 30, "Ukrainian", "AA123456");

        Student s1 = new Student();
        s1.setStudent("Dmytro Ivanenko", 20, "KhPI", 2, "KH12345", "CS423-A");

        Employee e1 = new Employee();
        e1.setPerson("Olena Bondarenko", 35, "SoftServe", "Developer", 30000.0);

        Student s2 = new Student();
        s2.setStudent("Sofia Kovalenko", 22, "KNU", 4, "KN45678", "CS423-B");

        // Додаємо до масиву
        people[0] = p1;
        people[1] = c1;
        people[2] = s1;
        people[3] = e1;
        people[4] = s2;

        // Виводимо всіх
        peopleList.showPeople();
    }
}
