package fr.thetilerteam;

/*
 * 	Identifiant de chaque carreau
 */
public enum IdCard {
	a,
	b,
	c,
	d,
	e,
	f,
	g,
	h,
	i,
	x,
	
	A,
	B,
	C,
	D,
	E,
	F,
	G,
	H,
	I;
	
	/*
	 * Transforme le type enum en char
	 */
	public char tochar() {
		return (char)toString().charAt(0);
	}

		
}
