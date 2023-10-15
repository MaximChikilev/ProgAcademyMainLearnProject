public class Main {
    public static void main(String[] args) {
        GroupManager groupManager = new GroupManager();
        Group javaGroup = groupManager.createAndFillGroup();
        System.out.println(javaGroup.toString());
        // Fill array from CSV file
        try {
            System.out.println(javaGroup.searchStudentByLastName("Bloch").toString());
            //System.out.println(javaGroup.searchStudentByLastName("Petrenko").toString());
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
        //----------------------------------
        // Create new student from keyboard
        StudentGenerator keyboardStudentGenerator = new NewStudentDataFromKeyboard();
        Student student = keyboardStudentGenerator.getNewStudent();
        System.out.println("New student was created ");
        System.out.println(student);
        //----------------------------------
        // Transfer student to CSV
        StringConverter stringConverter = new CSVStringConverter();
        System.out.println("CSV representation is : " + stringConverter.toStringRepresentation(student));
        //__________________________________
        if (javaGroup.removeStudentByID(3)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        if (javaGroup.removeStudentByID(22)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        System.out.println(javaGroup.toString());
    }

}
