import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private final Student[] students;

    public Group(String groupName) {
        this.groupName = groupName;
        students = new Student[10];
    }

    public Group() {
        students = new Student[10];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        Arrays.sort(students, Comparator.nullsFirst(new StudentLastNameComparator()));
        StringBuilder outLine = new StringBuilder();
        outLine.append("groupName : " + groupName + "\n");
        for (int counter = 0; counter <= students.length - 1; counter++) {
            if (students[counter] != null) {
                outLine.append(students[counter].toString() + "\n");
            }else outLine.append("Vacant place\n");
        }
        return outLine.toString();
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int count = 0; count <= students.length - 1; count++) {
            if (students[count] == null) {
                students[count] = student;
                return;
            }
        }
        throw new GroupOverflowException("Group is full");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int count = 0; count <= students.length - 1; count++) {
            if (students[count] != null) {
                if (students[count].getLastName() == lastName) {
                    return students[count];
                }
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public boolean removeStudentByID(int id) {
        for (int count = 0; count <= students.length - 1; count++) {
            if (students[count] != null) {
                if (students[count].getId() == id) {
                    students[count] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
