package projet.Vivant.Faune;

import projet.Vivant.Animal;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;
import projet.Zone;

import java.util.Iterator;

public abstract class Mammifere extends Animal {
    public Mammifere(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public void seDeplacer(Iterator<Vivant> iterator) {
        marche(iterator);
    }

}
