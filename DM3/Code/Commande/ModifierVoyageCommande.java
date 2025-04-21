package Commande;

import App.*;
import Voyage.*;
import enums.State;

import java.util.Date;

public class ModifierVoyageCommande implements Commande {
	private Voyage voyage;
	private State modification;
	private Date ancienneDate;

	public ModifierVoyageCommande(Voyage v, State s) {
		this.voyage = v;
		this.modification = s;
		this.ancienneDate = v.getDepart();
	}

	@Override
	public void execute() {
		App.getInstance().getVueAdmin().modifierVoyage(voyage, modification);
		App.getInstance().notifier();
	}

	@Override
	public void unexecute() {
		if (modification == State.DEPART) {
		    voyage.setDepart(ancienneDate);
		    System.out.println("✔️ Date de départ restaurée.");
		} else if (modification == State.ARRIVEE) {
		    voyage.setArrivee(ancienneDate);
		    System.out.println("✔️ Date d’arrivée restaurée.");
		}
	}
}
