package Commande;

import App.App;
import Compagnie.Compagnie;
import Fabrique.FabriqueVoyage;

public class CreerCompagnieCommande implements Commande {

	private Compagnie compagnie;
	private String nom;
	private String code;

	
	public CreerCompagnieCommande(String nom, String code) {
		this.nom = nom;
		this.code = code;
	}

	@Override
	public void execute() {
		compagnie = FabriqueVoyage.getFabrique().creerCompagnie(nom, code);
		App.getInstance().getBaseDeDonnees().ajouterCompagnie(compagnie);
		App.getInstance().notifier();
		System.out.println("Commande : compagnie créée -> " + compagnie);
	}

	@Override
	public void unexecute() {
		System.out.println("Commande annulée : compagnie supprimée (simulée)");
		compagnie = null;
	}
}
