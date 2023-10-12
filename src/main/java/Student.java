import java.util.Comparator;

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
}
