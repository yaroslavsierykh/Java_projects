import utilityLab4.task5.UsersData;

public class Lab4Task5 {
    public static void main(String[] args) {
        UsersData usersData = new UsersData();

        usersData.addUser("andriy", "pass1234");
        usersData.addUser("olena", "qwerty");
        usersData.addUser("ivan", "12345678");
        usersData.addUser("maria", "abc");

        usersData.printUsersWithLongPasswords();
    }
}
