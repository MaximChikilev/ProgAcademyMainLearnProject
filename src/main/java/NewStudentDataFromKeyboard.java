import java.util.Scanner;

public class NewStudentDataFromKeyboard implements StudentGenerator {
    @Override
    public Student getNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name : ");
        String name = scanner.nextLine();
        System.out.print("Enter student last name : ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student gender : ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        int id = StudentIdGenerator.getNewId();
        System.out.println("Student ID : "+id);
        System.out.print("Enter student group : ");
        String groupName = scanner.nextLine();
        return new Student(id,name,lastName,gender,groupName);
    }
}
