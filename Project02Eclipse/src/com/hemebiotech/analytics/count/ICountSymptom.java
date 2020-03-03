package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;

public interface ICountSymptom {

	Map<String, Integer> count(List<String> symptoms);

}