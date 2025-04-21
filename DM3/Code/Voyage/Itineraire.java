package Voyage;

import java.util.Date;

import Compagnie.*;
import Port.Port;

public class Itineraire extends Voyage {

	

		public Itineraire(String id, Date depart, Date arrivee, Port[] ports) {
			super(id, depart, arrivee, ports);
		}

		@Override
		public void cloner() {
			// TODO Auto-generated method stub
			
		}
	}