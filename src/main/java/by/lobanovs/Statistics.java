package by.lobanovs;


public class Statistics {

    private DataStorage data;
    private boolean fullStats;

    public Statistics(DataStorage data, boolean fullStats) {
        this.data = data;
        this.fullStats = fullStats;
    }

    public void printStatistics() {
        if(fullStats) {
            printFullStatistics();
        }
        else{
            printShortStatistic();
        }
    }

    private void printShortStatistic() {
        System.out.println("Краткая статистика:");
        System.out.println("Целые числа: " + data.getIntegers().size());
        System.out.println("Вещественные числа: " + data.getFloats().size());
        System.out.println("Строки: " + data.getStrings().size());
    }

    private void printFullStatistics() {
        System.out.println("Полная статистика: ");
        printIntegerStatistics();
        printFloatStatistics();
        printStringStatistics();

    }

    private void printStringStatistics() {
        if(!data.getStrings().isEmpty()) {
            int minLength = data.getStrings().stream()
                    .mapToInt(String::length).min().orElse(0);
            int maxLength = data.getStrings().stream()
                    .mapToInt(String::length).max().orElse(0);

            System.out.println("\nСтроки: " +
                    "\nКоличество строк: " + data.getStrings().size() +
                    "\nМинимальная длина:  " + minLength + "\nМаксимальная длина: " + maxLength + "\n");

        }
    }

    private void printFloatStatistics() {
        if(!data.getFloats().isEmpty()) {
            double min = data.getFloats().stream()
                    .mapToDouble(Double::parseDouble).min().orElse(0);
            double max = data.getFloats().stream()
                    .mapToDouble(Double::parseDouble).max().orElse(0);
            double sum = data.getFloats().stream()
                    .mapToDouble(Double::parseDouble).sum();
            double avg = sum / data.getFloats().size();

            System.out.println("\nВещественные числа: " +
                    "\nКоличество вещественных чисел: " + data.getFloats().size() +
                    "\nМинимальное вещественное: " + min + "\nМаксимальное вещественное: " + max +
                    "\nСреднее вещественное: " + avg + "\n");
        }
    }

    private void printIntegerStatistics() {
        if (!data.getIntegers().isEmpty()) {
            long min = data.getIntegers().stream()
                    .mapToLong(Long::parseLong).min().orElse(0);
            long max = data.getIntegers().stream()
                    .mapToLong(Long::parseLong).max().orElse(0);
            long sum = data.getIntegers().stream()
                    .mapToLong(Long::parseLong).sum();
            double avg = (double) sum / data.getIntegers().size();

            System.out.println("\n Целые числа: " +
                    "\nКоличество целых чисел: " + data.getIntegers().size() +
                    "\nМинимальное целое: " + min + "\nМаксимальное целое: " + max +
                    "\nСреднее целое: " + avg + "\n");
        }
    }
}
