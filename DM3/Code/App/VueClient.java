package App;

import java.util.*;

import Observateur.*;
import Visiteur.*;
import Voyage.*;
import Quartier.*;

public class VueClient implements Observateur, Visiteur {

	private App app;

	public VueClient(App app){
		this.app = app;
	}

	public void runCLI() {
		boolean quit = false;

		while (!quit){
			int choix;
			Scanner scanner = App.getScanner();
			System.out.println("\n[Menu Client]");
			System.out.println("1 - Consulter voyages");
			System.out.println("2 - Consulter réservations");
			System.out.println("3 - Quitter");
			System.out.println("Choixe : ");
			choix = scanner.nextInt();
	
			switch (choix) {
				//db.getVoyages() will become query-able for types, dates, prices...
				case 1 -> {
					List<Voyage> voyages = app.getBaseDeDonnees().getVoyages();
					for (Voyage v : voyages) {
						System.out.println(consulterVoyage(v));
					}
				}
				case 2 -> {
					List<Reservation> reservations = app.getBaseDeDonnees().getReservations();
					for (Reservation r : reservations) {
						System.out.println(r);
					}
				}
				
				case 3 -> {
					quit = true;
				}
				default -> {
					System.out.println("Choisissez une option valide");
				}
			}
		}
		



	}

	/**
	 * 
	 * @param v
	 */
	public String consulterVoyage(Voyage v) {
		// TODO - implement VueClient.consulterVoyage
		return "";
	}

	public List<Reservation> consulterReservations() {
		// TODO - implement VueClient.consulterReservations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param q
	 */
	public Reservation reserver(Quartier q) {
		// TODO - implement VueClient.reserver
		throw new UnsupportedOperationException();
	}

	@Override
	public void update() {
		System.out.println("[CLIENT] Mise à jour reçue !");
	}

}