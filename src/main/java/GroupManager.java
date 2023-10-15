import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GroupManager {
    private String filePath = "./src/main/resources/Students.csv";

    public Group createAndFillGroup() {
        StringConverter stringConverter = new CSVStringConverter();
        Group javaGroup = new Group("Java group");

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                StudentGenerator stringStudentGenerator = new NewStudentDataFromString(scanner.nextLine(), stringConverter);
                javaGroup.addStudent(stringStudentGenerator.getNewStudent());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }
        return javaGroup;
    }
}
