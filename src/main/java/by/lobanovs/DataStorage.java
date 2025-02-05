package by.lobanovs;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private List<String> integers = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private List<String> floats = new ArrayList<>();

    public List<String> getIntegers() {
        return integers;
    }

    public List<String> getStrings() {
        return strings;
    }

    public List<String> getFloats() {
        return floats;
    }
}
