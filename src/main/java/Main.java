public class Main {
    public static void main(String[] args) {
        GroupManager groupManager = new GroupManager();
        Group javaGroup = groupManager.createAndFillGroup();
        System.out.println(javaGroup.toString());
        try {
            System.out.println(javaGroup.searchStudentByLastName("Eckel").toString());
            //System.out.println(javaGroup.searchStudentByLastName("Petrenko").toString());

        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (javaGroup.removeStudentByID(3)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        if (javaGroup.removeStudentByID(22)) {
            System.out.println("Student was deleted");
        } else System.out.println("Student is not found");
        System.out.println(javaGroup.toString());
    }

}
