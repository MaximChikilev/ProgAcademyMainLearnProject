import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

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
        sortStudentsByLastName();
        StringBuilder outLine = new StringBuilder();
        outLine.append("groupName : " + groupName + "\n");
        for (int counter = 0; counter <= students.length - 1; counter++) {
            if (students[counter] != null) {
                outLine.append(students[counter].toString() + "\n");
            } else outLine.append("Vacant place\n");
        }
        return outLine.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getGroupName(), group.getGroupName()) && Arrays.equals(getStudents(), group.getStudents());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getGroupName());
        result = 31 * result + Arrays.hashCode(getStudents());
        return result;
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
                if (students[count].getLastName().equals(lastName)) {
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

    public void sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst((student1, student2) -> student1.getLastName().compareTo(student2.getLastName())));
    }

    public int checkStudentsDuplicates() {
        long uniqueStudentCount = Stream.of(students).distinct().count();
        int vacantPlaceQuantity = vacantPlaceCounter();
        return (int) (students.length - ((vacantPlaceQuantity == 0) ? 0 : vacantPlaceQuantity - 1) - uniqueStudentCount);
    }

    private int vacantPlaceCounter() {
        int counter = 0;
        for (Student element : students) {
            if (element == null) counter++;
        }
        return counter;
    }
}
