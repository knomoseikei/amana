package pe.rmlabs.amana.domain;

public class ColorNew implements Color {

	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	public ColorNew(String gameName, String codeName, String image, String tooltip) {
		super();
		this.gameName = gameName;
		this.codeName = codeName;
		this.image = image;
		this.tooltip = tooltip;
	}

	@Override
	public String getGameName() {
		return "**"+gameName;
	}

	@Override
	public String getCodeName() {
		return codeName;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public String getTooltip() {
		return tooltip;
	}

}
