package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckerModel {

	private  List<String> text;
	
	public SpellCheckerModel () {
		text = new ArrayList<>();
	}
	
	public boolean isCorrect(String t, String lang) {
		/*text = t.split(" ");
		
		for(String s : text) {
			//s.replaceAll( "“[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\]"," ");
			s.replaceAll("\\p{Punct}", "");
			System.out.println(s);
		}*/
		return false;
	}

}
