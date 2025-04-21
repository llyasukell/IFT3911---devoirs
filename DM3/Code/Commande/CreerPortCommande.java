package Commande;

import App.App;
import Fabrique.FabriqueVoyage;
import Port.Port;

public class CreerPortCommande implements Commande {

	private Port port;
	private String code;
	private String ville;

	public CreerPortCommande(String code, String ville) {
		this.code = code;
		this.ville = ville;
	}

	@Override
	public void execute() {
		
		port = FabriqueVoyage.getFabrique().creerPort(code, ville);
		App.getInstance().getBaseDeDonnees().ajouterPort(port);
		App.getInstance().notifier();
		System.out.println("Commande : port créé -> " + port);
	}

	@Override
	public void unexecute() {
		System.out.println("Commande annulée : port supprimé (simulé)");
		port = null;
	}
}
