package pe.rmlabs.amana.domain;

public enum ItemConst implements Item{
	
	NO_ITEM					("No Item","NoItem","item/item_noitem.png","No Item"),
	ATLAS					("Atlas","Atlas","item/item_atlas.png","<tooltip>"),
	CANDY_BUCKET			("Candy Bucket","HCandy","item/item_candybucket.png","<tooltip>"),
	CANNED_MEAT_PRODUCT		("Canned Meat Product","Canfood","item/item_cannedmeat.png","<tooltip>"),
	CHIMNEYS_TOOTH			("Chimney's Tooth","ChimTooth","item/item_swiftooth.png","<tooltip>"),
	CHOCOLATE_BUNNY			("Chocolate Bunny","EBunny","item/item_chocobunny.png","<tooltip>"),
	CLOVER					("Clover","Clover","item/item_clover.png","<tooltip>"),
	COLORED_EGG				("Colored Egg","EEgg1","item/item_egg.png","<tooltip>"),
	CONGEE					("Congee","Congee","item/item_congee.png","<tooltip>"),
	FESTIVE_PRESENT_1		("Festive Present #1","XMasPresent1","item/item_festivepresent1.png","<tooltip>"),
	FESTIVE_PRESENT_2		("Festive Present #2","XMasPresent2","item/item_festivepresent2.png","<tooltip>"),
	FESTIVE_PRESENT_3		("Festive Present #3","XMasPresent3","item/item_festivepresent3.png","<tooltip>"),
	FLUORESCENT_LIGHTBULB	("Fluorescent Lightbulb","Bulb","item/item_lightbulb.png","<tooltip>"),
	GRADUATION_CAP			("Graduation Cap","GradCap","item/item_graduationcap.png","<tooltip>"),
	HIGGS_BOSSON			("Higg's Bosson","Higgs","item/item_bosson.png","<tooltip>"),
	HOLIDAY_PUDDING			("Holiday Pudding","XmasPudding","item/item_holidaypudding.png","<tooltip>"),
	PORTAL_CAKE				("Portal Cake", "PortalCake", "item/item_portalcake.png", "<tooltip>"),
	PUMPKIN_PIE				("Pumpkin Pie","PumpkinPie", "item/item_pumpkinpie.png", "<tooltip>"),
	RED_CHARM_BRACELET		("Red Charm Bracelet","RBracelet","item/item_redcharmbracelet.png","<tooltip>"),
	REPAIR_BOT				("Repair Bot","RepairBot","item/item_repairrobot.png","<tooltip>"),
	SATELLITE				("Satellite","Satellite","item/item_satellite.png","<tooltip>"),
	SKY_PEARL_BRACELET		("Sky Pearl Bracelet","Bracelet","item/item_skypearlbracelet.png","<tooltip>"),
	SUNFLOWER_SEEDS			("Sunflower Seeds","Seed","item/item_seeds.png","<tooltip>"),
	TOTALBISCUITS_TOP_HAT	("TotalBiscuit's Top Hat", "TBTophat", "item/item_totalbiscuitstophat.png", "<tooltip>"),
	UNCLE_SAMS_HAT			("Uncle Sam's Hat","UncleSamHat","item/item_unclessamhut.png","<tooltip>"),
	WAIST_POUCH				("Waist Pouch","WaistPouch","item/item_waistpouch.png","<tooltip>"),
	UNKNOWN					("", "", "new-thumb.png", "");
	
	private final String gameName;
	private final String codeName;
	private final String image;
	private final String tooltip;
	
	private ItemConst(String gameName, String codeName, String image, String tooltip) {
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
