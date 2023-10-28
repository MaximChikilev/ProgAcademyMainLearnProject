import java.io.File;

public class Main {
    public static void main(String[] args) {
        Group javaGroup = FunctionalityTesting.loadFromCsvFileTest();
        FunctionalityTesting.saveToCsvFileTest(javaGroup);
        FunctionalityTesting.searchStudentTest(javaGroup);
        FunctionalityTesting.inputNewStudentFromKeyboardAndTransferToCsvTest();
        FunctionalityTesting.deleteStudentTest(javaGroup);
        FunctionalityTesting.findFileTesting(javaGroup);
        FunctionalityTesting.findStudentDuplicateTesting(javaGroup);
    }


}
