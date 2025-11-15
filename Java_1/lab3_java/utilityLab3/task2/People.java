package utilityLab3.task2;

public class People {
    private Person[] people = new Person[5];

    public Person[] getPeople() {
        return people;
    }

    public void showPeople() {
        for (Person person : people) {
            if (person != null) {
                System.out.println(person);
                System.out.println("---------------------");
            }
        }
    }
}
