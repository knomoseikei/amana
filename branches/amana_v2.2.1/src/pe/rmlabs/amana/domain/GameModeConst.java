package pe.rmlabs.amana.domain;

public enum GameModeConst implements GameMode {

	PVP("PvP", "mode/mode_pvp.png", "<tooltip>"),
	COOP("Coop", "mode/mode_coop.png ", "<tooltip>"),
	CTF("CTF", "mode/mode_ctf.png", "<tooltip>"),
	SOLO("Solo","mode/mode_solo.png", "<tooltip>"),
	SURVIVAL("Survival", "mode/mode_survival.png", "<tooltip>"),
	CHALLENGE("Challenge", "mode/mode_challenge.png","<tooltip>"),
	UNKNOWN("","new-tag.png", "");

	private final String gameName;
	private final String image;
	private final String tooltip;

	private GameModeConst(String gameName, String image, String tooltip) {
		this.gameName = gameName;
		this.image = image;
		this.tooltip = tooltip;
	}

	@Override
	public String getGameName() {
		return gameName;
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
