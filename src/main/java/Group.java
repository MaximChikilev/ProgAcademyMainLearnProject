import java.util.*;
import java.util.stream.Stream;

public class Group {
    private String groupName;
    private final List<Student> students;
    private final int maxStudentInGroup = 10;

    public Group(String groupName) {
        this.groupName = groupName;
        students = new ArrayList<Student>();
    }

    public Group() {
        students = new ArrayList<Student>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        sortStudentsByLastName();
        StringBuilder outLine = new StringBuilder();
        outLine.append("groupName : " + groupName + "\n");
        for (Student element:students){
            outLine.append(element.toString()+"\n");
        }
        for (int counter = students.size(); counter < maxStudentInGroup; counter++) {
            outLine.append("Vacant place\n");
        }
        return outLine.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return maxStudentInGroup == group.maxStudentInGroup && Objects.equals(getGroupName(), group.getGroupName()) && Objects.equals(getStudents(), group.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupName(), getStudents(), maxStudentInGroup);
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (!isGroupFull()){
            students.add(student);
        } else throw new GroupOverflowException("Group is full");
    }
    public boolean isGroupFull(){
        if(students.size()==maxStudentInGroup){
            return true;
        } else return false;
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for(Student element:students){
            if (element.getLastName().equals(lastName)){
                return element;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public boolean removeStudentByID(int id) {
        ListIterator<Student> studentListIterator = students.listIterator();
        while (studentListIterator.hasNext()){
            if (studentListIterator.next().getId()==id){
                studentListIterator.remove();
                return true;
            }
        }
        return false;
    }

    public void sortStudentsByLastName() {
        Collections.sort(students, Comparator.nullsFirst((student1, student2) -> student1.getLastName().compareTo(student2.getLastName())));
    }

    public int checkStudentsDuplicates() {
        long uniqueStudentCount = students.stream().distinct().count();
        return (int) (students.size() -  uniqueStudentCount);
    }

    private int vacantPlaceCounter() {
        int counter = 0;
        for (Student element : students) {
            if (element == null) counter++;
        }
        return counter;
    }
}
