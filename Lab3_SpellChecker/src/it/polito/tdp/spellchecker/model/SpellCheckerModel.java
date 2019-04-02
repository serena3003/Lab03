package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpellCheckerModel {

	//private List<String> text;
	private List<String> italianDict;
	private List<String> englishDict;

	public SpellCheckerModel() {
		//text = new ArrayList<>();
		italianDict = new LinkedList<>();
		englishDict = new LinkedList<>();
		this.readDictionaries();
	}

	public List<String> isCorrect(String t, String lang) {
		
		List<String> notCorrect = new LinkedList<>();

		t = t.replaceAll("\\p{Punct}", "");
		t = t.toLowerCase();

		String[] text = t.split(" ");

		if (lang.equals("Italiano")) {
			for(String te : text) {
				if(!italianDict.contains(te)){
					notCorrect.add(te);
				}
			}
		}
		
		if (lang.equals("English")) {
			for(String te : text) {
				if(!englishDict.contains(te)){
					notCorrect.add(te);
				}
			}
		}
		
		return notCorrect;
	}

	private void readDictionaries() {
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				englishDict.add(word);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
		try {
			FileReader fr = new FileReader("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				italianDict.add(word);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}

}
