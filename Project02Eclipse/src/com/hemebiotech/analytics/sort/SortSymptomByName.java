package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortSymptomByName implements ISortSymptomByName {
    @Override
	public List<String> sort(Collection<String> symptoms){
        List<String> copy = new ArrayList<>(symptoms);
        Collections.sort(copy);
        return copy;
    }
}
