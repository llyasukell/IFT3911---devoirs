package Port;

public class PortNaval extends Port {
	public PortNaval(String id, String ville) {
		super(id, ville);
	}

	@Override
	public TypePort getType() {
		return TypePort.MARITIME;
	}
}
