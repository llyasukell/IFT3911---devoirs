package Fabrique;

import java.util.Date;

import App.App;
import Compagnie.Compagnie;
import Compagnie.CompagnieNavale;
import Port.Port;
import Port.PortNaval;
import Voyage.Itineraire;
import Voyage.Voyage;
import Vehicule.Paquebot;
import Vehicule.Vehicule;

public class FabriqueNavale extends FabriqueVoyage {

	@Override
	protected Voyage fabriquerVoyage(String id, String departCode, String arriveeCode) {
		// Vérifie l'existence des ports
		Port portDepart = App.getInstance().getBaseDeDonnees().rechercherPort(departCode);
		Port portArrivee = App.getInstance().getBaseDeDonnees().rechercherPort(arriveeCode);

		if (portDepart == null || portArrivee == null) {
			System.out.println("❌ Port de départ ou d'arrivée introuvable !");
			return null;
		}

		Port[] ports = new Port[] { portDepart, portArrivee };
		Date maintenant = new Date();

		return new Itineraire(id, maintenant, maintenant, ports);
	}
	@Override
	protected Port fabriquerPort(String code, String ville) {
	    return new PortNaval(code, ville);
	}

	@Override
	protected Compagnie fabriquerCompagnie(String nom, String code) {
		return new CompagnieNavale(nom, code);
	}

	@Override
	public Vehicule creerVehicule() {
		return new Paquebot(); 
	}
}
