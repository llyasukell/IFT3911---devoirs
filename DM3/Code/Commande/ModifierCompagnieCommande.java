package Commande;

import App.*;
import Compagnie.*;
import enums.State;


public class ModifierCompagnieCommande implements Commande {
	private Compagnie compagnie;
	private State typeModification;
	private String ancienNom;
	private float ancienTarif;

	public ModifierCompagnieCommande(Compagnie compagnie, State s) {
		this.compagnie = compagnie;
		this.typeModification = s;
		this.ancienNom = compagnie.getNom();
		this.ancienTarif = compagnie.getPleinTarif();
	}

	@Override
	public void execute() {
		App.getInstance().getVueAdmin().modifierCompagnie(compagnie, typeModification);
		App.getInstance().notifier();
	}

	@Override
	public void unexecute() {
		switch (typeModification) {
			case NOM -> compagnie.setNom(ancienNom);
			case PRIX -> compagnie.setPleinTarif(ancienTarif);
		}
		System.out.println(" Annulation : compagnie remise à son état précédent.");
	}
}
