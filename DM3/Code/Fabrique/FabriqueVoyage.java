package Fabrique;

import App.App;
import Compagnie.Compagnie;
import Port.Port;
import Vehicule.Vehicule;
import Voyage.Voyage;

public abstract class FabriqueVoyage {

	private static FabriqueVoyage fabrique;

	// --- Singleton-like access ---
	public static FabriqueVoyage getFabrique() {
		if (fabrique == null) {
			throw new IllegalStateException(" Fabrique non initialisée !");
		}
		return fabrique;
	}

	public static void setFabrique(FabriqueVoyage f) {
		fabrique = f;
	}

	// === CREATION VOYAGE (avec vérif) ===
	public Voyage creerVoyage(String id, String codeDepart, String codeArrivee) {
		// Vérifie si le voyage existe déjà
		if (App.getInstance().getBaseDeDonnees().rechercherVoyage(id) != null) {
			System.out.println(" Voyage déjà existant !");
			return null;
		}
		// Délègue à la fabrique concrète
		Voyage v = fabriquerVoyage(id, codeDepart, codeArrivee);
		App.getInstance().getBaseDeDonnees().ajouterVoyage(v);
		return v;
	}

	// === CREATION PORT (avec vérif) ===
	public Port creerPort(String code, String ville) {
		if (App.getInstance().getBaseDeDonnees().rechercherPort(code) != null) {
			System.out.println(" Port déjà existant !");
			return null;
		}
		Port p = fabriquerPort(code, ville);
		App.getInstance().getBaseDeDonnees().ajouterPort(p);
		return p;
	}

	// === CREATION COMPAGNIE (avec vérif) ===
	public Compagnie creerCompagnie(String nom, String code) {
		if (App.getInstance().getBaseDeDonnees().rechercherCompagnie(code) != null) {
			System.out.println("❌ Compagnie déjà existante !");
			return null;
		}
		Compagnie c = fabriquerCompagnie(nom, code);
		App.getInstance().getBaseDeDonnees().ajouterCompagnie(c);
		return c;
	}

	
	protected abstract Voyage fabriquerVoyage(String id, String codeDepart, String codeArrivee);
	protected abstract Port fabriquerPort(String code, String ville);
	protected abstract Compagnie fabriquerCompagnie(String nom, String code);
	public abstract Vehicule creerVehicule(); 
}
