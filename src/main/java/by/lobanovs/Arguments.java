package by.lobanovs;

import java.util.ArrayList;
import java.util.List;

public class Arguments {

    private String outputPath = "."; // путь к папке
    private String prefix = "";
    private boolean appends = false; // флаг -а
    private boolean shortStats = false; // флаг -s
    private boolean fullStats = false; // флаг -f
    private boolean statsEnabled = false; // флаг для статистики
    private List<String> inputFiles = new ArrayList<>();


    /**
     * Метод парсинга аргументов командной строки
     */
    public static Arguments parsing(String[] args) {
        Arguments arguments = new Arguments();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("Не указан путь после -o");
                    }
                    arguments.outputPath = args[++i];
                    break;
                case "-p":
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("Ошибка: Не указан префикс после -p");
                    }
                    arguments.prefix = args[++i];
                    break;
                case "-a":
                    arguments.appends = true;
                    break;
                case "-s":
                    if (arguments.fullStats) {
                        throw new IllegalArgumentException("Ошибка: Нельзя использовать -s и -f одновременно.");
                    }
                    arguments.shortStats = true;
                    arguments.statsEnabled = true;
                    break;
                case "-f":
                    if (arguments.shortStats) {
                        throw new IllegalArgumentException("Ошибка: Нельзя использовать -s и -f одновременно.");
                    }
                    arguments.fullStats = true;
                    arguments.statsEnabled = true;
                    break;
                default:
                    if (args[i].endsWith(".txt")) {
                        arguments.inputFiles.add(args[i]);
                    }
                    break;
            }
        }

        if(arguments.inputFiles.isEmpty()) {
            throw new IllegalArgumentException("не указаны входные файлы");
        }

        return arguments;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppends() {
        return appends;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public boolean isStatsEnabled() {
        return statsEnabled;
    }
}
