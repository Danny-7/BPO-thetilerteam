package fr.thetilerteam;


import java.io.IOException;
import java.util.Scanner;

public class Appli {

	public static void gameMessage() {
		System.out.println("\n Pour arr�ter de jouer --> exit");
		System.out.println("Pour jouer --> jouer");
		System.out.println("Obtenir son score - score");
	}
	public static void main(String[] args) {
		// Instanciation de tous les objets
		Package p = new Package();
		Game game = new Game();
		Wall w = new Wall();
		Score s = new Score(w,game);
		Play play = new Play(game,w,s,p);
		// Placement de la pi�ce neutre
		try {
			play.addRandomTile();
		} catch (IOException e) {
			System.out.println("Impossible !!");
			
		}
		System.out.println("D�but de partie !! Bonne chance \n");
		System.out.println(play.toString());
		Scanner sc = new Scanner(System.in);
		gameMessage();
		String choix = sc.next();
		if(choix.equals("jouer")) {
			// Tant que le paquet de carte n'est pas vide et la liste des carreaux n'est pas vide
			while(!play.isFinish()){
				String chain = "";
				// On joue tant que la chaine de carct�re n'st pas "exit"
				if (!chain.equals("exit")) {
					Card c = play.pickCard();
					System.out.println("Voici la carte pioch�e !" + "\t" + p.toString(c) + "\n");
					System.out.println("Voici les carreaux dispo pour la carte tir�e:" + "\n" + game.toStringtab(c));
					System.out.println("Voulez vous gardez la carte ? OUI/NON");
					chain = sc.next().trim();
					while(chain.equals("NON")) {
						s.addCard(c);
						c = play.pickCard();
						System.out.println("Voici la carte pioch�e !" + "\t" + p.toString(c));
						System.out.println("Voici les carreaux dispo pour la carte tir�e:" + "\n" + game.toStringtab(c));
						System.out.println("Voulez vous gardez la carte ? OUI/NON");
						chain = sc.next().trim().toUpperCase();
					} 
						System.out.println("Selectionner un carreau pour la consigne donn�e [a-i][A-I] et la position");
						chain = sc.next();
						int y = sc.nextInt() - 1;
						int x = sc.nextInt() - 1;

						try {
							play.addTile(y, x, game.choice(chain));
						} catch (IllegalArgumentException | IOException e) {
							System.out.println("Entrez des  coordonn�es correct o� verifiez les conditions de pose !!");
						} 
						System.out.println(play.toString() + "\n");
						System.out.println(s.displayScore());
						System.out.println("Voulez vous continuer ou arr�ter de jouer ? (exit)");
						sc.next().trim();
					}
				else {
					System.out.println(s.displayScore());
					System.out.println("\t");
					System.out.println(play.toString());
					play.exit();
				}
				}
			}
		
		else if(choix.equals("exit")) {
			System.out.println(s.displayScore());
			System.out.println("\t");
			System.out.println(play.toString());
			play.exit();

		}
		else {
			System.out.println(s.displayScore());
			System.out.println("\t");
		}
		sc.close();

	}
}