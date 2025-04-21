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
		
	}

	public void mainMenu() {
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
					this.tripMenu();
				}

				case 2 -> {
					this.reservationMenu();
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

	public void tripMenu() {
		List<Voyage> voyages = app.getBaseDeDonnees().getVoyages();
		for (Voyage v : voyages) {
			System.out.println(consulterVoyage(v));
		}

	}

	public void reservationMenu() {
		int option = 1;
		int choix;
		boolean quit = false;
		Scanner scanner = App.getScanner();		
		List<Reservation> reservations = app.getBaseDeDonnees().getReservations();
		for (Reservation r : reservations) {
			System.out.print(option);
			System.out.printf(" - %s\n", r.toString());
		}
		System.out.println("Choisissez une reservation à payer: ");

		while (!quit) {
			
		}

	}
	/**
	 * 
	 * @param v
	 */
	public String consulterVoyage(Voyage v) {
		return v.toString();
	}

	public String consulterReservations(Reservation r) {
		return r.toString();
	}

	/**
	 * 
	 * @param q
	 */
	public Reservation reserver(Quartier q) {
		if (q.estLibre()){
			q.reserver();
			return new Reservation(this.app.getClient(), q);
		} else {
			throw new Error("Ce siège n'est pas disponible");
		}
	}

	@Override
	public void update() {
		System.out.println("[CLIENT] Mise à jour reçue !");
	}

}