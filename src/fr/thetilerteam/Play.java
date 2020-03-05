package fr.thetilerteam;

import java.io.IOException;
import java.util.Random;

public class Play {
	Game game;
	Wall wall;
	Score s;
	Package p;
	
	public Play(Game g, Wall w) {
		this.game = g;
		this.wall = w;
	}
	

	public Play(Game game, Wall wall,Score s,Package p) {
		this(game,wall);
		this.s = s;
		this.p = p;
	}
	

	public void playChoice() {
		System.out.println(" 1 - Piocher une carte !");
	}

	public void exit(){
		 System.exit(0);
	}

	public boolean isFinish(){
		return game.isEmpty() || p.isEmpty();
	}

	public void addTile(int y, int x, Tile t) throws IOException{
		wall.addTile(y,x,t);
	}
	
	public Card pickCard(){
		return p.pick();
	}
	
	public void addRandomTile() throws IOException {
		Random r = new Random();
		switch(1 + r.nextInt(4-0)) {
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

	public String toString(){
		return wall.toString();
	}
}
