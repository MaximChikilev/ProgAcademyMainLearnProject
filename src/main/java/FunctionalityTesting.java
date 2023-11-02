import java.io.File;

public class FunctionalityTesting {
    private static GroupFileStorage groupFileStorage = new GroupFileStorage();

    public static Group loadFromCsvFileTest() {
        Group javaGroup;
        try {
            javaGroup = groupFileStorage.loadGroupFromCSV(new File("./src/main/resources/Java group.csv"));
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }
        System.out.println(javaGroup.toString());
        return javaGroup;
    }

    public static void saveToCsvFileTest(Group javaGroup) {
        javaGroup.setGroupName("Perfect group");
        groupFileStorage.saveGroupToCSV(javaGroup);
    }

    public static void searchStudentTest(Group javaGroup) {
        try {
            System.out.println("Student was founded");
            System.out.println(javaGroup.searchStudentByLastName("Bloch").toString());
            //System.out.println(javaGroup.searchStudentByLastName("Petrenko").toString());
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inputNewStudentFromKeyboardAndTransferToCsvTest() {
        StudentGenerator keyboardStudentGenerator = new NewStudentDataFromKeyboard();
        Student student = keyboardStudentGenerator.getNewStudent();
        System.out.println("New student was created ");
        System.out.println(student);
        StringConverter stringConverter = new CSVStringConverter();
        System.out.println("CSV representation is : " + stringConverter.toStringRepresentation(student));
    }

    public static void deleteStudentTest(Group javaGroup) {
        if (javaGroup.removeStudentByID(3)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        if (javaGroup.removeStudentByID(22)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        System.out.println(javaGroup.toString());
    }

    public static void findFileTesting(Group javaGroup) {
        File folder = new File("./src/main/resources/");
        File file = groupFileStorage.findFileByGroupName(javaGroup.getGroupName(), folder);
        if (folder.getName().equals(file.getName())) {
            System.out.println("File for group : " + javaGroup.getGroupName() + " wasn't found");
        } else System.out.println("File : " + file.getName() + " was found");
        System.out.println();
    }

    public static void findStudentDuplicateTesting(Group javaGroup) {
        System.out.println("There are : " + javaGroup.checkStudentsDuplicates() + " duplicates");
    }
}


