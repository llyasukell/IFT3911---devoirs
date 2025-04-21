package Commande;

import App.App;
import Fabrique.FabriqueVoyage;
import Voyage.Voyage;

public class CreerVoyageCommande implements Commande {

	private Voyage voyage;
	private String id, depart, arrivee;

	public CreerVoyageCommande(String id, String depart, String arrivee) {
		this.id = id;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	@Override
	public void execute() {
		voyage = FabriqueVoyage.getFabrique().creerVoyage(id, depart, arrivee);
		App.getInstance().getBaseDeDonnees().ajouterVoyage(voyage);
		App.getInstance().notifier();
		System.out.println("Commande : voyage créé -> " + voyage);
	}

	@Override
	public void unexecute() {
		System.out.println("Commande annulée : voyage supprimé (simulé)");
		voyage = null; // pour simulation ; tu pourrais appeler App.supprimerVoyage() plus tard
	}
}
