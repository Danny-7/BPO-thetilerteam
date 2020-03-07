package fr.thetilerteam;

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
			
			System.out.println("Entrez un caractère puis"
					+ " la position du carreau à posé (y,x)");
			String id = sc.next().trim();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			try {
				p.addTile(y,x, g.choice(id));
			}
			catch(IllegalArgumentException  | IOException e) {
				System.out.println("Impossible de poser le carreau ! ");
			}
			
			System.out.println(w.toString());
		}
		sc.close();
			
		}
}
