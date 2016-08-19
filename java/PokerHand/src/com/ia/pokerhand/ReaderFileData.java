package com.ia.pokerhand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ia.pokerhand.model.Card;
import com.ia.pokerhand.model.Data;
import com.ia.pokerhand.model.Hand;
import com.ia.pokerhand.model.Rank;
import com.ia.pokerhand.model.Suit;
import com.ia.pokerhand.model.TypeOfHand;

public class ReaderFileData {
	
	private File file;
	private int numberOfInstances;
	private Map<Integer, String> inconsistentData;
	private Map<Integer, String> missingValues;
	private Map<String, List<Integer>> repeatedInstances;
	
	public ReaderFileData(String file) {
		this.setFile(new File(file));
		this.inconsistentData = new HashMap<>();
		this.missingValues = new HashMap<>();
		this.repeatedInstances = new HashMap<>();
		defineNumberOfInstances();
	}
	
	private void defineNumberOfInstances() {
		numberOfInstances = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (br.readLine() != null) {
				numberOfInstances++;
		    }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private Hand getHand(int[] attributes) throws InconsistentDataException {
		Hand hand = new Hand();
		for(int i = 0; i < 5; i++) {
			if(attributes[i*2] < 1 || attributes[i*2] > 4) {
				throw new InconsistentDataException();
			}
			if(attributes[i*2+1] < 1 || attributes[i*2+1] > 13) {
				throw new InconsistentDataException();
			}
			hand.addCard(new Card(Suit.getInstance(attributes[i*2]), 
					Rank.getInstance(attributes[i*2+1])));
		}
		if(attributes[attributes.length-1] < 0 || attributes[attributes.length-1] > 9) {
			throw new InconsistentDataException();
		}
		hand.setTypeOfHand(TypeOfHand.getInstance(attributes[attributes.length-1]));
		return hand;
	}
	
	private int[] parseInt(String[] elements) {
		int[] array = new int[elements.length];
		for(int i = 0; i < elements.length; i++) {
			array[i] = Integer.parseInt(elements[i]);
		}
		return array;
	}
	
	public Data loadData() {
		try {
			Data data = new Data(numberOfInstances);
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file.getName().concat(".clean"))));
			int contLine = 1;
		    String line = br.readLine();
		    while (line != null) {
		    	String[] attributes = line.split(",");
		    	if(attributes.length < 11) {
		    		missingValues.put(contLine, line);
		    		contLine++;
		    		line = br.readLine();
		    		continue;
		    	}
		    	try {
		    		Hand hand = getHand(parseInt(attributes));
		    		if(data.containsInstance(hand)) {
		    			if(repeatedInstances.containsKey(line)) {
		    				List<Integer> numberOfLines = repeatedInstances.get(line);
		    				numberOfLines.add(contLine);
		    			} else {
		    				List<Integer> numberOfLines = new ArrayList<>();
		    				numberOfLines.add(contLine);
		    				repeatedInstances.put(line, numberOfLines);
		    			}
		    		} else {
		    			bw.write(line);
		    			data.addInstance(hand);
		    		}
		    		bw.write(line);
		    		data.addInstance(hand);
		    	} catch (NumberFormatException e) {
		    		inconsistentData.put(contLine, line);
		    	} catch (InconsistentDataException e) {
		    		inconsistentData.put(contLine, line);
		    	}
		    	contLine++;
		        line = br.readLine();
		    }
		    br.close();
		    return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String inconsistentDataToString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, String> entry : inconsistentData.entrySet()) {
			sb.append(entry.getKey()).append(": ")
			.append(entry.getValue()).append('\n');
		}
		return sb.toString();
	}
	
	public String missingvaluesToString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, String> entry : missingValues.entrySet()) {
			sb.append(entry.getKey()).append(": ")
			.append(entry.getValue()).append('\n');
		}
		return sb.toString();
	}
	
	public String repeatedInstancesToString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, List<Integer>> entry : repeatedInstances.entrySet()) {
			sb.append(entry.getKey()).append(": ")
			.append(entry.getValue().size()).append('\n');
		}
		return sb.toString();
	}
	

}
