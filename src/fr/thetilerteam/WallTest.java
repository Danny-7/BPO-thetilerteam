package fr.thetilerteam;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class WallTest {

	@Test
	void test() throws IllegalArgumentException, IOException {
		Wall w = new Wall();
		Game g = new Game();
		Play p = new Play(g,w);
		Scanner sc = new Scanner(System.in);
		p.addRandomTile();
		System.out.println(w.toString());
		while(!g.isEmpty()) {
			
			System.out.println("Entrez un caract�re puis la position du carreau � pos� (y,x)");
			String id = sc.next().trim();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			try {
				w.addTile(y,x, g.choice(id));
			}
			catch(IOException e) {
				System.out.println("Entrez des coordon�es correct et/ou un caract�re correct");
			}
			w.toString();
			
		}
		
	}

}
