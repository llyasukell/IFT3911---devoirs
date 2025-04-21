package Port;

public class Aeroport extends Port {
	public Aeroport(String id, String ville) {
		super(id, ville);
	}

	@Override
	public TypePort getType() {
		return TypePort.AERIEN;
	}
}