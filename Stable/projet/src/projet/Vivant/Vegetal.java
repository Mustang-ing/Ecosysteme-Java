package projet.Vivant;

import projet.TypeZone;

import java.util.Iterator;

public abstract class Vegetal extends Vivant {

	public Vegetal(String nom, int nb_individus, TypeTaille taille) {
		super(nom, nb_individus, taille);
	}


	public void boire() {
		setEau(getEau() + 5);
		getZone().setNiveauEau(getZone().getNiveauEau()-1);
	}

	@Override
	public void soif() {
		switch (getZone().getZone()) {
			case DESERT -> {
				setEau(getEau() - 5);
			}
			case PLAINE -> {
				setEau(getEau() - 3);
			}
			case FORET -> {
				setEau(getEau() - 1);
			}
		}
	}

	public void augmentationVegetal()
	{
		switch (getZone().getZone()) {
			case DESERT -> {
				if(getEau() > 50) {
					setNbIndividus(getNbIndividus() + 10);
				} else {
					setNbIndividus(getNbIndividus() + 5);
				}
			}
			case PLAINE -> {
				if(getEau() > 50) {
					setNbIndividus(getNbIndividus() + 30);
				} else {
					setNbIndividus(getNbIndividus() + 10);
				}
			}
			case FORET -> {
				if(getEau() > 50) {
					setNbIndividus(getNbIndividus() + 50);
				} else {
					setNbIndividus(getNbIndividus() + 30);
				}
			}
		}
	}

	public void diminutionVegetal()  {
		switch (getZone().getZone()) {
			case DESERT -> {
				if(getEau() < 50) {
					setNbIndividus(getNbIndividus() - 30);
				} else {
					setNbIndividus(getNbIndividus() - 10);
				}
			}
			case PLAINE -> {
				if(getEau() < 50) {
					setNbIndividus(getNbIndividus() - 10);
				} else {
					setNbIndividus(getNbIndividus() - 5);
				}
			}
			case FORET -> {
				if(getEau() < 50) {
					setNbIndividus(getNbIndividus() - 5);
				} else {
					setNbIndividus(getNbIndividus() - 2);
				}
			}
		}
	}


	public void updateVegetal() {
		augmentationVegetal();
		diminutionVegetal();
	}


}
