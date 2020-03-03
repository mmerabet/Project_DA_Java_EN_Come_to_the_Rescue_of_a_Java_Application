package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.*;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.SortSymptomByName;

public class AnalyticsCounter {
    //1ere étape: On déclare une HashMap clé/valeur <> symptoms/occurences
    static Map<String, Integer>  symptomsCounter = new HashMap<>();


    public static void main(String args[]) throws Exception {
        //2eme étape: On lit le fichier symptoms.txt
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> allSymptoms = reader.GetSymptoms();

        //3eme étape: On parcours le fichier en comptant les symptoms avec la map.
        CountSymptom counter = new CountSymptom();
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);
        
        //4eme étape: On range dans l'ordre alphabétique les symtoms.
        SortSymptomByName sorter = new SortSymptomByName();
        List<String> symptoms = sorter.sort(symptomsCounter.keySet());
        
        //5eme étape: On écrit le fichier result.out
        FileWriter writer = new FileWriter ("result.out");
        for (String symptom: symptoms){
            writer.write(symptom+"="+symptomsCounter.get(symptom)+"\n");
        }
        writer.close();
    }
}
