package Commande;

import App.App;
import Compagnie.Compagnie;

public class AssignerPrixCommande implements Commande {

	private Compagnie compagnie;
	private float ancienPrix;
	private float nouveauPrix;

	public AssignerPrixCommande(Compagnie compagnie, float nouveauPrix) {
		this.compagnie = compagnie;
		this.nouveauPrix = nouveauPrix;
		this.ancienPrix = compagnie.getPleinTarif(); // sauvegarde pour undo
	}

	@Override
	public void execute() {
		compagnie.setPleinTarif(nouveauPrix);
		System.out.println(" Tarif assigné à " + nouveauPrix + " pour " + compagnie.getCode());
		App.getInstance().notifier();
	}

	@Override
	public void unexecute() {
		compagnie.setPleinTarif(ancienPrix);
		System.out.println(" Tarif restauré à " + ancienPrix + " pour " + compagnie.getCode());
		App.getInstance().notifier();
	}
}
