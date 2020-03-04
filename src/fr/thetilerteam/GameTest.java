package fr.thetilerteam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void test() {
		Game g = new Game();
		while(!g.isEmpty()) {
			Scanner sc = new Scanner (System.in);
			System.out.println("Entrez un caractère");
				String id = sc.next();
				try {
				Tile t = g.choice(id);
				System.out.print("["+t.getWidth() +","+t.getHeight()+"]");
				System.out.println(" --> "+ g.getSize());
				}
				catch(IllegalArgumentException e) {
					System.out.println("Veuillez entrez un caractère correct !! \n");
				}
				
	
		}
		System.out.println("Il n'y a plus de carreau !!");
		
	}

}
