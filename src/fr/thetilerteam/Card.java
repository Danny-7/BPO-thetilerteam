package fr.thetilerteam;

public class Card {
	private Color color;
	private SizeCard size;
	
	/*
	 *  Constructeur d'une carte 
	 *  
	 *  @param color la couleur d'une carte
	 *  @param size la taille de chaque carte
	 */
	public Card(Color color, SizeCard size) {
		this.color = color;
		this.size = size;
		
	}
	
	/*
	 *	Obtient la couleur d'une carte
	 */
	public String getColor() {
		return this.color.name();
	}
	
	/*
	 *	Obtient la taille d'une carte 	
	 */
	public String getSize() {
		return this.size.name();
	}
	
	
}
