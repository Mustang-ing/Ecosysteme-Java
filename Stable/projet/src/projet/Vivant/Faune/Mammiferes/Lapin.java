package projet.Vivant.Faune.Mammiferes;

import projet.Vivant.EspaceNaturel.PlaineEspaceNaturel;
import projet.Vivant.Faune.Mammifere;
import projet.Vivant.Proie.ProieLapin;
import projet.Vivant.Proie.ProieLoup;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;

public class Lapin extends Mammifere implements ProieLoup, PlaineEspaceNaturel {

    public Lapin(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public boolean estProie(Vivant v) {
        return v instanceof ProieLapin;
    }

    @Override
    public Vivant naissance(int n) {
        return new Lapin("lapin", 2*n, TypeTaille.M);
    }
}
