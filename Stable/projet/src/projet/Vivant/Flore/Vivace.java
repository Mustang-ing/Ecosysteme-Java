package projet.Vivant.Flore;

import projet.Vivant.TypeTaille;
import projet.Vivant.Vegetal;

public abstract class Vivace extends Vegetal {

    public Vivace(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

}
