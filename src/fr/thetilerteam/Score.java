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

    public void addCard(Card c){
        this.discard.add(c);
    }

    private int countWallScore(){
        int c = 1;
        int row = 0;
        while(c != 5){
            for(int i = 0; i < this.w.getWall().size();++i){
                for(int j = 0; j < this.w.getWall().get(i).length; ++j){
                    char ch = this.w.getWall().get(i)[j];
                    if(ch!= ' ')
                        c++;
                    row = this.w.getWall().size();
                }
            }
        }
        return row;
    }

    public String displayScore(){
        String s = "";
        s+= countWallScore()*POINTS + "points";
        s+= "("+countWallScore()+ "niveaux complets,"+ g.getSize()+ "carreaux non pos�s,"+ this.discard.size()+ "cartes �cart�es)";
        return s;
    }



}
