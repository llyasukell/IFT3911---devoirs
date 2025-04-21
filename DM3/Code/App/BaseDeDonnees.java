package App;

import java.util.ArrayList;
import java.util.List;

import Voyage.Voyage;
import Compagnie.Compagnie;
import Port.Port;

public class BaseDeDonnees {

	private List<Voyage> voyages = new ArrayList<>();
	private List<Compagnie> compagnies = new ArrayList<>();
	private List<Port> ports = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();

	// Accesseurs
	public List<Voyage> getVoyages() {
		return voyages;
	}

	public List<Compagnie> getCompagnies() {
		return compagnies;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	// Méthodes pour ajouter
	public void ajouterVoyage(Voyage v) {
		voyages.add(v);
	}

	public void ajouterCompagnie(Compagnie c) {
		compagnies.add(c);
	}

	public void ajouterPort(Port p) {
		ports.add(p);
	}
	
	public Compagnie rechercherCompagnie(String code) {
		for (Compagnie c : compagnies) {
			if (c.getCode().equalsIgnoreCase(code)) return c;
		}
		return null;
	}

	public Port rechercherPort(String code) {
		for (Port p : ports) {
			if (p.getId().equalsIgnoreCase(code)) return p;
		}
		return null;
	}

	public Voyage rechercherVoyage(String id) {
		for (Voyage v : voyages) {
			if (v.getId().equalsIgnoreCase(id)) return v;
		}
		return null;
	}
	
	
	
	
}
