package fr.thetilerteam;

import java.io.IOException;
import java.util.Random;

public class Play {
	Game game;
	Wall wall;
	Package p;
	
	public Play(Game g, Wall w) {
		this.game = g;
		this.wall = w;
	}
	public Play(Game game, Wall wall,Package p) {
		this(game,wall);
		this.p = p;
	}
	

	public void exit(){
		 System.exit(0);
	}
	
	/*
	 * Renvoi vrai si la partie est terminé
	 */
	public boolean isFinish(){
		return game.isEmpty() || p.isEmpty();
	}
	/*
	 * Ajouter un carreau au mur
	 */
	public void addTile(int y, int x, Tile t) throws IllegalArgumentException{
		wall.addTile(y,x,t);
	}
	/*
	 * Piocher une carte
	 */
	public Card pickCard(){
		return p.pick();
	}
	
	/*
	 * Placement de la pièce neutre sur le mur
	 */
	public void addRandomTile() throws IllegalArgumentException {
		Random r = new Random();
		switch(1) {
		case 1: 
			addTile(0,0,new Tile(IdCard.x,3,1));
			break;
		case 2:
			addTile(0,2,new Tile(IdCard.x,3,1));
			break;
		case 3:
			addTile(0,0,new Tile(IdCard.x,1,3));
			break;
		default:
			addTile(0,4,new Tile(IdCard.x,1,3));
			break;
		}
	}
	
	/*
	 * Affiche le mur du jeu 
	 */
	public String toString(){
		return wall.toString();
	}
}
