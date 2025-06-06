package projet.SystemeGraphique;

import projet.Ecosysteme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrilleNature extends JPanel
{
	private int nbCasesL, nbCasesH;
        private int nbPixelCoteCase;
        private CaseGrille[][] m;


    	/**
	 * Constructeur.
	 * @param nbCasesL La largeur (en nombre de cases) de la grille.
	 * @param nbCasesH La hauteur (en nombre de cases) de la grille.
	 * @param nbPixelCoteCase Nb de Pixel d'une case de la grille
	 **/
		public GrilleNature(int nbCasesL, int nbCasesH, int nbPixelCoteCase) {
	    int i,j;
	    	this.nbCasesL = nbCasesL;
		this.nbCasesH = nbCasesH;
		this.nbPixelCoteCase = nbPixelCoteCase;

		JFrame window = new JFrame();
		window.setSize(nbCasesL*nbPixelCoteCase+50, nbCasesH*nbPixelCoteCase+50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
	        this.m = new CaseGrille[nbCasesL][nbCasesH];
		for (i=0;i<nbCasesL;i++)
		    for (j=0;j<nbCasesH;j++)
			m[i][j]=new CaseGrille();
		}

        public void redessine(){
	    repaint();
        }
    
         public void colorieFond(int i, int j, Color c){
	     m[i][j].setCouleur(c);
         }

         public void addDisque(int i, int j, int rayon, Color c, BufferedImage img){
	     	m[i][j].addDisque(rayon,c,img);
		 }

		 public void removeDisque(int i, int j, Disque d) {
			 m[i][j].removeDisque(d);
		 }

		 public CaseGrille getCaseGrille(int i, int j){return m[i][j];}


	

       @Override
	//Fonction d'affichage de la grille appelée par repaint
	protected void paintComponent(Graphics g) 
	{
	    //Colorie les cases de casesAColorier
	 	super.paintComponent(g);
		int i,j;

		for (i=0;i<nbCasesL;i++) {
			for (j=0;j<nbCasesH;j++) {
				int limite = 10;

				int cellX = limite + (i * nbPixelCoteCase);
				int cellY = limite + (j * nbPixelCoteCase);
				g.setColor(m[i][j].getCouleur());
				g.fillRect(cellX, cellY, nbPixelCoteCase, nbPixelCoteCase);

				int cellX2 = cellX + nbPixelCoteCase - 2*limite;
				int cellY2 = cellY + nbPixelCoteCase - 2*limite;

				// Place des disques
				for (Disque d: m[i][j].lDisques) {
					Random r = new Random();

					int posX = r.nextInt(cellX2 - cellX) + cellX;
					int posY = r.nextInt(cellY2 - cellY) + cellY;

					g.drawImage(d.getImg(), posX, posY, 20, 20, null);

					/*g.setColor(d.getCouleur());
						g.fillOval(posX, posY, d.getRayon(), d.getRayon());*/

				}

			}
		}

		// Redessine la grille
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, nbCasesL*nbPixelCoteCase, nbCasesH*nbPixelCoteCase);

		for (i = 10; i <= nbCasesL*nbPixelCoteCase; i += nbPixelCoteCase) {
			g.drawLine(i, 10, i, nbCasesH*nbPixelCoteCase+10);
		}

		for (i = 10; i <= nbCasesH*nbPixelCoteCase; i += nbPixelCoteCase) {
			g.drawLine(10, i, nbCasesL*nbPixelCoteCase+10, i);
		}
	}

}
