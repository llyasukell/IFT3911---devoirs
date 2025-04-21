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
	    Port depart = App.getInstance().getBaseDeDonnees().rechercherPort(codeDepart);
	    Port arrivee = App.getInstance().getBaseDeDonnees().rechercherPort(codeArrivee);

	    if (!(depart instanceof Gare) || !(arrivee instanceof Gare)) {
	        System.out.println("❌ Les ports doivent être de type GARE pour un trajet ferroviaire.");
	        return null;
	    }

	    Date maintenant = new Date();
	    Port[] ports = new Port[] { depart, arrivee };

	    return new Trajet(id, maintenant, maintenant, ports);
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
