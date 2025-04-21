package Port;

public abstract class Port {

	private String id;
	private String ville;

	public Port(String id, String ville) {
		this.id = id;
		this.ville = ville;
	}

	public String getId() {
		return id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return id + " (" + ville + ")";
	}

	
	public abstract TypePort getType();

	public enum TypePort {
		AERIEN, FERROVIAIRE, MARITIME
	}
}
