package Fabrique;

import java.util.Date;

import App.App;
import Compagnie.Compagnie;
import Compagnie.CompagnieFerroviaire;
import Port.Gare;
import Port.Port;
import Voyage.Trajet;
import Voyage.Voyage;
import Vehicule.Train;
import Vehicule.Vehicule;

public class FabriqueFerroviaire extends FabriqueVoyage {

	@Override
	protected Voyage fabriquerVoyage(String id, String codeDepart, String codeArrivee) {
		// Cherche les ports existants dans la BD
		Port gareDepart = App.getInstance().getBaseDeDonnees().rechercherPort(codeDepart);
		Port gareArrivee = App.getInstance().getBaseDeDonnees().rechercherPort(codeArrivee);

		if (gareDepart == null || gareArrivee == null) {
			System.out.println("❌ Port de départ ou d'arrivée introuvable !");
			return null;
		}

		Port[] gares = new Port[] { gareDepart, gareArrivee };
		Date maintenant = new Date();

		return new Trajet(id, maintenant, maintenant, gares);
	}

	@Override
	protected Port fabriquerPort(String code, String ville) {
	    return new Gare(code, ville);
	}

	@Override
	protected Compagnie fabriquerCompagnie(String nom, String code) {
		return new CompagnieFerroviaire(nom, code);
	}

	@Override
	public Vehicule creerVehicule() {
		return new Train(); // ou new Train("TGV", 300);
	}
}
