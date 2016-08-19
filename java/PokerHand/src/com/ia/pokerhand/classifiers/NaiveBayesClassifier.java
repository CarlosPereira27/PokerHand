/*package com.ia.pokerhand.classifiers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ia.pokerhand.Card;
import com.ia.pokerhand.Data;
import com.ia.pokerhand.Hand;
import com.ia.pokerhand.ReaderFileData;
import com.ia.pokerhand.TypeOfHand;

import main.java.de.daslaboratorium.machinelearning.classifier.Classifier;
import main.java.de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class NaiveBayesClassifier {

	public static void main(String[] args) {

		final Classifier<Card, TypeOfHand> bayes = new BayesClassifier<Card, TypeOfHand>();

		ReaderFileData readerFileData = new ReaderFileData(
				"/home/carlos/Downloads/PokerHand/data/poker-hand-testing.data");
		Data data = readerFileData.loadData();
		Map<TypeOfHand, List<Hand>> instances = data.getInstancesPerClass();
		for (Map.Entry<TypeOfHand, List<Hand>> entry : instances.entrySet()) {
			Collections.shuffle(entry.getValue());
			System.out.println(entry.getKey());
		}

		for (Map.Entry<TypeOfHand, List<Hand>> entry : instances.entrySet()) {
			int max = (int) (entry.getValue().size() * 0.7);
			for (int i = 0; i < max; i++) {
				bayes.learn(entry.getKey(), entry.getValue().get(i).getCards());
			}
		}

		int matriz[][] = new int[10][10];

		for (Map.Entry<TypeOfHand, List<Hand>> entry : instances.entrySet()) {
			int min = (int) (entry.getValue().size() * 0.7);
			for (int i = min; i < entry.getValue().size(); i++) {
				int coluna = bayes.classify(entry.getValue().get(i).getCards()).getCategory().getValue();
				int linha = entry.getKey().getValue();
				matriz[linha][coluna]++;
				System.out.println(coluna);
			}
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
			System.out.println();
		}

	}

}*/
