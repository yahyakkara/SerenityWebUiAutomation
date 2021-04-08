package Utilities;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    public static void writeCsvFile(String fileName, String[] headerList, List<String[]> recordList) {
        List<String[]> csvData = createCsvData(headerList,recordList);
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String[]> createCsvData(String[] headerList, List<String[]> recordList) {
        List<String[]> list = new ArrayList<>();
        list.add(headerList);
        list.addAll(recordList);
        return list;
    }
}
