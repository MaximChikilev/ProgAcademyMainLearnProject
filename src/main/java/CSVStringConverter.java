import java.util.Scanner;

public class CSVStringConverter implements StringConverter {
    @Override
    public String toStringRepresentation(Student student) {
        return student.getId() + "," + student.getName() + "," + student.getLastName() + "," + student.getGender().toString() + "," + student.getGroupName();
    }

    @Override
    public Student fromStringRepresentation(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        int id = StudentIdGenerator.getNewId();
        String name = scanner.next();
        String lastName = scanner.next();
        Gender gender = Gender.valueOf(scanner.next());
        String group = scanner.next();

        return new Student(id, name, lastName, gender, group);
    }
}
