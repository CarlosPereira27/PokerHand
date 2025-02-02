package com.ia.pokerhand.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
	
	private List<Hand> instances;
	private Map<TypeOfHand, List<Hand>> instancesPerClass;
	
	public Data() {
		this(10);
	}
	
	public Data(int length) {
		instances = new ArrayList<Hand>(length);
		initializesInstancesPerClass();
	}
	
	public List<Hand> getInstances() {
		return instances;
	}

	public void setInstances(List<Hand> instances) {
		this.instances = instances;
	}

	public Map<TypeOfHand, List<Hand>> getInstancesPerClass() {
		return instancesPerClass;
	}

	public void setInstancesPerClass(Map<TypeOfHand, List<Hand>> instancesPerClass) {
		this.instancesPerClass = instancesPerClass;
	}
	
	private void initializesInstancesPerClass() {
		instancesPerClass = new HashMap<>();
		for(int i = 0; i < 10; i++) {
			instancesPerClass.put(TypeOfHand.getInstance(i), new ArrayList<Hand>());
		}
	}
	
	public void addInstance(Hand hand) {
		List<Hand> hands = instancesPerClass.get(hand.getTypeOfHand());
		hands.add(hand);
		instances.add(hand);
	}
	
	public boolean containsInstance(Hand hand) {
		return instances.contains(hand);
	}
	
	public boolean removeInstance(Hand hand) {
		List<Hand> hands = instancesPerClass.get(hand.getTypeOfHand());
		hands.remove(hand);
		return instances.remove(hand);
	}
	
	public Hand getInstance(int index) {
		return instances.get(index);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Hand hand : instances) {
			sb.append(hand+"\n");
		}
		return sb.toString();
	}
	
	public String amountPerClassToString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<TypeOfHand, List<Hand>> entry : instancesPerClass.entrySet()) {
			sb.append(entry.getKey()).append(": ")
			.append(entry.getValue().size()).append('\n');
		}
		return sb.toString();
	}

}
