package projet;

import projet.Vivant.Faune.Mammiferes.Lapin;
import projet.Vivant.Faune.Mammiferes.Loup;
import projet.Vivant.Flore.Arbres.Bouleau;
import projet.Vivant.Flore.Vivaces.Tulipe;
import projet.Vivant.TypeTaille;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ecosysteme {
	private Zone[][] zones;
	private int nb_zones_l;
	private int nb_zones_h;
	
	public Ecosysteme(int nb_zones_l, int nb_zones_h) {
		zones = new Zone[nb_zones_l][nb_zones_h];
		this.nb_zones_l = nb_zones_l;
		this.nb_zones_h = nb_zones_h;
	}

	public int getNbZonesL() {
		return nb_zones_l;
	}

	public int getNbZonesH() {
		return nb_zones_h;
	}
	
	public void addZone(Zone z, int i, int j) {
		zones[i][j] = z;
	}
	
	public Zone getZone(int i, int j) throws ZoneNotFoundException {
		if (i >= 0 && i < nb_zones_l && j >= 0 && j < nb_zones_h) {
			return zones[i][j];
		}
		throw new ZoneNotFoundException(i, j);
	}
	
	public void setPositionZones() {
		for (int i = 0; i < nb_zones_l; i++) {
			for (int j = 0; j < nb_zones_h; j++) {
				if (i == 0 && j == 0) zones[i][j].setPosition(TypePosition.COIN_SUP_G);
				else if (i == nb_zones_l-1 && j == 0) zones[i][j].setPosition(TypePosition.COIN_SUP_D);
				else if (i == 0 && j == nb_zones_h-1) zones[i][j].setPosition(TypePosition.COIN_INF_G);
				else if (i == nb_zones_l-1 && j == nb_zones_h-1) zones[i][j].setPosition(TypePosition.COIN_INF_D);
				else if (i == 0) zones[i][j].setPosition(TypePosition.BORD_G);
				else if (i == nb_zones_l-1) zones[i][j].setPosition(TypePosition.BORD_D);
				else if (j == 0) zones[i][j].setPosition(TypePosition.BORD_SUP);
				else if (j == nb_zones_h-1) zones[i][j].setPosition(TypePosition.BORD_INF);
				else zones[i][j].setPosition(TypePosition.NORMAL);
			}
		}
	}

	public void setAdjacents() throws ZoneNotFoundException {
		for (int i = 0; i < nb_zones_l; i++) {
			for (int j = 0; j < nb_zones_h; j++) {

				int l = nb_zones_l;
				int h = nb_zones_h;

				Zone z = zones[i][j];
				int z_id = z.getId();

				// Ajouter les adjacents
				switch (z.getPosition()) {
					case COIN_SUP_G -> {
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById(z_id+h+1));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById((z_id+2*h)-1));
						z.addAjacent(getZoneById(z_id+h*(l-1)));
						z.addAjacent(getZoneById((z_id+h*(l-1))+1));
						z.addAjacent(getZoneById((z_id+h*l)-1));
					}
					case COIN_SUP_D -> {
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id-h*(l-1)));
						z.addAjacent(getZoneById((z_id-h*(l-1))+1));
						z.addAjacent(getZoneById((z_id-h*(l-2))-1));
					}
					case COIN_INF_G -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id+h*(l-1)));
						z.addAjacent(getZoneById((z_id+h*(l-1))-1));
						z.addAjacent(getZoneById((z_id+h*(l-2))+1));
					}
					case COIN_INF_D -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById((z_id-h)-1));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById((z_id-2*h)+1));
						z.addAjacent(getZoneById(z_id-h*(l-1)));
						z.addAjacent(getZoneById((z_id-h*(l-1))-1));
						z.addAjacent(getZoneById((z_id-h*l)+1));
					}
					case BORD_SUP -> {
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById(z_id+h+1));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+h-1));
						z.addAjacent(getZoneById((z_id+2*h)-1));
					}
					case BORD_INF -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById((z_id-h)-1));
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById((z_id-2*h)+1));
					}
					case BORD_G -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById(z_id+h+1));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById(z_id+h*(l-1)));
						z.addAjacent(getZoneById((z_id+h*(l-1))+1));
						z.addAjacent(getZoneById((z_id+h*(l-1))-1));
					}
					case BORD_D -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById((z_id-h)+1));
						z.addAjacent(getZoneById((z_id-h)-1));
						z.addAjacent(getZoneById(z_id-h*(l-1)));
						z.addAjacent(getZoneById((z_id-h*(l-1))-1));
						z.addAjacent(getZoneById((z_id-h*(l-1))+1));
					}
					case NORMAL -> {
						z.addAjacent(getZoneById(z_id-1));
						z.addAjacent(getZoneById(z_id+1));
						z.addAjacent(getZoneById(z_id-h));
						z.addAjacent(getZoneById(z_id+h));
						z.addAjacent(getZoneById((z_id-h)-1));
						z.addAjacent(getZoneById((z_id+h)-1));
						z.addAjacent(getZoneById(z_id+h-1));
						z.addAjacent(getZoneById(z_id+h+1));
					}
				}

				// Enlever les doublons
				Set<Zone> adjacentsSansDoublons = new HashSet<>(z.getAdjacents());
				z.getAdjacents().clear();
				z.getAdjacents().addAll(adjacentsSansDoublons);

			}
		}
	}

	public Zone getZoneById(int id) throws ZoneNotFoundException {
		for (int i = 0; i < nb_zones_l; i++) {
			for (int j = 0; j < nb_zones_h; j++) {
				if (zones[i][j].getId() == id) {
					return zones[i][j];
				}
			}
		}
		throw new ZoneNotFoundException(id);
	}

	public void initZones() {
		int i, j;
		int k = 0;
		int total = nb_zones_l*nb_zones_h;

		for (i = 0; i < nb_zones_l; i++) {
			for (j = 0; j < nb_zones_h; j++) {
				Zone z;
				if (k < total / 2) {
					z = new Zone(k+1, TypeZone.PLAINE);
				} else {
					z = new Zone(k+1, TypeZone.FORET);
				}
				k++;
				addZone(z, i, j);
			}
		}
	}

	public void initVivants() {
		LoiNature l = new LoiNature();

		for (int i = 0; i < nb_zones_l; i++) {
			for (int j = 0; j < nb_zones_h; j++) {
				Zone z = zones[i][j];

				// Ajouter Vegetaux
				switch (zones[i][j].getZone()) {
					case DESERT -> {
						break;
					}
					case PLAINE -> {
						Bouleau bouleau = new Bouleau("bouleau", 50, TypeTaille.XL);
						Tulipe tulipe = new Tulipe("tulipe", 70, TypeTaille.S);
						z.addVivant(bouleau);
						z.addVivant(tulipe);
						bouleau.setZone(z);
						tulipe.setZone(z);
					}
					case FORET -> {
						Bouleau bouleau = new Bouleau("bouleau", 200, TypeTaille.XL);
						Tulipe tulipe = new Tulipe("tulipe", 140, TypeTaille.S);
						z.addVivant(bouleau);
						z.addVivant(tulipe);
						bouleau.setZone(z);
						tulipe.setZone(z);
					}
				}

				// Ajouter Animaux
				if (l.placerProie()) {
					for (int k = 0 ; k < 1 ; k++) {
						Lapin lapin = new Lapin("lapin", 1, TypeTaille.M);
						z.addVivant(lapin);
						lapin.setZone(z);
					}
				}
				if (l.placerPredateur()) {
					for (int k = 0 ; k < 5 ; k++) {
						Loup loup = new Loup("loup", 1, TypeTaille.XL);
						z.addVivant(loup);
						loup.setZone(z);
					}
				}
			}
		}
	}

	public void initEcosysteme() {
		initZones();
		setPositionZones();
		try {
			setAdjacents();
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println(exception);
		}
		initVivants();
	}

	public void updateEcosysteme() {
		for (int i = 0; i < nb_zones_l; i++) {
			for (int j = 0; j < nb_zones_h; j++) {
				zones[i][j].updateZone();
			}
		}
	}


	@Override
	public String toString() {
		return "Ecosysteme [zones=" + Arrays.toString(zones) + ", nb_zones_l=" + nb_zones_l + ", nb_zones_h="
				+ nb_zones_h + "]";
	}
	
}
