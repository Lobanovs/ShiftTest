package by.lobanovs;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataManipulation {
    private DataStorage data = new DataStorage();


    private void lineManipulation(String line){
        if (line.matches("^-?\\d+$")) {
            data.getIntegers().add(line);
        } else if (line.matches("^-?\\d+\\.\\d+$|^-?\\d+\\.\\d+[eE][-+]?\\d+$")) {
            data.getFloats().add(line);
        } else {
            data.getStrings().add(line);
        }
    }

    public void fileManipulation(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                lineManipulation(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл " + filePath + " не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + filePath);
        }
    }

    public DataStorage getData(){
        return data;
    }
}
