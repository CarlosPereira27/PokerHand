package com.ia.pokerhand.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class AttributeRelationFileFormat {
	
	private File fileData;
	private File file;
	
	public void writeFile() {
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader(fileData));
			bw = new BufferedWriter(new FileWriter(file));
			
			bw.write("@RELATION pokerhand\n\n");
			
			bw.write("@ATTRIBUTE S1 {1,2,3,4}\n");
			bw.write("@ATTRIBUTE C1 {1,2,3,4,5,6,7,8,9,10,11,12,13}\n");
			bw.write("@ATTRIBUTE S2 {1,2,3,4}\n");
			bw.write("@ATTRIBUTE C2 {1,2,3,4,5,6,7,8,9,10,11,12,13}\n");
			bw.write("@ATTRIBUTE S3 {1,2,3,4}\n");
			bw.write("@ATTRIBUTE C3 {1,2,3,4,5,6,7,8,9,10,11,12,13}\n");
			bw.write("@ATTRIBUTE S4 {1,2,3,4}\n");
			bw.write("@ATTRIBUTE C4 {1,2,3,4,5,6,7,8,9,10,11,12,13}\n");
			bw.write("@ATTRIBUTE S5 {1,2,3,4}\n");
			bw.write("@ATTRIBUTE C5 {1,2,3,4,5,6,7,8,9,10,11,12,13}\n");
			bw.write("@ATTRIBUTE class {0,1,2,3,4,5,6,7,8,9}\n\n");
			
			bw.write("@DATA}\n\n");
			
			String line;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static BufferedReader readDataFile(String filename) {
			BufferedReader inputReader = null;

			try {
				File file = new File(filename);
				inputReader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException ex) {
				System.err.println(ex.getMessage());
			}

			return inputReader;
		}
	
	public static void main(String[] args) throws  Throwable {
		BufferedReader datafile = readDataFile("poker-hand-testing.arff");

		 Instances full = new Instances(datafile);//instancias de todos os dados 
		 full.randomize(new  java.util.Random(0));//distribuimos aleatóriamente por posição
		 
		 int trainSize = (int)Math.round(full.numInstances() *0.10);//trainSize é a quantidade de instancias que serão destinada ao treinamento do classificador
		 
		 int testSize = full.numInstances() - trainSize;
		 Instances train = new Instances(full,0,trainSize);
		 Instances test = new Instances(full,trainSize,testSize);
		 
		 train.setClassIndex(train.numAttributes() - 1);//selecionamos qual será a classe meta
		 test.setClassIndex(test.numAttributes() - 1);//selecionamos qual será a classe meta
		 
		 
		 //instanciando o classificador naiveBayes
		 Classifier cls = new NaiveBayes();
		 
		 cls.buildClassifier(train);//construindo o classificador e treinando ele com as instancias de treinamento
		 // evaluate classifier and print some statistics
		 Evaluation eval = new Evaluation(train);//analisando o classificador 
		 eval.evaluateModel(cls, test);
		 
		 System.out.println(cls);
		 System.out.println(eval.toSummaryString("\nResultados======\n", true));
		 System.out.println(eval.toMatrixString());//imprimindo a matrix de confusão
	}

}
