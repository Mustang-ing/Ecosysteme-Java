package projet.Vivant.Faune;

import projet.Vivant.Animal;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;
import projet.Zone;

import java.util.Iterator;

public abstract class Insecte extends Animal {
    public Insecte(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public abstract void seDeplacer(Iterator<Vivant> iterator);

}
