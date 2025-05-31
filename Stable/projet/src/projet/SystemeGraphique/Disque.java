package projet.SystemeGraphique;

import java.awt.Color;
import java.awt.image.BufferedImage;

class Disque{

    private int rayon;
    private Color c;

    private BufferedImage img;

    Disque(){}
    
    Disque(int rayon, Color c, BufferedImage img){
	    this.rayon=rayon;
	    this.c=c;
        this.img = img;
    }

    public int getRayon(){ return rayon;}
    public void setRayon(int rayon){this.rayon=rayon;}
    public Color getCouleur(){ return c;}
    public void setCouleur(Color c){this.c=c;}

    public BufferedImage getImg(){return img;}

    public void setImg(BufferedImage img) {this.img=img;}
	


}
