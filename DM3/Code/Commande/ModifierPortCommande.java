package Commande;

import App.*;
import Port.*;
import enums.State;

public class ModifierPortCommande implements Commande {
	private Port port;
	private State modification;
	private String ancienneVille;

	public ModifierPortCommande(Port port, State s) {
		this.port = port;
		this.modification = s;
		this.ancienneVille = port.getVille();
	}

	@Override
	public void execute() {
		App.getInstance().getVueAdmin().modifierPort(port, modification);
		App.getInstance().notifier();
	}

	@Override
	public void unexecute() {
		if (modification == State.VILLE) {
			port.setVille(ancienneVille);
			System.out.println("✔️ Ville restaurée.");
		}
	}
}
