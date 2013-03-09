package pe.rmlabs.amana.domain;

public enum GameMapConst implements GameMap{
	
	CAPTURE_A("Capture A", "C_CaptureA", "map/map_capturea.png", "<tooltip>"),
	CAPTURE_B("Capture B", "C_CaptureB", "map/map_captureb.png", "<tooltip>"),
	CHASM("Chasm", "Chasm", "map/map_chasm.png", "<tooltip>"),
	DUEL("Duel", "Duel", "map/map_duel.png", "<tooltip>"),
	LASTSTAND("Last Stand", "LastStand", "map/map_laststand.png", "<tooltip>"),
	NESTHORN("Nesthorn", "Nesthorn", "map/map_nesthorn.png", "<tooltip>"),
	SANDRIM("Sandrim", "Sandrim", "map/map_sandrim.png", "<tooltip>"),
	SIMPLE("Simple", "Simple", "map/map_simple.png", "<tooltip>"),
	SPIRAL("Spiral", "Spiral", "map/map_spiral.png", "<tooltip>"),
	SURVIVAL("Survival", "Survival", "map/map_survival.png", "<tooltip>"),
	THAR("Thar", "Thar", "map/map_sandrim.png", "<tooltip>"),
	TWINPEAKS("Twin Peaks", "TwinPeaks", "map/map_twinpeaks.png", "<tooltip>"),
	VALE("Vale", "Vale", "map/map_vale.png", "<tooltip>"),
	UNKNOWN("","","new-tag.png", "");

	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private GameMapConst(String gameName, String codeName, String image, String tooltip) {
		this.gameName = gameName;
		this.codeName = codeName;
		this.image = image;
		this.tooltip = tooltip;
	}

	@Override
	public String getGameName() {
		return gameName;
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
