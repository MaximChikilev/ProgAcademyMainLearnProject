import java.util.Comparator;
import java.util.Objects;

public class Student extends Human {
    private int id;
    private String groupName;

    public Student(int id, String name, String lastName, Gender gender, String groupName) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return
                "Name: " + super.getName() + " | " +
                        "Last name: " + super.getLastName() + " | " +
                        "Gender: " + super.getGender() + " | " +
                        "Id: " + id + " | " +
                        "GroupName: " + groupName + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() && Objects.equals(getGroupName(), student.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGroupName());
    }
}
