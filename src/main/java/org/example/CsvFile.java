package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFile {
    public static File csvFileController;

    public CsvFile(String fullFileLocation) {
        csvFileController = new File(fullFileLocation);
    }

    public static List<String> read(String fileLocation) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileLocation));
            List<String> rows = new ArrayList<>();
            csvReader.readLine();
            while (true) {
                String rowInfo = csvReader.readLine();
                if (rowInfo == null) {
                    break;
                }
                rows.addAll(Arrays.asList(rowInfo.split(",")));
            }
            return rows;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void create() {
        try {
            csvFileController.createNewFile();
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }

    public boolean isExist() {
        return csvFileController.exists() && !csvFileController.isDirectory();
    }

    @SuppressWarnings("NonAsciiCharacters")
    public void insertًWithAppend(List<String> rows) {
        try {
            FileWriter csvWriter = new FileWriter(csvFileController, true);
            for (String row : rows) {
                csvWriter.append(row).append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            throw new Error(e);

        }
    }
    public void rename(File newFile)
    {
        csvFileController.renameTo(newFile);
    }
}
