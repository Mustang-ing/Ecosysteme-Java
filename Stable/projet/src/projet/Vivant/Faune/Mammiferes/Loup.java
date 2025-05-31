package projet.Vivant.Faune.Mammiferes;

import projet.Vivant.EspaceNaturel.ForetEspaceNaturel;
import projet.Vivant.Faune.Mammifere;
import projet.Vivant.Proie.ProieLoup;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;

public class Loup extends Mammifere implements ForetEspaceNaturel {

    public Loup(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public boolean estProie(Vivant v) {
        return v instanceof ProieLoup;
    }

    @Override
    public Vivant naissance(int n) {
        return new Loup("loup", 1*n, TypeTaille.XL);
    }
}
