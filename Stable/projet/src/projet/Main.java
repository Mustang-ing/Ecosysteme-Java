package projet;

import projet.SystemeGraphique.GrilleNature;
import projet.SystemeGraphique.MoteurGraphique;
import projet.Vivant.Faune.Mammiferes.Lapin;
import projet.Vivant.Faune.Mammiferes.Loup;
import projet.Vivant.TypeTaille;

import java.awt.*;

public class Main {
	
	  public static void main(String[] args) {

		  final int LARGEUR = 10;
		  final int HAUTEUR = 7;
		  final int CYCLE = 30;

		  // Instanciation
		  Ecosysteme e = new Ecosysteme(LARGEUR, HAUTEUR);
		  MoteurGraphique m = new MoteurGraphique(e);

		  // Initialisation
		  e.initEcosysteme();
		  m.initMap();

		  // Boucle de simulation
		  for (int c = 0; c < CYCLE; c++) {
			  e.updateEcosysteme();
			  m.removeAll();
			  m.updateMap();
			  try {
				  Thread.sleep(400);
			  }
			  catch (InterruptedException exception){
				  exception.printStackTrace();
			  }
		  }

	  }

}
