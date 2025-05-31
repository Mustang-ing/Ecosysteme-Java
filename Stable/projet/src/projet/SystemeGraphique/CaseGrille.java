package projet.SystemeGraphique;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;



class CaseGrille{

    private Color c;
    public LinkedList<Disque> lDisques;

    CaseGrille(){
        lDisques=new LinkedList<Disque>();
    }


    public void setCouleur(Color c){this.c=c;}
    public Color getCouleur(){return c;}

    
    public void addDisque(int rayon, Color c, BufferedImage img){
	lDisques.add(new Disque(rayon,c,img));
    }

    public void removeDisque(Disque d){
        lDisques.remove(d);
    }

}
