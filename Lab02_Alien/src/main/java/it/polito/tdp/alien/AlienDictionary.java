package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dizionario= new ArrayList<Word>();
	
	public void resetDictionary() {
		dizionario.clear();
	}
	
	public void addWord(String alienWord,String traduzione) {
		Word w= new Word(alienWord,traduzione);
		if (dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTraduzione(traduzione);
			return;
			
		}
		dizionario.add(w);
	}

	public String translateWord(String alienWord) {
		Word w= new Word(alienWord);
		if (dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTraduzione();
		}
				
		return null;
	}
}
