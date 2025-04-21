package Commande;

import App.App;
import Port.Port;

public class SupprimerPortCommande implements Commande {
	private String code;
	private Port supprimé;

	public SupprimerPortCommande(String code) {
		this.code = code;
	}

	@Override
	public void execute() {
		supprimé = App.getInstance().getBaseDeDonnees().getPorts()
			.stream()
			.filter(p -> p.getId().equalsIgnoreCase(code))
			.findFirst()
			.orElse(null);

		if (supprimé != null) {
			App.getInstance().getBaseDeDonnees().getPorts().remove(supprimé);
			App.getInstance().notifier();
			System.out.println("Commande : port " + code + " supprimé.");
		} else {
			System.out.println("Erreur : port " + code + " introuvable.");
		}
	}

	@Override
	public void unexecute() {
		if (supprimé != null) {
			App.getInstance().getBaseDeDonnees().ajouterPort(supprimé);
			System.out.println("Commande annulée : port " + code + " restauré.");
		}
	}
}
