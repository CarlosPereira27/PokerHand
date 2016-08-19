package com.ia.cleandata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InconsistentData {

	private Map<Integer, String> inconsistentData;
	
	public InconsistentData() {
		inconsistentData = new HashMap<>();
	}
	
	public void insert(String lineString, int lineNumber) {
		inconsistentData.put(lineNumber, lineString);
	}
	
	public List<Integer> getNumberLinesOfInconsistentData() {
		return new ArrayList<>(inconsistentData.keySet());
	}
	
}
