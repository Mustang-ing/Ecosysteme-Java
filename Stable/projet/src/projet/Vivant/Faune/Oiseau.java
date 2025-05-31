package projet.Vivant.Faune;
import projet.Vivant.Animal;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;
import projet.Zone;

import java.util.Iterator;

public abstract class Oiseau extends Animal {

    public Oiseau(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public void seDeplacer(Iterator<Vivant> iterator) {
        vol(iterator);
    }

}
