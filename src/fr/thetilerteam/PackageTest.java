package fr.thetilerteam;

import org.junit.jupiter.api.Test;

class PackageTest {

	@Test
	void test() {
		Package p = new Package();
		Card c;
		
		while(!p.isEmpty()){
			c = p.pick();
			System.out.println(p.toString(c));
		}
		System.out.println("la partie est terminée, le paquet est vide !");
	}

}
