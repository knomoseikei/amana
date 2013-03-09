package pe.rmlabs.amana.domain;

import java.util.Calendar;

@Deprecated
public class AirMechReplay {

	private String name;
	private String build;
	private Calendar date;
	private String map;
	private String gameMode;
	private AirMechPlayer player1;
	private AirMechPlayer player2;
	private AirMechPlayer player3;
	private AirMechPlayer player4;
	private AirMechPlayer player5;
	private AirMechPlayer player6;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirMechReplay [build=");
		builder.append(build);
		builder.append(", map=");
		builder.append(map);
		builder.append(", gameMode=");
		builder.append(gameMode);
		builder.append(", \nPLAYER1=");
		builder.append(player1);
		builder.append(", \nPLAYER2=");
		builder.append(player2);
		builder.append(", \nPLAYER3=");
		builder.append(player3);
		builder.append(", \nPLAYER4=");
		builder.append(player4);
		builder.append(", \nPLAYER5=");
		builder.append(player5);
		builder.append(", \nPLAYER6=");
		builder.append(player6);
		builder.append("]");
		return builder.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public AirMechPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(AirMechPlayer player1) {
		this.player1 = player1;
	}

	public AirMechPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(AirMechPlayer player2) {
		this.player2 = player2;
	}

	public AirMechPlayer getPlayer3() {
		return player3;
	}

	public void setPlayer3(AirMechPlayer player3) {
		this.player3 = player3;
	}

	public AirMechPlayer getPlayer4() {
		return player4;
	}

	public void setPlayer4(AirMechPlayer player4) {
		this.player4 = player4;
	}

	public AirMechPlayer getPlayer5() {
		return player5;
	}

	public void setPlayer5(AirMechPlayer player5) {
		this.player5 = player5;
	}

	public AirMechPlayer getPlayer6() {
		return player6;
	}

	public void setPlayer6(AirMechPlayer player6) {
		this.player6 = player6;
	}
}
