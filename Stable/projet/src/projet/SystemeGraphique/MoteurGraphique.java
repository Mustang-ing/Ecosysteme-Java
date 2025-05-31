package projet.SystemeGraphique;

import projet.Ecosysteme;
import projet.Vivant.Proie.Proie;
import projet.Vivant.Vegetal;
import projet.Vivant.Vivant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class MoteurGraphique {
    private Ecosysteme e;
    private GrilleNature g;
    private final Color couleur_foret = new Color(39, 174, 96);
    private final Color couleur_plaine = new Color (46, 204, 113);
    private final Color couleur_desert = new Color (241, 196, 15);

    public MoteurGraphique(Ecosysteme e) {
        this.e = e;
        this.g = new GrilleNature(e.getNbZonesL(), e.getNbZonesH(), 100);
    }

    public void initMap() {
        int i, j;
        int l = e.getNbZonesL();
        int h = e.getNbZonesH();

        for (i = 0; i < l; i++) {
            for (j = 0; j < h; j++) {
                // Graphisme Zones
                try {
                    switch (e.getZone(i, j).getZone()) {
                        case DESERT -> {
                            g.colorieFond(i,j,couleur_desert);
                        }
                        case PLAINE -> {
                            g.colorieFond(i,j,couleur_plaine);
                        }
                        case FORET -> {
                            g.colorieFond(i,j,couleur_foret);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }

                // Graphisme Vivants
                try {
                    for (Vivant v : e.getZone(i, j).getVivants()) {

                        switch (v.nom) {
                            case "loup" -> {
                                BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Images/loup.png")));
                                g.addDisque(i, j, 20, Color.LIGHT_GRAY, image);
                            }
                            case "lapin" -> {
                                BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Images/lapin.png")));
                                g.addDisque(i, j, 20, Color.WHITE, image);
                            }
                        }



                        /*if (v instanceof Vegetal) {
                            // g.addDisque(i, j, 20, Color.LIGHT_GRAY);
                        }
                        else if (v instanceof Proie) {
                            g.addDisque(i, j, 10, Color.WHITE);
                        }
                        else {
                            g.addDisque(i, j, 10, Color.GRAY);
                        }*/
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        }

        g.redessine();
    }

    public void removeAll() {
        for (int i = 0; i < e.getNbZonesL(); i++) {
            for (int j = 0; j < e.getNbZonesH(); j++) {
                g.getCaseGrille(i, j).lDisques.clear();
            }
        }
    }

    public void updateMap() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        int i, j;
        int l = e.getNbZonesL();
        int h = e.getNbZonesH();

        for (i = 0; i < l; i++) {
            for (j = 0; j < h; j++) {
                try {
                    switch (e.getZone(i, j).getZone()) {
                        case DESERT -> {
                            g.colorieFond(i,j,couleur_desert);
                        }
                        case PLAINE -> {
                            g.colorieFond(i,j,couleur_plaine);
                        }
                        case FORET -> {
                            g.colorieFond(i,j,couleur_foret);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }

                // Graphisme Vivants
                try {
                    for (Vivant v : e.getZone(i, j).getVivants()) {

                        switch (v.nom) {
                            case "loup" -> {
                                BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Images/loup.png")));
                                g.addDisque(i, j, 20, Color.LIGHT_GRAY, image);
                            }
                            case "lapin" -> {
                                BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Images/lapin.png")));
                                g.addDisque(i, j, 20, Color.WHITE, image);
                            }
                        }



                        /*if (v instanceof Vegetal) {
                            // g.addDisque(i, j, 20, Color.LIGHT_GRAY);
                        }
                        else if (v instanceof Proie) {
                            g.addDisque(i, j, 10, Color.WHITE);
                        }
                        else {
                            g.addDisque(i, j, 10, Color.GRAY);
                        }*/
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        }

        g.redessine();
    }


}
