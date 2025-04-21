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
	protected Voyage fabriquerVoyage(String id, String codeDepart, String codeArrivee) {
	    Port depart = App.getInstance().getBaseDeDonnees().rechercherPort(codeDepart);
	    Port arrivee = App.getInstance().getBaseDeDonnees().rechercherPort(codeArrivee);

	    if (!(depart instanceof PortNaval) || !(arrivee instanceof PortNaval)) {
	        System.out.println(" Les ports doivent être de type MARITIME pour un itinéraire naval.");
	        return null;
	    }

	    Date maintenant = new Date();
	    Port[] ports = new Port[] { depart, arrivee };

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
