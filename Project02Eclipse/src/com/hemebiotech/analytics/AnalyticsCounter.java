package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;

import java.util.*;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ICountSymptom counter;
    private final ISortSymptomByName sorter;
    private final IWriteSymptomDataToFile writer;

    public AnalyticsCounter(ISymptomReader reader, ICountSymptom counter, ISortSymptomByName sorter, IWriteSymptomDataToFile writer) {
        this.reader = reader;
        this.counter = counter;
        this.sorter = sorter;
        this.writer = writer;
    }

    public void execute() throws Exception {
        //2eme étape: On lit le fichier symptoms.txt
        List<String> allSymptoms = reader.GetSymptoms();

        //3eme étape: On utilise la classe CountSymptom cette fois ci pour compter les symptoms.
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

        //4eme étape: On range dans l'ordre alphabétique les symptoms.
        List<String> symptoms = sorter.sort(symptomsCounter.keySet());

        //5eme étape: On écrit le fichier result.out
        for (String symptom: symptoms){
            writer.write(symptom, symptomsCounter.get(symptom));
        }
        writer.close();
    }
}
