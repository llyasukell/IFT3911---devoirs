package Voyage;

import java.util.Date;

import Decorateur.*;
import Prototype.*;
import Port.*;
import Vehicule.*;
import Visiteur.IVisitable;
import Visiteur.Visiteur;

public abstract class Voyage extends DecorateurRabais implements Prototype, IVisitable {


	private String id;
	private Date depart;
	private Date arrivee;
	private Port[] ports;
	private Vehicule vehicule;

	// Constructeur
	public Voyage(String id, Date depart, Date arrivee, Port[] ports) {
		this.id = id;
		this.depart = depart;
		this.arrivee = arrivee;
		this.ports = ports;
	}

	// Méthodes de base
	public String getId() {
		return id;
	}

	public Date getDepart() {
		return depart;
	}

	public Date getArrivee() {
		return arrivee;
	}

	public Port[] getPorts() {
		return ports;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public void setArrivee(Date arrivee) {
		this.arrivee = arrivee;
	}


	@Override
	public String toString() {
		return id + " | Départ : " + depart + " | Arrivée : " + arrivee;
	}

	@Override
	public void accept(Visiteur v) {
		System.out.println(v.consulterVoyage(this));
	}
	
	
	
}
