package fr.thetilerteam;

import static org.junit.jupiter.api.Assertions.*;

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
		System.out.println("la partie est termin�e, le paquet est vide !");
	}

}
