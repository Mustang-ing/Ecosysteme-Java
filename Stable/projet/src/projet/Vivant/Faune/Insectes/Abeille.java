package projet.Vivant.Faune.Insectes;

import projet.Vivant.EspaceNaturel.PlaineEspaceNaturel;
import projet.Vivant.Faune.Insecte;
import projet.Vivant.Proie.ProieAbeille;
import projet.Vivant.TypeTaille;
import projet.Vivant.Vivant;
import projet.Zone;

import java.util.Iterator;

public class Abeille extends Insecte implements PlaineEspaceNaturel {

    public Abeille(String nom, int nb_individus, TypeTaille taille) {
        super(nom, nb_individus, taille);
    }

    @Override
    public boolean estProie(Vivant v) {
        return v instanceof ProieAbeille;
    }

    @Override
    public Vivant naissance(int n) {
        return new Abeille("abeille", 20 * n, TypeTaille.S);
    }

    @Override
    public void seDeplacer(Iterator<Vivant> iterator) {
        vol(iterator);
    }

}
