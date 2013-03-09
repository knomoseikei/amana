package pe.rmlabs.amana.domain;

public class GameModeNew implements GameMode {
	
	private final String gameName;
	private final String image;
	private final String tooltip;
	
	public GameModeNew(String gameName, String image, String tooltip) {
		super();
		this.gameName = gameName;
		this.image = image;
		this.tooltip = tooltip;
	}

	@Override
	public String getGameName() {
		return "**"+gameName;
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
