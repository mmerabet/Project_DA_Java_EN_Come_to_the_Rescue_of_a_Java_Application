package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataToFile implements IWriteSymptomDataToFile {

    private final FileWriter writer;

    public WriteSymptomDataToFile(String targetFile) throws IOException {
        this.writer = new FileWriter(targetFile);
    }

    @Override
	public void write(String symptom,Integer count) throws IOException {
        writer.write(symptom+"="+count+"\n");
    }

    @Override
	public void close() throws IOException {
        writer.close();
    }

}