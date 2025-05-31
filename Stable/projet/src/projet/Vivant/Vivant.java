package projet.Vivant;

import projet.Zone;

import java.util.Iterator;

public abstract class Vivant {
	public String nom;
	private int nb_individus;
	private int eau;
	private final TypeTaille taille;
	private Zone zone;
	
	public Vivant(String nom, int nb_individus, TypeTaille taille) {
		this.nom = nom;
		this.nb_individus = nb_individus;
		eau = 100;
		this.taille = taille;
	}

	public int getNbIndividus() {
		return nb_individus;
	}

	public void setNbIndividus(int n) {
		nb_individus = n;
	}

	public TypeTaille getTaille() {
		return taille;
	}

	public void setZone(Zone z) {
		zone = z;
	}

	public Zone getZone() {
		return zone;
	}

	public void mourrir() {
		if (nb_individus == 1) {
			zone.morts.add(this);
			//iterator.remove();
			//zone.getVivants().remove(this);
		}
		else {
			nb_individus -= 1;
		}
	}

	public int getEau() {
		return eau;
	}

	public void setEau(int e) {
		if (e > 100) eau = 100;
		else if (e <= 0) {
			mourrir();
			eau = 100;
		}
		else eau = e;
	}


	public abstract void boire();

	public abstract void soif();

	public void updateVivant(Iterator<Vivant> iterator) {
		boire();
		soif();

		if (this instanceof Vegetal) {
			((Vegetal) this).updateVegetal();
		} else if (this instanceof Animal) {
			((Animal) this).updateAnimal(iterator);
		}

	}

	
}
