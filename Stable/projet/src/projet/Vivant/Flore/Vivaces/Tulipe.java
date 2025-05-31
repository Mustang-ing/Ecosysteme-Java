package projet.Vivant.Flore.Vivaces;

import projet.Vivant.Flore.Vivace;
import projet.Vivant.Proie.ProieAbeille;
import projet.Vivant.Proie.ProieLapin;
import projet.Vivant.TypeTaille;

public class Tulipe extends Vivace implements ProieLapin {

    public Tulipe(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }


}
