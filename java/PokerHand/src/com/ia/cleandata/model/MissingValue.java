package com.ia.cleandata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingValue {

	private Map<Integer, String> missingValues;
	
	public MissingValue() {
		missingValues = new HashMap<>();
	}
	
	public void insert(String lineString, int lineNumber) {
		missingValues.put(lineNumber, lineString);
	}
	
	public List<Integer> getNumberLinesOfMissingValues() {
		return new ArrayList<>(missingValues.keySet());
	}
	
}
