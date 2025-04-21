package Compagnie;

public class Compagnie {

	private String code;
	private String nom;
	private float pleinTarif;

	public Compagnie(String nom, String code) {
		this.nom = nom;
		this.code = code;
		this.pleinTarif = 100.0f;
	}

	// Getters
	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public float getPleinTarif() {
		return pleinTarif;
	}

	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPleinTarif(float pleinTarif) {
		this.pleinTarif = pleinTarif;
	}

	@Override
	public String toString() {
		return code + " - " + nom;
	}
}
