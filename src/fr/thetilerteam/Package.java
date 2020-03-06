package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Package {
	private ArrayList<Card> pack; // pack liste de cartes
	private static final int MAX_CARDS = 33; // MAX_CARDS max cartes dans un paquet
	
	/*
	 *	Retourne un paquet de 33 cartes mï¿½langï¿½es
	 */
	public Package() {
		pack = new ArrayList<>(Arrays.asList(
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.BLUE,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.RED,SizeCard.UNKNOWN),
				new Card(Color.UNKNOWN,SizeCard.TAILLE1),
				new Card(Color.UNKNOWN,SizeCard.TAILLE1),
				new Card(Color.UNKNOWN,SizeCard.TAILLE1),
				new Card(Color.UNKNOWN,SizeCard.TAILLE1),
				new Card(Color.UNKNOWN,SizeCard.TAILLE1),
				new Card(Color.UNKNOWN,SizeCard.TAILLE2),
				new Card(Color.UNKNOWN,SizeCard.TAILLE2),
				new Card(Color.UNKNOWN,SizeCard.TAILLE2),
				new Card(Color.UNKNOWN,SizeCard.TAILLE2),
				new Card(Color.UNKNOWN,SizeCard.TAILLE2),
				new Card(Color.UNKNOWN,SizeCard.TAILLE3),
				new Card(Color.UNKNOWN,SizeCard.TAILLE3),
				new Card(Color.UNKNOWN,SizeCard.TAILLE3),
				new Card(Color.UNKNOWN,SizeCard.TAILLE3),
				new Card(Color.UNKNOWN,SizeCard.TAILLE3)
				));
		Collections.shuffle(pack);
		
	}
	
	public int getSize() {
		return pack.size();
	}

	public ArrayList<Card> getPack() {
		return pack;
	}

	/*
	 * 	La pioche est vide
	 */
	public boolean isEmpty() {
		return pack.isEmpty();
	}
	
	/*
	 * 	La pioche est pleine
	 */
	public boolean isFull() {
		return pack.size() >= MAX_CARDS;
	}
	
	/*
	 * 	Piocher une carte
	 */
	public Card pick() {
		assert(!isEmpty());
		return pack.remove(pack.size() -1);
	}
	
	/*
	 * Méthode pour les tests JUnit
	 */
	public String toString() {
		String s = "";
		int i = 0;
		for(Card p : pack) {
			++i;
			if(!p.getColor().equals("UNKNOWN")) 
				s+= i + "{" + p.getColor()+ "}" + System.lineSeparator();
			else 
				s+= i + "{" + p.getSize()+ "}" + System.lineSeparator();
		}
		return s;
	}

	/*
	 * 	Affiche la carte pioché
	 * 
	 * @param 
	 */
	public String toString(Card c) throws IllegalArgumentException{
		String s= "";
		if(c.getColor().equals("BLUE") || c.getColor().equals("RED"))
			s+= c.getColor();
		else
			s+= c.getSize();
		return s;
		
	}
}
