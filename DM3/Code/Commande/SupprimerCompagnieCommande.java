package Commande;

import App.App;
import Compagnie.Compagnie;

public class SupprimerCompagnieCommande implements Commande {
	private String code;
	private Compagnie supprimée; // pour unexecute

	public SupprimerCompagnieCommande(String code) {
		this.code = code;
	}

	@Override
	public void execute() {
		// Rechercher la compagnie par code
		supprimée = App.getInstance().getBaseDeDonnees().getCompagnies()
			.stream()
			.filter(c -> c.getCode().equalsIgnoreCase(code))
			.findFirst()
			.orElse(null);

		if (supprimée != null) {
			App.getInstance().getBaseDeDonnees().getCompagnies().remove(supprimée);
			System.out.println("Commande : compagnie " + code + " supprimée.");
		} else {
			System.out.println("Erreur : compagnie " + code + " introuvable.");
		}
	}

	@Override
	public void unexecute() {
		if (supprimée != null) {
			App.getInstance().getBaseDeDonnees().ajouterCompagnie(supprimée);
			System.out.println("Commande annulée : compagnie " + code + " restaurée.");
		}
	}
}
