package App;

import Observateur.*;
import Visiteur.*;
import Voyage.*;
import enums.State;
import Compagnie.*;
import Port.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VueAdmin implements Observateur, Visiteur {

	@Override
	public String consulterVoyage(Voyage v) {
		String id = v.getId();
		String depart = v.getPorts()[0].getId();
		String arrivee = v.getPorts()[1].getId();
		String type = v.getClass().getSimpleName();
		String dateDepart = v.getDepart().toString();
		String dateArrivee = v.getArrivee().toString();

		return "[ADMIN] " + type + " " + id + " : " + depart + " → " + arrivee + 
		       " | Départ : " + dateDepart + " | Arrivée : " + dateArrivee;
	}


	@Override
	public void update() {
		System.out.println("[ADMIN] Mise à jour reçue !");
	}

	public void modifierCompagnie(Compagnie c, State s) {
		Scanner scanner = App.getScanner();

		switch (s) {
			case NOM -> {
				System.out.print("Nouveau nom pour la compagnie " + c.getCode() + " : ");
				String nouveauNom = scanner.nextLine();
				c.setNom(nouveauNom);
				System.out.println("✔️ Nom mis à jour !");
			}
			case PRIX -> {
				System.out.print("Nouveau plein tarif pour la compagnie " + c.getCode() + " : ");
				float nouveauPrix = scanner.nextFloat();
				scanner.nextLine();
				c.setPleinTarif(nouveauPrix);
				System.out.println("✔️ Prix mis à jour !");
			}
			default -> System.out.println("❌ Type de modification non supporté.");
		}
	}

	public void modifierPort(Port p, State s) {
		Scanner scanner = App.getScanner();
		if (s == State.VILLE) {
			System.out.print("Nouvelle ville pour le port " + p.getId() + " : ");
			String ville = scanner.nextLine();
			p.setVille(ville);
			System.out.println("✔️ Ville mise à jour !");
		} else {
			System.out.println("❌ Modification non supportée.");
		}
	}

	public void modifierVoyage(Voyage v, State s) {
		Scanner scanner = App.getScanner();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			switch (s) {
				case DEPART -> {
					System.out.print("Nouvelle date de départ (format: yyyy-MM-dd HH:mm) : ");
					String input = scanner.nextLine();
					v.setDepart(format.parse(input));
					System.out.println("✔️ Date de départ mise à jour !");
				}

				case ARRIVEE -> {
					System.out.print("Nouvelle date d’arrivée (format: yyyy-MM-dd HH:mm) : ");
					String input = scanner.nextLine();
					v.setArrivee(format.parse(input));
					System.out.println("✔️ Date d’arrivée mise à jour !");
				}

				default -> System.out.println("❌ Modification non supportée.");
			}
		} catch (ParseException e) {
			System.out.println("❌ Format de date invalide !");
		}
	}


	public void supprimerCompagnie(Compagnie c) {
		App.getInstance().getBaseDeDonnees().getCompagnies().remove(c);
		System.out.println("✔️ Compagnie supprimée.");
	}

	public void supprimerPort(Port p) {
		App.getInstance().getBaseDeDonnees().getPorts().remove(p);
		System.out.println("✔️ Port supprimé.");
	}

	public void supprimerVoyage(Voyage v) {
		App.getInstance().getBaseDeDonnees().getVoyages().remove(v);
		System.out.println("✔️ Voyage supprimé.");
	}

	public void assignerPrix(Compagnie c) {
		Scanner scanner = App.getScanner();
		System.out.print("Plein tarif à assigner à la compagnie " + c.getCode() + " : ");
		float tarif = scanner.nextFloat();
		scanner.nextLine();
		c.setPleinTarif(tarif);
		System.out.println("✔️ Plein tarif assigné !");
	}
}
