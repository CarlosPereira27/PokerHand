package com.ia.cleandata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedInstance {
	
	private Map<String, List<Integer>> repeatedInstances;
	
	public RepeatedInstance() {
		repeatedInstances = new HashMap<>();
	}
	
	public void insert(String lineString, int lineNumber) {
		if(repeatedInstances.containsKey(lineString)) {
			List<Integer> numberOfLines = repeatedInstances.get(lineString);
			numberOfLines.add(lineNumber);
		} else {
			List<Integer> numberOfLines = new ArrayList<>();
			numberOfLines.add(lineNumber);
			repeatedInstances.put(lineString, numberOfLines);
		}
	}
	
	public List<Integer> getNumberLinesOfRepeteadInstances() {
		List<Integer> numberLinesRI = new ArrayList<>();
		for (List<Integer> list : repeatedInstances.values()) {
			numberLinesRI.addAll(list);
		}
		return numberLinesRI;
	}

}
