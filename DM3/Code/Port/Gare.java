package Port;

public class Gare extends Port {
	public Gare(String id, String ville) {
		super(id, ville);
	}

	@Override
	public TypePort getType() {
		return TypePort.FERROVIAIRE;
	}
}
