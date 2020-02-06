package com.company.fileOutputs;

import com.company.interfaces.Writer;

import java.io.*;

public class MyFileWriter implements Writer {

    public void write(String filepath, String output) throws IOException {
        FileWriter x = new FileWriter(filepath);
        BufferedWriter bufferedWriter = new BufferedWriter(x);
        bufferedWriter.write(output);
        bufferedWriter.close();
    }
}
