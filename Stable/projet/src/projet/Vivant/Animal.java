package projet.Vivant;

import projet.LoiNature;
import projet.TypeZone;
import projet.Vivant.EspaceNaturel.DesertEspaceNaturel;
import projet.Vivant.EspaceNaturel.ForetEspaceNaturel;
import projet.Vivant.EspaceNaturel.PlaineEspaceNaturel;
import projet.Vivant.Proie.Proie;
import projet.Zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class Animal extends Vivant {
	private int nourriture;

	public Animal(String nom, int nb_individus, TypeTaille taille) {
		super(nom, nb_individus, taille);
		nourriture = 100;
	}

	public void seNourrir(Vivant v) {

		// Tester si l'animal a faim
		if (nourriture < 60 && this != v) {

			// Tester si c'est une "proie"
			if (estProie(v)) {

				// Différents cas en fonction de la taille
				switch (getTaille()) {
					case S -> {
						switch (v.getTaille()) {
							case S -> {
								setNourriture(nourriture + 100);
							}
							case M -> {
								break;
							}
							case XL -> {
								break;
							}
						}
					}
					case M -> {
						switch (v.getTaille()) {
							case S -> {
								setNourriture(nourriture + 50);
							}
							case M -> {
								setNourriture(nourriture + 100);
							}
							case XL -> {
								break;
							}
						}
					}
					case XL -> {
						switch (v.getTaille()) {
							case S -> {
								setNourriture(nourriture + 25);
							}
							case M -> {
								setNourriture(nourriture + 50);
							}
							case XL -> {
								setNourriture(nourriture + 100);
							}
						}
					}
				}

				// Tuer le vivant mangé
				v.mourrir();

			}
		}
	}

	public void faim() {
		setNourriture(nourriture - 10);
	}

	public void setNourriture(int n) {
		if (nourriture > 100) nourriture = 100;
		else if (nourriture <= 0) {
			mourrir();
			nourriture = 100;
		}
		else nourriture = n;
	}

	public abstract boolean estProie(Vivant v);

	@Override
	public void boire() {
		if(getZone().getZone() != TypeZone.DESERT) {
			setEau(getEau() + 20);
			getZone().setNiveauEau(getZone().getNiveauEau()-2);
		}
	}

	public void soif() {
		switch (getZone().getZone()) {
			case DESERT -> {
				if (this instanceof DesertEspaceNaturel) {
					setEau(getEau() - 10);
				}
				else {
					setEau(getEau() - 30);
				}
			}
			case PLAINE -> {
				if (this instanceof PlaineEspaceNaturel) {
					setEau(getEau() - 5);
				}
				else {
					setEau(getEau() - 10);
				}
			}
			case FORET -> {
				if (this instanceof ForetEspaceNaturel) {
					setEau(getEau() - 2);
				}
				else {
					setEau(getEau() - 5);
				}
			}
		}
	}

	public boolean seReproduire(Vivant v) {
		// Tester si c'est la même espèce
		if (nom.equals(v.nom)) {
			Vivant bebe = naissance((getNbIndividus()+v.getNbIndividus())/2);
			bebe.setZone(getZone());
			getZone().bebes.add(bebe);
			//getZone().getVivants().add(bebe);
			return true;
		}
		return false;
	}

	public abstract Vivant naissance(int n);

	public void marche(Iterator<Vivant> iterator) {
		Random r = new Random();
		int index = r.nextInt(getZone().getAdjacents().size());
		Zone z = getZone().getAdjacents().get(index);

		//getZone().removeVivant(this);
		iterator.remove();
		z.addVivant(this);
		setZone(z);
	}

	public void vol(Iterator<Vivant> iterator) {
		marche(iterator);
		marche(iterator);
	}

	public abstract void seDeplacer(Iterator<Vivant> iterator);

	public void updateAnimal(Iterator<Vivant> iterator) {
		LoiNature l = new LoiNature();

		/*Deplacement*/
		if (this instanceof Proie) {
			if (l.deplacerProie()) {
				seDeplacer(iterator);
			}
		} else {
			if (l.deplacerPredateur()) {
				seDeplacer(iterator);
			}
		}

		/*Nourriture*/
		if (l.realiserPredation()) {
			for (Vivant v : getZone().getVivants()) {
				seNourrir(v);
			}
		}

		/*Faim*/
		faim();

		/*Reproduction*/
		if (this instanceof Proie) {
			if (l.reproduireProie()) {

				/*ArrayList<Animal> animaux = new ArrayList<Animal>();
				for (Vivant v : getZone().getVivants()) {
					if (v instanceof Animal && v instanceof Proie) {
						animaux.add((Animal) v);
					}
				}
				Random r = new Random();
				int index = r.nextInt(getZone().getVivants().size());
				Vivant v = getZone().getVivants().get(index);

				seReproduire(v);*/

				for (Vivant v : getZone().getVivants()) {
					if (v instanceof Animal) {
						boolean reproduction = seReproduire(v);
						if (reproduction) {
							break;
						}
					}
				}
			}
		} else {
			if (l.reproduirePredateur()) {
				for (Vivant v : getZone().getVivants()) {
					if (v instanceof Animal) {
						boolean reproduction = seReproduire(v);
						if (reproduction) {
							break;
						}
					}
				}
			}
		}

	}

}
