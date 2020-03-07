package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Arrays;

public class Game{

	private ArrayList<Tile> tile; //tile liste de carreaux
	private static final int MAX_TAILLE = 3;
	private static final int MAX_SIZE = 45;



	/*
	 * Retourne une liste de carreaux
	 */
	public Game() {

		tile = new ArrayList<>(Arrays.asList(
				new Tile(IdCard.a,1,1,Color.BLUE),
				new Tile(IdCard.b,1,2,Color.BLUE),
				new Tile(IdCard.c,2,1,Color.BLUE),
				new Tile(IdCard.d,2,2,Color.BLUE),
				new Tile(IdCard.e,1,3,Color.BLUE),
				new Tile(IdCard.f,3,1,Color.BLUE),
				new Tile(IdCard.g,2,3,Color.BLUE),
				new Tile(IdCard.h,3,2,Color.BLUE),
				new Tile(IdCard.i,3,3,Color.BLUE),
				new Tile(IdCard.A,1,1,Color.RED),
				new Tile(IdCard.B,1,2,Color.RED),
				new Tile(IdCard.C,2,1,Color.RED),
				new Tile(IdCard.D,2,2,Color.RED),
				new Tile(IdCard.E,1,3,Color.RED),
				new Tile(IdCard.F,3,1,Color.RED),
				new Tile(IdCard.G,2,3,Color.RED),
				new Tile(IdCard.H,3,2,Color.RED),
				new Tile(IdCard.I,3,3,Color.RED)
				));
	}
	/*
	 * Retourne le nombre de carreaux dans la liste
	 */
	public int getSize(){
		return tile.size();
	}

	/*
	 * La liste de carreaux est vide
	 */
	public boolean isEmpty() {
		return tile.isEmpty();
	}

	/* Stock les carreaux disponibles dans un tableau
	 * 
	 * @param c la carte qui a été piochée
	 * @return tab tableau qui contient les carreaux disponibles 
	 *  
	 */
	private char[][]availableTile(Card c) {
		char[][] tab = new char[3][MAX_SIZE];
		for(int i = 0; i<MAX_TAILLE; ++i) {
			for(int j = 0; j< MAX_SIZE; ++j) {
				tab[i][j] = ' ';
			}
		}

		int cptcol=0;
		for (Tile t: tile) { // Parcours des carreaux dans la liste
			if(t.isColor(c, t) || t.isSize(c, t) ) {
				for(int j = 0; j< t.getWidth(); ++j) {
					for(int k = 0; k< t.getHeight();++k) {
						tab[k][cptcol] = t.getId().tochar(); // Ajout de l'identifiant du carreau 
					}
					cptcol++;
				}
				if(cptcol<MAX_SIZE) {
					cptcol+=2; // Permet de faire l'espace entre chaque carreau
				}
			}
		}
		return tab;
	}

	/* Affiche les carreaux disponibles
	 * 
	 * @param c la carte qui a été piocher
	 */
	public String toStringtab(Card c) {
		char[][] tab = availableTile(c);
		StringBuilder sb = new StringBuilder("");
		for(int j = MAX_TAILLE -1; j >=0; --j) {
			for(int i = 0; i < MAX_SIZE; ++i) {
				sb.append(tab[j][i]);
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	/*
	 * Retourne le carreau souhaité
	 * 
	 * @param id le carreau souhaité
	 *
	 */
	public  Tile choice(String id) throws IllegalArgumentException {
		int i = 0;
		while(!tile.get(i).getId().name().equals(id)){
			++i;
		}
		return tile.remove(i);
	}
}



