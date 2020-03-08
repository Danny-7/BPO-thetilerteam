package fr.thetilerteam;

import java.io.IOException;
import java.util.ArrayList;

public class Wall {
	private static final int MAX_WIDTH = 5;
	private ArrayList<Character[]> wall;
	
	
	/*
	 * Constructeur de la grille du jeu 
	 */
	public Wall() {
		wall = new ArrayList<Character[]>();
		Character[] t = new Character[MAX_WIDTH];
			wall.add(t); // Ajout d'une ligne au mur
		for(int i = 0; i<wall.size();++i) {
			for(int j = 0; j<wall.get(i).length;++j) {
				wall.get(i)[j] = ' ';
			}
		}
		
		
	}
	
	/*
	 * Ajoute des lignes dans le mur et les remplies
	 * 
	 * @param t le carreau à poser
	 * @param y la position en y
	 */
	private void fillArray(Tile t,int y) {
		int f = y + t.getHeight() +1; // nb lignes à ajouter
		int c = wall.size();
		while(wall.size() < f) {
			Character[] tab = new Character[MAX_WIDTH];
			wall.add(tab);
		}
		
		for(int i = c ; i< wall.size();++i) {
			for(int j = 0; j < wall.get(i).length;++j) {
				wall.get(i)[j] = ' ';
			}
		}
	}
	/*
	 * Retourne le mur
	 */
	public ArrayList<Character[]> getWall(){
		return wall;
	}
	
	/*
	 * Contrainte du non dépassement des limites du mur 
	 * avec la largeur du carreau 
	 * 
	 * @param x la position du carreau
	 * @param t le carreau avec ses propriétées
	 */
	private boolean ismaxSize(int x, Tile t) {
		return (x + t.getWidth() <= MAX_WIDTH) ;
	}
	
	/*
	 * Verifie que la position est dans la grille
	 * 
	 * @param y Position en y
	 * @param x Position en x
	 */
	private boolean wallSize(int y, int x) {
		return (y > -1 && x > -1);
	}
	
	/*
	 * Compare 2 compteurs avec une size du carreau
	 *  (hauteur ou largeur)
	 * 
	 * @param cpt1 compteur n°1
	 * @param cpt1 compteur n°2
	 * @param size taille du carreau
	 */
	private boolean cmp(int cpt1, int cpt2, int size ) {
		boolean ok = true;
		if(cpt1 == 0 && cpt2 == 0) 
			ok = size > 1;
		if(cpt1 == 0 && cpt2 == 1) 
			ok = (size < 2 || size > 2); 
		if(cpt1 == 1 && cpt2 == 1)
			ok = true;
		if(cpt1 == 0 && cpt2 == 2)
			ok = size < 3;
		if(cpt1 == 1 && cpt2 == 0) 
			ok = true;
		return ok;
	}
	
	
	/*
	 * Vérifie qu'un carreau ne clone pas un autre 
	 *
	 * @param y Position en y
	 * @param x Position en x
	 * @param t Le carreau 
	 */
	private boolean countWidth(int y,int x,Tile t) {
		int cptG = 0;
		int cptD = 0;
		boolean ok = false;
		if(y > 0) {
			char c = wall.get(y-1)[x]; /* Lecture du caractère
			présent*/
			if(x > 0) {
				for(int col = x; col > x-1 ; --col) { 
					if(wall.get(y-1)[col-1]== c) 
						++cptG;
				}
			}

			if(x < MAX_WIDTH -1) {
				for(int col = x ; col < x +t.getWidth(); ++col) { 
					if(col < MAX_WIDTH -1) {
						if(wall.get(y-1)[col+1]== c)
							++cptD;
					}
					
				}
			}
			ok = cmp(cptG,cptD,t.getWidth());
		}

		else 
			ok = true;

		return ok;
	}
	
	/*
	 * Compte la largeur d'une ligne
	 * 
	 * @param y Position en y
	 * @param x Position en x
	 * @param t Carreau 
	 */
	private int countBase(int y, int x,Tile t) {
		int cpt = 0;
		if(y>0) {
			for(int col = x; col < x + t.getWidth();++col) {
				if(!(wall.get(y-1)[col]== ' '));
					++cpt;
			}
		}
		return cpt;
	}
	
	/*
	 * Verifie qu'on a une base assez grande et que le carreau
	 *  ne clone pas un autre 
	 * 
	 * @param y Position en y
	 * @param x Position en x
	 * @param t Le carreau 
	 */
	private boolean hasBase(int y,int x, Tile t) {
		boolean ok = false;
		if(wall.get(y)[x] == ' ') { // Si il y'a un carreau déja posé
			if(countWidth(y,x,t)) {
				if(y>0)
					ok = t.getWidth() <= countBase(y,x,t);
				else
					ok = true;
			}
		}
		return ok;
	}
	
	/*
	 * Compter la hauteur d'un carreau sur la gauche
	 * 
	 * @param y Position en y
	 * @param x Position en x
	 * @param t Le carreau 
	 */
	private boolean countLeftHeight(int y,int x, Tile t) {
		int cptH = 0;
		int cptB = 0;
		boolean ok = false;
		if(x > 0) {
			char c = wall.get(y)[x-1];
			if(c!= ' ') {
				// si la position en y est supérieur à 0
				if(y > 0) {
					for(int z = y; z > y-1; --z) {
						if(wall.get(z-1)[x-1]== c)
							++cptB;
					}
					for(int z = y ; z < y + t.getHeight(); ++z) {
						if(wall.get(z+1)[x-1]== c)
							++cptH;
					}
				}
				else {
					for(int z = y ; z < y + t.getHeight(); ++z) {
						if(wall.get(z+1)[x-1]== c)
							++cptH;	
					}
				}
			}
			else {
				return true;
			}
			ok = cmp(cptB,cptH,t.getHeight());
		}

		else
			ok = true;
		return ok;
	}
	
	/*
	 * Compter la hauteur d'un carreau sur la droite
	 */
	private boolean countRightHeight(int y,int x, Tile t) {
		int cptH = 0;
		int cptB = 0;
		boolean ok = false;
		if(x < MAX_WIDTH -1) {
			char c = wall.get(y)[x+1];
			if(c!= ' ') { // Si il y'a un espace on retourne vrai 
				if(y>0) {
					for(int z = y; z > 1; --z) {
						if(wall.get(z-1)[x+1]== c)
							++cptB;
					}
					for(int z = y ; z< y + t.getHeight(); ++z) {
						if(wall.get(z-1)[x+1]== c)
							++cptH;
					}
				}
				else {
					for(int z = y ; z < y + t.getHeight(); ++z) {
						if(wall.get(z+1)[x+1]== c)
							++cptH;	
					}
				}
				
			}
			else {
				return true;
			}
			ok = cmp(cptB,cptH,t.getHeight());
		}
		else 
			ok = true;
		return ok;
	}
	
	/*
	 * Verifie la hauteur d'un carreau
	 */
	private boolean hasHeight(int y, int x, Tile t) {
		boolean ok = false;
		if(x > 0 && x < MAX_WIDTH) {
			/* Si la hauteur du carreau a gauche et a droite nous permet
			de poser le carreau voulu*/
			if(countLeftHeight(y,x,t) && countRightHeight(y,x,t))
				ok = true;
		}
		else 
			ok = true;
		return ok;
	}
	
	/*
	 * Placement du carreau dans la grille
	 * 
	 * @param y lignes
	 * @param x colonnes
	 */
	private void place(int y, int x, Tile t){
		   int mx_Height = y + t.getHeight();
		   int mx_Width = x + t.getWidth();
		   for(; y < mx_Height;++y)
		     for(int z = x; z < mx_Width; ++z)
		       wall.get(y)[z] = t.getId().tochar();
		}

	/*
	 * Ajouter un carreau à la grille
	 * 
	 * @param x position souhaité
	 * @param y postion souhaité
	 * @param id carreau souhaité
	 */
	public void addTile(int y, int x, Tile t) throws IOException{ 
		// Si la taille du carreau en largeur permet de poser le carreau
		if(ismaxSize(x,t) && wallSize(y,x)) {
			int row = y;
			
			if(wall.size() < row + t.getHeight() +1) { 
				fillArray(t,y);
			}
			/* La contrainte d'avoir une base et un carreau d'une
			 *  largeur et hauteur
			 inférieur à un autre déja posé
			 */
			if(hasBase(y,x,t) && hasHeight(y,x,t)) 
				this.place(y,x,t);	
			}
	}

	/* 
	 * Affiche le mur du jeu 
	 */
	public String toString() {
		StringBuilder s = new StringBuilder("");

		for(int i = wall.size() -1;i >= 0; --i) { // MAX_HEIGHT
			int cellSize = wall.get(i).length; // MAX_WIDTH
			s.append(i+1); // Ajout du numéro de ligne
			s.append("  ");
			for(int j = 0; j < cellSize; ++j) {
				if(wall.get(i)[j] != ' ') {
					s.append(wall.get(i)[j]);
					s.append(" ");
				}	
				else
					s.append("  ");
			}
			s.append(System.lineSeparator());
		}
		s.append("  ");
		for(int i = 0; i< MAX_WIDTH; ++i) {
				s.append(" ");
				s.append(i+1); // Ajout du numéro de la colonne
		}
		return s.toString();
	}

}
