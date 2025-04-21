package App;

import java.util.List;

import Observateur.*;
import Visiteur.*;
import Voyage.*;
import Quartier.*;

public class VueClient implements Observateur, Visiteur {

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

	public void consulterAchats() {
		// TODO - implement VueClient.consulterAchats
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