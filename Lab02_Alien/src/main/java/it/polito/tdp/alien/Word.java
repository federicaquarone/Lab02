package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String traduzione;
	
	
	public Word(String alienWord, String traduzione) {
		super();
		this.alienWord = alienWord;
		this.traduzione = traduzione;
	}


	public Word(String alienWord2) {
		this.alienWord=alienWord2;
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public String getTraduzione() {
		return traduzione;
	}


	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}


	


	

	
	
}
