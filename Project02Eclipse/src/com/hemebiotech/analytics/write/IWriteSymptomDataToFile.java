package com.hemebiotech.analytics.write;

import java.io.IOException;

public interface IWriteSymptomDataToFile {

	void write(String symptom, Integer count) throws IOException;

	void close() throws IOException;

}