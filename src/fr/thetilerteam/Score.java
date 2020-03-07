package fr.thetilerteam;

import java.util.ArrayList;

public class Score {
    private ArrayList<Card> discard;
    private static final int POINTS = 5;
    private Wall w;
    private Game g;

    public Score(Wall w, Game g) {
        discard = new ArrayList<>();
        this.w = w;
        this.g = g;
    }
    
    /*
     * Ajouter une carte écartée
     */
    public void addCard(Card c){
        this.discard.add(c);
    }
    /*
     * Renvoi le niveau maximal complet
     */
    private int countWallScore(){
        int c = 0;
        int row = 0;
            for(int i = this.w.getWall().size() -1; i >= 0;--i){
            	if(c == 5) {
            		row =  i+2;
            		return row;
            	}
            	 c = 0;
                for(int j = 0; j < this.w.getWall().get(i).length; ++j){
                	
                		
                    char ch = this.w.getWall().get(i)[j];
                    if(ch!= ' ')
                        c++;
                  
                }
               
            }
       return row;
    }
    
    /*
     * Compte le nombre de pénalité
     */
    private int  penaltyCount() {
    	int remainingTile = g.getSize();
    	int discardTile = discard.size();
    	return remainingTile + discardTile;
    }
    /*
     * Affiche le score de l'équipe
     */
    public String displayScore(){
        String s = "";
        s+= countWallScore()*POINTS - penaltyCount() +" points";
        s+= " ("+countWallScore()+" niveaux complets, "+ g.getSize()+ " carreaux non posés, "+ this.discard.size()+" cartes écartées)";
        return s;
    }
}
