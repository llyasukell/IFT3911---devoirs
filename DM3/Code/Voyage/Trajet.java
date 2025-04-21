package Voyage;

import java.util.Date;

import Compagnie.*;
import Port.Port;

public class Trajet extends Voyage {

	public Trajet(String id, Date depart, Date arrivee, Port[] ports) {
		super(id, depart, arrivee, ports);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cloner() {
		// TODO Auto-generated method stub
		
	}

	
}