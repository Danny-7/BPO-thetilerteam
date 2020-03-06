package fr.thetilerteam;


import java.io.IOException;
import java.util.Scanner;

public class Appli {
	private static final String SCORE = "Voici votre score : ";

	public static void gameMessage() {
		System.out.println(" Pour arrêter de jouer --> exit");
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
		// Placement de la pièce neutre
		try {
			play.addRandomTile();
		} catch (IOException e) {
			System.out.println("Impossible !!");

		}
		System.out.println("Début de partie !! Bonne chance \n");
		System.out.println(play.toString());
		Scanner sc = new Scanner(System.in);
		gameMessage();
		String choix = sc.next();
		if(choix.equalsIgnoreCase("jouer")) {
			// Tant que le paquet de carte n'est pas vide et la liste des carreaux n'est pas vide
			while(!play.isFinish()){
				String chain = "";
				// On joue tant que la chaine de caractère n'est pas "exit"
				if (!chain.equalsIgnoreCase("stop")) {
					// On pioche une carte
					Card c = play.pickCard();
					System.out.println("Voici la carte piochée !" + "\t" + p.toString(c) + "\n");
					System.out.println("Voici les carreaux disponible(s) pour la carte piochée:" + "\n" + game.toStringtab(c));
					System.out.println("Voulez vous garder la carte ? OUI/NON");
					chain = sc.next().trim().toUpperCase();
					while(chain.equalsIgnoreCase("NON")) {
						s.addCard(c);
						c = play.pickCard();
						System.out.println("Voici la nouvelle carte piochée !" + "\t" + p.toString(c));
						System.out.println("Voici les carreaux dispo pour la nouvelle carte piochée:" + "\n" + game.toStringtab(c));
						System.out.println("Voulez vous garder la carte ? OUI/NON");
						chain = sc.next();
					}

					System.out.println("Selectionner un carreau pour la consigne donnée [a-i][A-I] et la position (y,x)");
					chain = sc.next().trim();
					int y = sc.nextInt() - 1;
					int x = sc.nextInt() - 1;

					try {
						// On essaye de poser le carreau sinon on renvoi ce message d'erreur 
						play.addTile(y, x, game.choice(chain));
					} catch (IllegalArgumentException | IOException e) {
						System.out.println("Entrez des coordonnées correct où verifiez les conditions de pose !!");
					}
					// Affichage du mur
					System.out.println(play.toString() + "\n");
					System.out.println("Voulez vous continuer ou arrêter de jouer ? (stop ou jouer)");
					chain = sc.next();

				}
				else {
					System.out.println(SCORE + s.displayScore());
					System.out.println("\t");
					System.out.println(play.toString());
					System.out.println("\n" +"La partie est terminée merci d'avoir joué");
					// Arrêt du jeu 
					play.exit();
				}
			}
		}
		else if(choix.equals("stop")) {
			System.out.println(SCORE + s.displayScore());
			System.out.println("\t");
			System.out.println(play.toString());
			System.out.println("\n" +"La partie est terminée merci d'avoir joué !");
			play.exit();

		}
		else {

			System.out.println(SCORE  + s.displayScore());
			System.out.println("\t");
		}

		sc.close();
	}

	
}
	
