package com.ia.pokerhand;

import com.ia.pokerhand.model.Data;

public class MainPokerHand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReaderFileData readerFileData = new ReaderFileData("/home/lfapp/workspace/PokerHand/"
				+ "data/poker-hand-testing.data");
		Data data = readerFileData.loadData();
		
		System.out.println("Missing Values:\n"+readerFileData.missingvaluesToString());
		System.out.println("Inconsistent Data:\n"+readerFileData.inconsistentDataToString());
		System.out.println("Repeat Intances:\n"+readerFileData.repeatedInstancesToString());
		System.out.println(data.getInstance(0));
		System.out.println("Amount per class:\n"+data.amountPerClassToString());
		
		

	}

}
