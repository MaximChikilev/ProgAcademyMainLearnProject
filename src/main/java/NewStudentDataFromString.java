import java.util.Scanner;

public class NewStudentDataFromString implements StudentGenerator {
    private StringConverter stringConverter;
    private String line;

    public NewStudentDataFromString(String line, StringConverter stringConverter) {
        this.line = line;
        this.stringConverter = stringConverter;
    }

    public StringConverter getStringConverter() {
        return stringConverter;
    }

    public void setStringConverter(StringConverter stringConverter) {
        this.stringConverter = stringConverter;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public Student getNewStudent() {
        return stringConverter.fromStringRepresentation(line);
    }
}
