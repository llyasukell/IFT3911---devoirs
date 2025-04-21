package Fabrique;

import Voyage.Vol;
import Port.Aeroport;
import Port.Port;
import Vehicule.Avion;
import Vehicule.Vehicule;

import java.util.Date;

import App.App;
import Compagnie.Compagnie;
import Compagnie.CompagnieAerienne;
import Voyage.Voyage;

public class FabriqueAerienne extends FabriqueVoyage {

	@Override
	protected Voyage fabriquerVoyage(String id, String codeDepart, String codeArrivee) {
	    Port depart = App.getInstance().getBaseDeDonnees().rechercherPort(codeDepart);
	    Port arrivee = App.getInstance().getBaseDeDonnees().rechercherPort(codeArrivee);

	    if (!(depart instanceof Aeroport) || !(arrivee instanceof Aeroport)) {
	        System.out.println("❌ Les ports doivent être de type AÉROPORT pour un vol.");
	        return null;
	    }

	    Date maintenant = new Date();
	    Port[] ports = new Port[] { depart, arrivee };

	    return new Vol(id, maintenant, maintenant, ports);
	}


	@Override
	protected Port fabriquerPort(String code, String ville) {
		return new Aeroport(code, ville);
	}

	@Override
	protected Compagnie fabriquerCompagnie(String nom, String code) {
		return new CompagnieAerienne(nom, code);
	}

	@Override
	public Vehicule creerVehicule() {
		return new Avion(); //
	}
}
