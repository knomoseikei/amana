package pe.rmlabs.amana.domain;

public enum ColorConst implements Color{
	
	BLUE_LEVEL_1			("Blue Lvl 1","NoColor","color/color_blue1.png","<tooltip>"),
	BLUE_LEVEL_2			("Blue Lvl 2","NoColor", "color/color_blue2.png","<tooltip>"),
	BLUE_LEVEL_3			("Blue Lvl 3","NoColor","color/color_blue3.png","<tooltip>"),
	BLUE_LEVEL_4			("Blue Lvl 4","NoColor","color/color_blue4.png","<tooltip>"),
	RED_LEVEL_1				("Red Lvl 1","NoColor","color/color_red1.png","<tooltip>"),
	RED_LEVEL_2				("Red Lvl 2","NoColor","color/color_red2.png","<tooltip>"),
	RED_LEVEL_3				("Red Lvl 3","NoColor","color/color_red3.png","<tooltip>"),
	RED_LEVEL_4				("Red Lvl 4","NoColor","color/color_red4.png","<tooltip>"),
	GREEN_LEVEL_1			("Green Lvl 1","NoColor","color/color_green1.png","<tooltip>"),
	GREEN_LEVEL_2			("Green Lvl 2","NoColor","color/color_green2.png","<tooltip>"),
	GREEN_LEVEL_3			("Green Lvl 3","NoColor","color/color_green3.png","<tooltip>"),
	GREEN_LEVEL_4			("Green Lvl 4","NoColor","color/color_green4.png","<tooltip>"),
	YELLOW_LEVEL_1			("Yellow Lvl 1","NoColor","color/color_yellow1.png","<tooltip>"),
	YELLOW_LEVEL_2			("Yellow Lvl 2","NoColor","color/color_yellow2.png","<tooltip>"),
	YELLOW_LEVEL_3			("Yellow Lvl 3","NoColor","color/color_yellow3.png","<tooltip>"),
	YELLOW_LEVEL_4			("Yellow Lvl 4","NoColor","color/color_yellow4.png","<tooltip>"),
	UNKNOWN					("", "", "new-thumb.png", "");
	
	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private ColorConst(String gameName, String codeName, String image, String tooltip) {
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
