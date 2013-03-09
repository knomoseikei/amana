package pe.rmlabs.amana.domain;


public enum PilotConst implements Pilot {
	
	NO_PILOT("No Pilot","NoPilot","pilot/pilot_nopilot.png","<tooltip>"),
	ALIEN("Alien","Alienware","pilot/pilot_alien.png","<tooltip>"),
	ANNARCHY("Annarchy","Annarchy","pilot/pilot_annarchy.png","<tooltip>"),
	ASHE("Ashe","Ashe","pilot/pilot_ashe.png","<tooltip>"),
	BEPPO("Beppo","Beppo","pilot/pilot_beppo.png","<tooltip>"),
	BILL_LEEB("Bill Leeb", "Bill", "pilot/pilot_bill.png", "<tooltip>"),
	BRENNA("Brenna","Brenna","pilot/pilot_brenna.png","<tooltip>"),
	CARL("Carl","Carl","pilot/pilot_carl.png","<tooltip>"),
	CHARLES("Charles","Charles","pilot/pilot_charles.png","<tooltip>"),
	CHIMNEYSWIFT("ChimneySwift","Chimneyswift","pilot/pilot_chimneyswift.png", "<tooltip>"),
	ERIK("Erik", "Erik","pilot/pilot_erik.png","<tooltip>"),
	GABE("Gabe","Gabe","pilot/pilot_gabe.png","<tooltip>"),
	GOH("Goh","Goh","pilot/pilot_goh.png","<tooltip>"),
	HAWK("Hawk","Hawk","pilot/pilot_hawk.png","<tooltip>"),
	HUSKY("Husky","Husky","pilot/pilot_husky.png","<tooltip>"),
	JARED_SLINGERLAND("Jared Slingerland", "Jared", "pilot/pilot_jared.png", "<tooltip>"),
	JAZON_BAZINET("Jason Bazinet", "Jason", "pilot/pilot_jason.png", "<tooltip>"),
	JEREMY_INKEL("Jeremy Inkel", "Jeremy", "pilot/pilot_jeremy.png", "<tooltip>"),
	JESUS("Jesus","Jesus","pilot/pilot_jesus.png","<tooltip>"),
	KARA("Kara","Kara","pilot/pilot_kara.png","<tooltip>"),
	KEN("Ken","Ken","pilot/pilot_ken.png","<tooltip>"),
	KIRA("Kira", "Kira","pilot/pilot_kira.png","<tooltip>"),
	LADY_GAIA("Lady Gaia","Gaia","pilot/pilot_ladygaia.png","<tooltip>"),
	LEXI("Lexi","Lexi","pilot/pilot_lexi.png","<tooltip>"),
	MAKO("Mako", "Mako","pilot/pilot_mako.png","<tooltip>"),
	NICHOLAI("Nicholai","Santa","pilot/pilot_nicholai.png","<tooltip>"),
	NATASHA("Natasha","Natasha","pilot/pilot_natasha.png","<tooltip>"),
	PETROS("Petros","Petros","pilot/pilot_petros.png","<tooltip>"),
	RAVEN("Raven","Raven","pilot/pilot_raven.png","<tooltip>"),
	SAMSON("Samson","Samson","pilot/pilot_samson.png","<tooltip>"),
	SCOUT_MASTER("Scout Master", "Scoutmaster","pilot/pilot_scoutmaster.png","<tooltip>"),
	TYCHO("Tycho","Tycho","pilot/pilot_tycho.png","<tooltip>"),
	ULTIMATE_ERIK("Ultimate Erik", "ErikU", "pilot/pilot_ultimateerik.png", "<tooltip>"),
	ULTIMATE_SAMSON("Ultimate Samson","SamsonU","pilot/pilot_ultimatesamson.png","<tooltip>");

	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private PilotConst(String gameName, String codeName, String image, String tooltip) {
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
