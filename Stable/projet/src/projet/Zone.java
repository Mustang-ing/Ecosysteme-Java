package projet;

import projet.Vivant.Flore.Arbre;
import projet.Vivant.Vegetal;
import projet.Vivant.Vivant;

import java.util.ArrayList;
import java.util.Iterator;

public class Zone {
	private final int id;
	private TypeZone zone;
	private TypePosition position;
	private ArrayList<Zone> adjacents;
	private int temperature;
	private int niveauEau;
	private ArrayList<Vivant> vivants;

	public ArrayList<Vivant> morts;

	public ArrayList<Vivant> bebes;
	
	public Zone(int id, TypeZone zone) {
		this.id = id;
		this.zone = zone;
		this.adjacents = new ArrayList<Zone>();
		switch (zone) {
			case DESERT -> {
				temperature = 40;
				niveauEau = 20;
			}
			case PLAINE -> {
				temperature = 30;
				niveauEau = 70;
			}
			case FORET -> {
				temperature = 20;
				niveauEau = 80;
			}
		}
		this.vivants = new ArrayList<Vivant>();
		this.morts = new ArrayList<Vivant>();
		this.bebes = new ArrayList<Vivant>();
	}

	public int getId() {
		return id;
	}
	
	public void setPosition(TypePosition t) {
		this.position = t;
	}
	
	public TypePosition getPosition() {
		return position;
	}

	public TypeZone getZone() {
		return zone;
	}

	public void addAjacent(Zone a) {
		this.adjacents.add(a);
	}

	public ArrayList<Zone> getAdjacents() {
		return adjacents;
	}

	public ArrayList<Vivant> getVivants() {
		return vivants;
	}

	public void addVivant(Vivant v) {
		vivants.add(v);
	}

	public void removeVivant(Vivant v) {
		vivants.remove(v);
	}

	public int getNiveauEau() {return niveauEau;}

	public void setNiveauEau(int n) {
		if (n > 100) niveauEau = 100;
		else if (niveauEau <= 5) {
			niveauEau = 5;
		}
		niveauEau = n;
	}

	public void pluie() {
		switch (zone) {
			case DESERT -> {
				break;
			}
			case PLAINE -> {
				setNiveauEau(niveauEau + 2);
			}
			case FORET -> {
				setNiveauEau(niveauEau + 5);
			}
		}
	}

	public void setZone() {
		pluie();

		switch (zone) {
			case DESERT -> {
				break;
			}
			case PLAINE -> {
				if (niveauEau < 35) {
					zone = TypeZone.DESERT;
				} else if (niveauEau > 75 && getNbArbre() > 100) {
					zone = TypeZone.FORET;
				}
			}
			case FORET -> {
				if (niveauEau < 75 && getNbArbre() < 100) {
					zone = TypeZone.PLAINE;
				}
			}
		}
	}


	public void evaporation()
	{
		switch(zone) {
			case FORET -> {
				setNiveauEau(niveauEau - 5);
			}
			case PLAINE -> {
				setNiveauEau(niveauEau - 10);
			}
			case DESERT -> {
				setNiveauEau(niveauEau - 15);
			}
		}
	}

	public int getNbArbre() {
		int nbArbre = 0;
		for (Vivant v: vivants) {
			if (v instanceof Arbre) {
				nbArbre += v.getNbIndividus();
			}
		}
		return nbArbre;
	}

	public void effetDeZone() {
		int nbArbre = getNbArbre();

		if (nbArbre > 150) {
			for (Zone z : adjacents) {
				if (z.getZone() != TypeZone.DESERT) {
					for (Vivant v: z.getVivants()) {
						if (v instanceof Arbre) {
							v.setNbIndividus(v.getNbIndividus() + 50);
						}
					}
				}
			}
		}

	}

	public void updateZone() {
		effetDeZone();
		setZone();

		/*for (Iterator<Vivant> iterator = vivants.iterator(); iterator.hasNext();) {
			Vivant v = iterator.next();
			v.updateVivant(iterator);
		}*/

		Iterator<Vivant> iterator = vivants.iterator();

		while (iterator.hasNext()) {
			iterator.next().updateVivant(iterator);
		}


		/*for (int i = 0; i < vivants.size(); i++) {
			vivants.get(i).updateVivant();
		}*/

		/*for (Vivant v : vivants) {
			v.updateVivant();
		}*/

		for (Vivant v : morts) {
			this.vivants.remove(v);
		}
		morts.clear();

		for (Vivant v : bebes) {
			this.vivants.add(v);
		}
		bebes.clear();

	}

	@Override
	public String toString() {
		return "[id=" + id + ", zone=" + zone + "]";
	}
	
}
