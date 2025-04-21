package Quartier;

import Etat.*;

public abstract class Quartier {

	private String id;
	private EtatQuartier etatActuel;

	/**
	 * 
	 * @param e
	 */
	public void setEtat(EtatQuartier e) {
		// TODO - implement Quartier.setEtat
		throw new UnsupportedOperationException();
	}

	public Boolean estLibre() {
		return this.etatActuel instanceof Libre ? true : false;
	}

	public void reserver() {
		// TODO - implement Quartier.reserver
		throw new UnsupportedOperationException();
	}

	public void liberer() {
		// TODO - implement Quartier.liberer
		throw new UnsupportedOperationException();
	}

	public void payer() {
		// TODO - implement Quartier.payer
		throw new UnsupportedOperationException();
	}

}