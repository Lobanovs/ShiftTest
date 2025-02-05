package by.lobanovs;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DataLogging {

    private String outputPath;
    private String prefix;
    private boolean appends;

    public DataLogging(String outputPath, String prefix, boolean appends) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.appends = appends;
    }

    /**
     * Метод записи данных в файл, если список данных не пуст
     */
    private void writeToFile(List<String> data, String fileName) {
        if (data.isEmpty()) return;

        Path filePath = Paths.get(outputPath, prefix + fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, appends ? StandardOpenOption.APPEND : StandardOpenOption.CREATE)) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл " + filePath + ": " + e.getMessage());
        }
    }

    public void writeResult(DataStorage data) {
        writeToFile(data.getIntegers(), "integers.txt");
        writeToFile(data.getFloats(), "floats.txt");
        writeToFile(data.getStrings(), "strings.txt");
    }
}
