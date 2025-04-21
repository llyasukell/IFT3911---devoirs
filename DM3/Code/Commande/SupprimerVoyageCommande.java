package Commande;

import App.App;
import Voyage.Voyage;

public class SupprimerVoyageCommande implements Commande {
	private String id;
	private Voyage supprimé;

	public SupprimerVoyageCommande(String id) {
		this.id = id;
	}

	@Override
	public void execute() {
		supprimé = App.getInstance().getBaseDeDonnees().getVoyages()
			.stream()
			.filter(v -> v.getId().equalsIgnoreCase(id))
			.findFirst()
			.orElse(null);

		if (supprimé != null) {
			App.getInstance().getBaseDeDonnees().getVoyages().remove(supprimé);
			App.getInstance().notifier();
			System.out.println("Commande : voyage " + id + " supprimé.");
		} else {
			System.out.println("Erreur : voyage " + id + " introuvable.");
		}
	}

	@Override
	public void unexecute() {
		if (supprimé != null) {
			App.getInstance().getBaseDeDonnees().ajouterVoyage(supprimé);
			System.out.println("Commande annulée : voyage " + id + " restauré.");
		}
	}
}
