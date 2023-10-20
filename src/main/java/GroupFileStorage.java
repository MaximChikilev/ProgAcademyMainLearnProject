import java.io.*;

public class GroupFileStorage {
    private String defaultPath = "./src/main/resources/";


    public GroupFileStorage() {
    }

    public void saveGroupToCSV(Group group) {
        File file = new File(defaultPath + group.getGroupName() + ".csv");
        StringConverter csvStringConverter = new CSVStringConverter();
        Student[] students = group.getStudents();
        try (Writer writer = new FileWriter(file)) {
            for (Student element : students) {
                if (element != null) {
                    element.setGroupName(group.getGroupName());
                    writer.write(csvStringConverter.toStringRepresentation(element) + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Group loadGroupFromCSV(File file) throws GroupOverflowException {
        StringConverter csvStringConverter = new CSVStringConverter();
        String filename = file.getName();
        String[] groupName = filename.split("\\.");
        int r = groupName.length;
        Group group = new Group(groupName[0]);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                group.addStudent(csvStringConverter.fromStringRepresentation(line));
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return group;
    }

    File findFileByGroupName(String groupName, File workFolder) {
        File[] listOfFiles = workFolder.listFiles();
        for (File element:listOfFiles){
            String[] separatedNameFile = element.getName().split("\\.");
            if(groupName.equals(separatedNameFile[0])){
                return element;
            }
        }
        return workFolder;
    }
}
