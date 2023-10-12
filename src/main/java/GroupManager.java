public class GroupManager {
    public Group createAndFillGroup() {
        Group javaGroup = new Group("Java group");
        Student firstStudent = new Student(11, "Bruce", "Eckel", Gender.MALE, javaGroup.getGroupName());
        Student secondStudent = new Student(10, "Joshua", "Bloch", Gender.MALE, javaGroup.getGroupName());
        Student thirdStudent = new Student(9, "Herbert", "Schildt", Gender.MALE, javaGroup.getGroupName());
        Student fourthStudent = new Student(8, "Craig", "Walls", Gender.MALE, javaGroup.getGroupName());
        Student fifthStudent = new Student(7, "Eric", "Freeman", Gender.MALE, javaGroup.getGroupName());
        Student sixthStudent = new Student(6, "Elisabeth", "Freeman", Gender.FEMALE, javaGroup.getGroupName());
        Student seventhStudent = new Student(5, "Cay", "S. Horstmann", Gender.MALE, javaGroup.getGroupName());
        Student eighthStudent = new Student(4, "Name11", "LastName11", Gender.FEMALE, javaGroup.getGroupName());
        Student ninthStudent = new Student(3, "Name10", "LastName10", Gender.MALE, javaGroup.getGroupName());
        Student tenthStudent = new Student(2, "Name9", "LastName9", Gender.FEMALE, javaGroup.getGroupName());
        Student eleventhStudent = new Student(1, "Name8", "LastName8", Gender.MALE, javaGroup.getGroupName());
        try {
            javaGroup.addStudent(firstStudent);
            javaGroup.addStudent(secondStudent);
            javaGroup.addStudent(thirdStudent);
            javaGroup.addStudent(fourthStudent);
            javaGroup.addStudent(fifthStudent);
            javaGroup.addStudent(sixthStudent);
            javaGroup.addStudent(seventhStudent);
            javaGroup.addStudent(eighthStudent);
            javaGroup.addStudent(ninthStudent);
            javaGroup.addStudent(tenthStudent);
            //javaGroup.addStudent(eleventhStudent);

        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }
        return javaGroup;
    }
}
