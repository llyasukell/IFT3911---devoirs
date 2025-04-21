package App;

import java.util.Date;

import Visiteur.*;

public class Reservation implements IVisitable {

	private Integer id;
	private Boolean confirmee;
	private Date date;

	public Paiement payer() {
		// TODO - implement Reservation.payer
		throw new UnsupportedOperationException();
	}

	public Boolean estExpiree() {
		// TODO - implement Reservation.estExpiree
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visiteur v) {
		// TODO Auto-generated method stub
		
	}

}