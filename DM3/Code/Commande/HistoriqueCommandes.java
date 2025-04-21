package Commande;

import java.util.Stack;

public class HistoriqueCommandes {

	private Stack<Commande> historique = new Stack<>();

	// Exécute la commande et l’ajoute à l’historique
	public void executerCommande(Commande c) {
		c.execute();
		historique.push(c);
	}

	// Annule la dernière commande
	public void annulerDerniereCommande() {
		if (!historique.isEmpty()) {
			Commande c = historique.pop();
			c.unexecute();
		}
	}
}