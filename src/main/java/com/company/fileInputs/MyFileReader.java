package com.company.fileInputs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    public String reader(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder allLines = new StringBuilder();
        String currentLine = br.readLine();

        while (currentLine != null) {
            allLines.append(currentLine).append('\n');
            currentLine = br.readLine();
        }
        return allLines.toString();
    }
}
