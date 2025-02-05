package by.lobanovs;

public class Main {
    public static void main(String[] args) {
        try {
            Arguments arguments = Arguments.parsing(args);

            DataManipulation manipulation = new DataManipulation();
            for (String filePath: arguments.getInputFiles()){
                manipulation.fileManipulation(filePath);
            }

            DataLogging dataLogging = new DataLogging(arguments.getOutputPath(), arguments.getPrefix(), arguments.isAppends());
            dataLogging.writeResult(manipulation.getData());

            if (arguments.isStatsEnabled()) {
                Statistics statistics = new Statistics(manipulation.getData(), arguments.isFullStats());
                statistics.printStatistics();
            }

        } catch (IllegalAccessError e){
            e.printStackTrace();
        }
    }
}