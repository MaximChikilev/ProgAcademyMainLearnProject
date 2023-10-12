import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int result = 0;
        if ((o1 != null) & (o2 != null)) {
            return o1.getLastName().compareTo(o2.getLastName());
        } else return 0;
    }
}
