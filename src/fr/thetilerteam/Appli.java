package fr.thetilerteam;


import java.io.IOException;
import java.util.Scanner;

public class Appli {

	public static void gameMessage() {
		System.out.println(" Pour arr�ter de jouer --> exit");
		System.out.println(" Pour jouer --> jouer");
		System.out.println(" Obtenir son score --> score");
	}
	public static void main(String[] args) {
		// Instanciation de tous les objets
		Package p = new Package();
		Game game = new Game();
		Wall w = new Wall();
		Score s = new Score(w,game);
		Play play = new Play(game,w,p);
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
		String choix = sc.next().trim().toLowerCase();
		if(choix.equals("jouer")) {
			// Tant que le paquet de carte n'est pas vide et la liste des carreaux n'est pas vide
			while(!play.isFinish()){
				String chain = "";
				// On joue tant que la chaine de caract�re n'est pas "exit"
				if (!chain.trim().toLowerCase().equals("stop")) {
					// On pioche une carte
					Card c = play.pickCard();
					System.out.println("Voici la carte pioch�e !" + "\t" + p.toString(c) + "\n");
					System.out.println("Voici les carreaux disponible(s) pour la carte pioch�e:" + "\n" + game.toStringtab(c));
					System.out.println("Voulez vous garder la carte ? OUI/NON");
					chain = sc.next().trim().toUpperCase();
					if(chain.equals("NON")) {
						s.addCard(c);
						c = play.pickCard();
						System.out.println("Voici la nouvelle carte pioch�e !" + "\t" + p.toString(c));
						System.out.println("Voici les carreaux dispo pour la nouvelle carte pioch�e:" + "\n" + game.toStringtab(c));
						System.out.println("Voulez vous garder la carte ? OUI/NON");
						chain = sc.next().trim().toUpperCase();
					}
					else if(chain.equals("OUI")) {
						System.out.println("Selectionner un carreau pour la consigne donn�e [a-i][A-I] et la position (y,x)");
						chain = sc.next().trim();
						int y = sc.nextInt() - 1;
						int x = sc.nextInt() - 1;

						try {
							// On essaye de poser le carreau sinon on renvoi ce message d'erreur 
							play.addTile(y, x, game.choice(chain));
						} catch (IllegalArgumentException | IOException e) {
							System.out.println("Entrez des coordonn�es correct o� verifiez les conditions de pose !!");
						}
						// Affichage du mur
						System.out.println(play.toString() + "\n");
						System.out.println("Voulez vous continuer ou arr�ter de jouer ? (stop ou jouer)");
						chain = sc.next().trim().toLowerCase();
					}
					else
						System.out.println("Erreur de saisie !!!!");
					}
				else {
					System.out.println("Voici votre score : " + s.displayScore());
					System.out.println("\t");
					System.out.println(play.toString());
					// Arr�t du jeu 
					play.exit();
				}
				}
			}
		
		else if(choix.equals("stop")) {
			System.out.println("Voici votre score : " + s.displayScore());
			System.out.println("\t");
			System.out.println(play.toString());
			System.out.println("\n" +"La partie est termin�e merci d'avoir jou�");
			play.exit();

		}
		else {
			
			System.out.println("Voici votre score : " + s.displayScore());
			System.out.println("\t");
		}
		
		sc.close();
	}
	
}