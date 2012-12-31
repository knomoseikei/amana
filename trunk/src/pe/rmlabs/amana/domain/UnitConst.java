package pe.rmlabs.amana.domain;

public enum UnitConst implements Unit {

	AEGIS("Aegis", "Aegis", "unit/unit_aegis.png", "<tooltip>"),
	ARCHY("Archy", "Archy", "unit/unit_archy.png", "<tooltip>"),
	ARMADILLO("Armadillo", "Armadillo", "unit/unit_armadillo.png", "<tooltip>"),
	ARTY("Arty", "Arty", "unit/unit_arty.png", "<tooltip>"),
	BEARTRAP("Bear Trap", "BearTrap", "unit/unit_beartrap.png", "<tooltip>"),
	BERTHA("Bertha", "Bertha", "unit/unit_bertha.png", "<tooltip>"),
	BLASTER_GUARDIAN("Blaster Guardian", "GuardBlaster", "unit/unit_blasterguardian.png", "<tooltip>"),
	BOMBS("Bombs", "Bombs", "unit/unit_bombs.png", "<tooltip>"),
	BOXER("Boxer", "Boxer", "unit/unit_boxer.png", "<tooltip>"),
	BOOMER("Boomer", "Boomer", "unit/unit_boomer.png", "<tooltip>"),
	BOOSTER("Booster", "Booster", "unit/unit_booster.png", "<tooltip>"),
	LIBERTY_BOOSTER("\"Liberty\" Booster", "BoosterJuly4th", "unit/unit_libertybooster.png", "<tooltip>"),
	BOTSPAWNER("Bot Spawner", "BotSpawner", "unit/unit_botspawner.png", "<tooltip>"),
	BUCKY("Bucky", "Bucky", "unit/unit_bucky.png", "<tooltip>"),
	CREEPER("Minecraft Creeper", "Minecraft Creeper", "unit/unit_creeper.png", "<tooltip>"),
	FIXER("Fixer", "Fixer", "unit/unit_fixer.png", "<tooltip>"),
	FF2000("FF2000", "FF2000", "unit/unit_ff2000.png", "<tooltip>"),
	GATTY("Gatty", "Gatty", "unit/unit_gatty.png", "<tooltip>"),
	GEMINI("Gemini", "Gemini", "unit/unit_gemini.png", "<tooltip>"),
	GENERATOR("Generator", "Generator", "unit/unit_generator.png", "<tooltip>"),
	GOLIATH("Goliath", "Goliath", "unit/unit_goliath.png", "<tooltip>"),
	GRINDER("Grinder", "Grinder", "unit/unit_grinder.png", "<tooltip>"),
	HAAT("HAAT", "HAAT", "unit/unit_haat.png", "<tooltip>"),
	HEAVYMINE("Heavy Mine", "Heavy Mine", "unit/unit_heavymine.png", "<tooltip>"),
	HONEYPOT("Honeypot", "HoneyPot", "unit/unit_honeypot.png", "<tooltip>"),
	JACKAL("Jackal", "Jackal", "unit/unit_jackal.png", "<tooltip>"),
	LEVELER("Leveler", "Leveler", "unit/unit_leveler.png", "<tooltip>"),
	LIBERTY_BOMBS("\"Liberty\" Bombs", "BombsJuly4th", "unit/unit_libertybombs.png", "<tooltip>"),
	LIGHTMINE("Light Mine", "Light Mine", "unit/unit_lightmine.png", "<tooltip>"),
	LOCKBOX("Lockbox", "Lockbox", "unit/unit_lockbox.png", "<tooltip>"),
	LONGHORN("Longhorn", "Longhorn", "unit/unit_longhorn.png", "<tooltip>"),
	LUNCHBOX("Lunchbox", "Lunchbox", "unit/unit_lunchbox.png", "<tooltip>"),
	MONEYMAKER("Money Maker", "MoneyMaker", "unit/unit_moneymaker.png", "<tooltip>"),
	PATCHER("Patcher", "Patcher", "unit/unit_patcher.png", "<tooltip>"),
	PUMPKIN_BOMBS("\"Pumpkin\" Bombs", "BombsHalloween","unit/unit_pumpkinbombs.png", "<tooltip>"),
	PROBE("Probe", "Probe", "unit/unit_probe.png", "<tooltip>"),
	RADAR_GUARDIAN("Radar Guardian", "GuardRadar", "unit/unit_radarguardian.png", "<tooltip>"),
	RATCHET("Ratchet", "Ratchet", "unit/unit_ratchet.png", "<tooltip>"),
	REPAIR_GUARDIAN("Repair Guardian", "GuardRepair", "unit/unit_repairguardian.png", "<tooltip>"),
	RUNNER("Runner", "Runner", "unit/unit_runner.png", "<tooltip>"),
	SAFEBOX("Safebox", "Safebox", "unit/unit_safebox.png", "<tooltip>"),
	SAM("SAM", "SAM", "unit/unit_sam.png", "<tooltip>"),
	SEEKER("Seeker", "Seeker", "unit/unit_seeker.png", "<tooltip>"),
	SENTRY_TURRET("Sentry Turret", "TurretPortal", "unit/unit_sentryturret.png", "<tooltip>"),
	SERGEANT("Sergeant", "InfantrySargent", "unit/unit_sergeant.png", "<tooltip>"),
	SOLDIER("Soldier", "Soldier", "unit/unit_soldier.png", "<tooltip>"),
	STASISMINE("Stasis Mine", "Stasis", "unit/unit_stasismine.png", "<tooltip>"),
	T99("T99", "T99", "unit/unit_t99.png", "<tooltip>"),
	TANGO("Tango", "Tango", "unit/unit_tango.png", "<tooltip>"),
	TURTLE("Turtle", "Turtle", "unit/unit_turtle.png", "<tooltip>"),
	ULTIMATE_MONEYMAKER("Ultimate Money Maker", "Ultimate MoneyMaker", "unit/unit_ultimatemoneymaker.png", "<tooltip>"),
	ULTIMATE_BUCKY("Ultimate Bucky", "Ultimate Bucky", "unit/unit_ultimatebucky.png", "<tooltip>"),
	VAULTBOX("Vaultbox", "Vaultbox", "unit/unit_vaultbox.png", "<tooltip>"),
	ZIPPER("Zipper", "Zipper", "unit/unit_zipper.png", "<tooltip>");

	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;

	private UnitConst(String gameName, String codeName, String image, String tooltip) {
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
