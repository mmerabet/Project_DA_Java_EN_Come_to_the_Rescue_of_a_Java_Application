package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataToFile {

    private final FileWriter writer;

    public WriteSymptomDataToFile(String targetFile) throws IOException {
        this.writer = new FileWriter(targetFile);
    }

    public void write(String symptom,Integer count) throws IOException {
        writer.write(symptom+"="+count+"\n");
    }

    public void close() throws IOException {
        writer.close();
    }

}