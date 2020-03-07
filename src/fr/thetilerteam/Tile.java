package fr.thetilerteam;


public class Tile {
	private IdCard id;
	private int width;
	private int height;
	private Color color;

	/*
	 * Constructeur d'un carreau
	 * 
	 * @param id l'identifiant du carreau
	 * @param width largeur du carreau
	 * @param height hauteur du carreau
	 */
	public Tile(IdCard id, int width, int height) {
		this.id = id;
		this.height = height;
		this.width = width;
	}

	/*
	 * Constructeur d'un carreau
	 * 
	 * @param id l'identifiant du carreau
	 * @param width largeur du carreau
	 * @param height hauteur du carreau
	 * @param color couleur du carreau
	 */
	public Tile(IdCard id, int width, int height,Color color){
		this(id,width,height);
		this.color = color;
	}

	/*
	 * Retourne l'identifiant d'un carreau
	 */
	public IdCard getId() {
		assert(this.id != null);
		return this.id;
	}

	/*
	 * Retourne la largeur d'un carreau
	 */
	public int getWidth() {
		return this.width;
	}

	/*
	 * Retourne la hauteur d'un carreau
	 */
	public int getHeight() {
		return this.height;
	}

	/*
	 * Retourne la couleur d'un carreau
	 */
	public String getColor() {
		return this.color.name();
	}


	/* Verifie que la couleur de la carte et du carreau soi la même
	 * 
	 * @param c la carte
	 * @param t le carreau 
	 */
	public boolean isColor(Card c, Tile t) {
		return c.getColor().equals(t.getColor());
	}

	/* Verifie que la taille de la carte et du carreau soi la même
	 * 
	 * @param c la carte
	 * @param t le carreau 
	 */
	public boolean isSize(Card c,Tile t) {
		String s = c.getSize().substring(6);
		String larg = Integer.toString(t.getWidth());
		String haut = Integer.toString(t.getHeight());

		return (s.equals(larg) || s.equals(haut));
	}




}
