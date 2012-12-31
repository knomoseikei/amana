package pe.rmlabs.amana.domain;

public enum FlairConst implements Flair {
	
	AIRMECH_COOKIE			("AirMech Cookie","XmasCookie1","flair/flair_airmechcookie.png","<tooltip>"),
	BALD_EAGLE_PET			("Bald Eagle Pet","","flair/flair_baldeaglepet.png","<tooltip>"),
	BRONZE_MEDAL			("Bronze Medal","MedalBronze","flair/flair_bronzemedal.png","<tooltip>"),
	CANARY_BIRD				("Canary Bird","PetCanaryBird","flair/flair_canarybird.png","<tooltip>"),
	CARDINAL_BIRD			("Cardinal Bird","PetCardinalBird","flair/flair_cardinalbird.png","<tooltip>"),
	COMPANION_CUBE			("Companion Cube","CCube","flair/flair_companioncube.png","<tooltip>"),
	COMPETITORS_BADGE		("Competitors Badge","TournamentBadge","flair/flair_competitorsbadge.png","<tooltip>"),
	CYAN_CONTRAILS			("Cyan Contrails","CCCyan","flair/flair_cyancontrails.png","<tooltip>"),
	CYAN_TRACERS			("Cyan Tracers","SCCyan","flair/flair_flamingtorch.png","<tooltip>"),
	FEATHER_HEADDRESS		("Feather Headdress","HatHeaddress","known.png","<tooltip>"),
	FLAMING_TORCH			("Flaming Torch","OTorch","flair/flair_flamingtorch.png","<tooltip>"),
	GHOST_BUDDY				("Ghost Buddy","PetGhost1","flair/flair_goldmedal.png","<tooltip>"),
	GOLD_MEDAL				("Gold Medal","MedalGold","flair/flair_googleio2012.png","<tooltip>"),
	GOOGLE_IO_2012			("Google IO 2012","GoogleIO","flair/flair_greencontrails.png","<tooltip>"),
	GREEN_CANDYCANE			("Green Candycane","XmasCandyCane2","flair/flair_airmechcookie.png","<tooltip>"),
	GREEN_CONTRAILS			("Green Contrails","CCGreen","flair/flair_greencontrails.png","<tooltip>"),
	GREEN_ORNAMENT			("Green Ornament","XmasOrnament3","flair/flair_greenornament.png","<tooltip>"),
	GREEN_TRACERS			("Green Tracers","SCGreen","flair/flair_greentracers.png","<tooltip>"),
	HUSKY_PUP				("Husky Pup","JetpackHusky","flair/flair_huskypup.png","<tooltip>"),
	JACK_O_LANTERN			("Jack-o'-Lantern","PetPumpkin1","flair/flair_jackolantern.png","<tooltip>"),
	JETPACK_CAT				("Jetpack Cat","JetpackCat","flair/flair_jetpackcat.png","<tooltip>"),
	LARRY					("Larry","PetTwitterBird","flair/flair_larry.png","<tooltip>"),
	LOLIPOP					("Lolipop","XmasCandyCane3","flair/flair_lolipop.png","<tooltip>"),
	MAGENTA_CONTRAILS		("Magenta Contrails","CCMagenta","flair/flair_magentacontrails.png","<tooltip>"),
	MAGENTA_TRACERS			("Magenta Tracers","SCMagenta","flair/flair_magentatracers.png","<tooltip>"),
	MISSILE_PARTY_STREAMERS	("Missile Party Streamers","MTParty","flair/flair_missilepartystreamers.png","<tooltip>"),
	MOON_RABBIT				("Moon Rabbit","MoonRabbit","flair/flair_moonrabit.png","<tooltip>"),
	NO_FLAIR				("No Flair","NoFlair","flair/flair_noflair.png","<tooltip>"),
	ONE_BALL				("One Ball","PoolB1","flair/flair_oneball.png","<tooltip>"),
	ORANGE_ORNAMENT			("Orange Ornament","XmasOrnament2","flair/flair_orangeornament.png","<tooltip>"),
	PILGRIMS_HAT			("Pilgrim's Hat","HatPilgrim","flair/flair_pilgrimshat.png","<tooltip>"),
	PINK_ORNAMENT			("Pink Ornament","XmasOrnament1","flair/flair_pinkornament.png","<tooltip>"),
	RED_CANDYCANE			("Red Candycane","XmasCandyCane1","flair/flair_redcandycane.png","<tooltip>"),
	RED_CONTRAILS			("Red Contrails","CCRed","flair/flair_redcontrails.png","<tooltip>"),
	RED_TRACERS				("Red Tracers","SCRed","flair/flair_redtracers.png","<tooltip>"),
	REINDEER				("Reindeer","XmasReindeer","flair/flair_reindeer.png","<tooltip>"),
	SANTA_HAT				("Santa Hat","HatSanta","flair/flair_santahat.png","<tooltip>"),
	SILVER_MEDAL			("Silver Medal","MedalSilver","flair/flair_silvermedal.png","<tooltip>"),
	SNOWMAN					("Snowman","XmasSnowman","flair/flair_snowman.png","<tooltip>"),
	SUGAR_COOKIE			("Sugar Cookie","XmasCookie3","flair/flair_sugarcookie.png","<tooltip>"),
	THE_MERCH				("The Merch","Merch","flair/flair_themerch.png","<tooltip>"),
	TOY_ANGEL				("Toy Angel","XmasAngel","flair/flair_toyangel.png","<tooltip>"),
	TREE_COOKIE				("Tree Cookie","XmasCookie2","flair/flair_treecookie.png","<tooltip>"),
	TWO_BALL				("Two Ball","PoolB2","flair/flair_twoball.png","<tooltip>"),
	VAMPIRE_BAT				("Vampire Bat","PetBat1","flair/flair_vampirebat.png","<tooltip>"),
	WHITE_DONUT				("White Donut","Donut3","flair/flair_whitedonut.png","<tooltip>"),
	WILD_TURKEY				("Wild Turkey", "PetTurkey1", "flair/flair_wildturkey.png", "<tooltip>");
	
	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private FlairConst(String gameName, String codeName, String image, String tooltip) {
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
