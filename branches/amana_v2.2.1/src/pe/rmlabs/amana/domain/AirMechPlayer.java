package pe.rmlabs.amana.domain;

public class AirMechPlayer {
	
	private String player;
	private Mech airmech;
	private Pilot pilot;
	private Item item;
	private Color color;
	private Flair flair1;
	private Flair flair2;
	private Flair flair3;
	private Unit unit1;
	private Unit unit2;
	private Unit unit3;
	private Unit unit4;
	private Unit unit5;
	private Unit unit6;
	private Unit unit7;
	private Unit unit8;
	
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public Mech getAirmech() {
		return airmech;
	}
	public void setAirmech(Mech airmech) {
		this.airmech = airmech;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Flair getFlair1() {
		return flair1;
	}
	public void setFlair1(Flair flair1) {
		this.flair1 = flair1;
	}
	public Flair getFlair2() {
		return flair2;
	}
	public void setFlair2(Flair flair2) {
		this.flair2 = flair2;
	}
	public Flair getFlair3() {
		return flair3;
	}
	public void setFlair3(Flair flair3) {
		this.flair3 = flair3;
	}
	public Unit getUnit1() {
		return unit1;
	}
	public void setUnit1(Unit unit1) {
		this.unit1 = unit1;
	}
	public Unit getUnit2() {
		return unit2;
	}
	public void setUnit2(Unit unit2) {
		this.unit2 = unit2;
	}
	public Unit getUnit3() {
		return unit3;
	}
	public void setUnit3(Unit unit3) {
		this.unit3 = unit3;
	}
	public Unit getUnit4() {
		return unit4;
	}
	public void setUnit4(Unit unit4) {
		this.unit4 = unit4;
	}
	public Unit getUnit5() {
		return unit5;
	}
	public void setUnit5(Unit unit5) {
		this.unit5 = unit5;
	}
	public Unit getUnit6() {
		return unit6;
	}
	public void setUnit6(Unit unit6) {
		this.unit6 = unit6;
	}
	public Unit getUnit7() {
		return unit7;
	}
	public void setUnit7(Unit unit7) {
		this.unit7 = unit7;
	}
	public Unit getUnit8() {
		return unit8;
	}
	public void setUnit8(Unit unit8) {
		this.unit8 = unit8;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirMechPlayer [");
		if (player != null) {
			builder.append("player=");
			builder.append(player);
			builder.append(", ");
		}
		if (airmech != null) {
			builder.append("airmech=");
			builder.append(airmech.getGameName());
			builder.append(", ");
		}
		if (pilot != null) {
			builder.append("pilot=");
			builder.append(pilot.getGameName());
			builder.append(", ");
		}
		if (item != null) {
			builder.append("item=");
			builder.append(item.getGameName());
			builder.append(", ");
		}
		if (flair1 != null) {
			builder.append("flair1=");
			builder.append(flair1.getGameName());
			builder.append(", ");
		}
		if (flair2 != null) {
			builder.append("flair2=");
			builder.append(flair2.getGameName());
			builder.append(", ");
		}
		if (flair3 != null) {
			builder.append("flair3=");
			builder.append(flair3.getGameName());
			builder.append(", ");
		}
		if (unit1 != null) {
			builder.append("unit1=");
			builder.append(unit1.getGameName());
			builder.append(", ");
		}
		if (unit2 != null) {
			builder.append("unit2=");
			builder.append(unit2.getGameName());
			builder.append(", ");
		}
		if (unit3 != null) {
			builder.append("unit3=");
			builder.append(unit3.getGameName());
			builder.append(", ");
		}
		if (unit4 != null) {
			builder.append("unit4=");
			builder.append(unit4.getGameName());
			builder.append(", ");
		}
		if (unit5 != null) {
			builder.append("unit5=");
			builder.append(unit5.getGameName());
			builder.append(", ");
		}
		if (unit6 != null) {
			builder.append("unit6=");
			builder.append(unit6.getGameName());
			builder.append(", ");
		}
		if (unit7 != null) {
			builder.append("unit7=");
			builder.append(unit7.getGameName());
			builder.append(", ");
		}
		if (unit8 != null) {
			builder.append("unit8=");
			builder.append(unit8.getGameName());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
