package pe.rmlabs.amana.domain;

public enum MechConst implements Mech {
	
	BOMBER_BETA("\"Beta\" Bomber", "Stealth_Beta", "am/am_betabomber.png", "<tooltip>"),
	BOMBER_BLACKOPS("\"BlackOps\" Bomber", "Stealth_BlackOps",	"am/am_blackopsbomber.png", "<tooltip>"),
	BOMBER("\"Bomber\"","Stealth","am/am_bomber.png","<tooltip>"),
	BOMBER_GREENSEA("\"GreenSea\" Bomber","Stealth_GreenSea","am/am_greenseabomber.png","<tooltip>"),
	BOMBER_PHANTOM("\"Phantom\" Bomber","Stealth_Phantom","am/am_phantombomber.png","<tooltip>"),
	BOMBER_STEAMPUNK("\"Steampunk\" Bomber", "Stealth_Steam", "am/am_steampunkbomber.png", "<tooltip>"),
	CHOPPER_APACHE("\"Apache\" Chopper","Chopper_Commando","am/am_apachechopper.png","<tooltip>"),
	CHOPPER("Chopper","Chopper","am/am_chopper.png","<tooltip>"),
	CHOPPER_SHARK("\"Shark\" Chopper","Chopper_Shark","am/am_sharkchopper.png","<tooltip>"),
	CHOPPER_STEAMPUNK("\"Steampunk\" Chooper", "Chopper_Steam", "am/am_steampunkchopper.png","<tooltip>"),
	NEO("Neo","FighterNeo","am/am_neo.png","<tooltip>"),
	NEO_SHARK("\"Shark\" Neo","FighterNeo_Shark","am/am_sharkneo.png","<tooltip>"),
	NEO_STAR("\"Star\" Neo","FighterNeo_Star","am/am_starneo.png","<tooltip>"),
	OSPREY_EASTER("\"Easter\" Osprey","Osprey_Easter","am/am_easterosprey.png","<tooltip>"),
	OSPREY("Osprey", "Osprey","am/am_osprey.png","<tooltip>"),
	OSPREY_DEEPSEA("\"DeepSea\" Osprey", "Osprey_DeepSea", "am/am_deepseaosprey.png", "<tooltip>"),
	OSPREY_MEDIC("\"Medic\" Osprey", "Osprey_Medic", "am/am_medicosprey.png","<tooltip>"),
	OSPREY_NVISION("\"N-Vision\" Osprey","Osprey_NVision","am/am_nvisionosprey.png","<tooltip>"),
	OSPREY_STEAMPUNK("\"Steampunk\" Osprey", "Osprey_Steam", "am/am_steampunkosprey.png", "<tooltip>"),
	SAUCER_ALIEN("\"Alien\" Saucer", "Saucer_Alien","am/am_aliensaucer.png","<tooltip>"),
	SAUCER_BLACKOPS("\"BlackOps\" Saucer","Saucer_BlackOps","am/am_blackopssaucer.png","<tooltip>"),
	SAUCER_CHROME("\"Chrome\" Saucer","Saucer_Chrome","am/am_chromesaucer.png","<tooltip>"),
	SAUCER_PUMPKIN("\"Pumpkin\" Saucer", "Saucer_Pumpkin", "am/am_pumpkinsaucer.png", "<tooltip>"),
	SAUCER_NEXUS("\"Nexus\" Saucer", "Saucer_Nexus", "am/am_nexussaucer.png", "<tooltip>"),
	SAUCER("Saucer","Saucer","am/am_saucer.png","<tooltip>"),
	STRIKER_ALPHA("\"Alpha\" Striker","FighterA_Alpha","am/am_alphastriker.png","<tooltip>"),
	STRIKER_BLACKOPS("\"BlackOps\" Striker","FighterA_BlackOps","am/am_blackopsstriker.png","<tooltip>"),
	STRIKER("Striker","FighterA" , "am/am_striker.png","<tooltip>"),
	STRIKER_TOMCAT("\"Tomcat\" Striker","FighterA_Tomcat","am/am_tomcatstriker.png","<tooltip>"),
	STRIKER_STEAMPUNK("\"Steampunk\" Striker","FighterA_Steam","am/am_steampunkstriker.png","<tooltip>"),
	WARTHOG("Warthog", "Warthog","am/am_warthog.png","<tooltip>"),
	WARTHOG_PIRATE("\"Pirate\" Warthog","Warthog_Pirate","am/am_piratewarthog.png","<tooltip>"),
	WARTHOG_FLA("\"FLA\" Warthog", "Warthog_FLA", "am/am_flawarthog.png", "<tooltip>"),
	WARTHOG_GOTHIC("\"Gothic\" Warthog", "Warthog_Goth", "am/am_gothicwarthog.png", "<tooltip>");
	
	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private MechConst(String gameName, String codeName, String image, String tooltip) {
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
