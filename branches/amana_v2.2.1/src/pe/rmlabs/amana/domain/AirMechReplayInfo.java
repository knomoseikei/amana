package pe.rmlabs.amana.domain;

import java.util.Calendar;

public class AirMechReplayInfo {

	private String name;
	private Calendar date;
	
	private String build;
	private GameMap map;
	private boolean onlineGame;
	private String aiMask;
	private short maxPlayers;
	private short netPlayers;
	private String playerCfg;
	private GameMode gameMode;
	
	private AirMechPlayer player1;
	private AirMechPlayer player2;
	private AirMechPlayer player3;
	private AirMechPlayer player4;
	private AirMechPlayer player5;
	private AirMechPlayer player6;
	
	private String notes;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public GameMap getMap() {
		return map;
	}
	public void setMap(GameMap map) {
		this.map = map;
	}
	public boolean isOnlineGame() {
		return onlineGame;
	}
	public void setOnlineGame(boolean onlineGame) {
		this.onlineGame = onlineGame;
	}
	public String getAiMask() {
		return aiMask;
	}
	public void setAiMask(String aiMask) {
		this.aiMask = aiMask;
	}
	public short getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(short maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public short getNetPlayers() {
		return netPlayers;
	}
	public void setNetPlayers(short netPlayers) {
		this.netPlayers = netPlayers;
	}
	public String getPlayerCfg() {
		return playerCfg;
	}
	public void setPlayerCfg(String playerCfg) {
		this.playerCfg = playerCfg;
	}
	public GameMode getGameMode() {
		return gameMode;
	}
	public void setGameMode(GameMode gameMode) {
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirMechReplayInfo [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (date != null) {
			builder.append("date=");
			builder.append(date.getTime().toString());
			builder.append(", ");
		}
		if (build != null) {
			builder.append("build=");
			builder.append(build);
			builder.append(", ");
		}
		if (map != null) {
			builder.append("map=");
			builder.append(map.getGameName());
			builder.append(", ");
		}
		builder.append("onlineGame=");
		builder.append(onlineGame);
		builder.append(", ");
		if (aiMask != null) {
			builder.append("aiMask=");
			builder.append(aiMask);
			builder.append(", ");
		}
		builder.append("maxPlayers=");
		builder.append(maxPlayers);
		builder.append(", netPlayers=");
		builder.append(netPlayers);
		builder.append(", ");
		if (gameMode != null) {
			builder.append("gameMode=");
			builder.append(gameMode.getGameName());
			builder.append(", ");
		}
		if (player1 != null) {
			builder.append("player1=");
			builder.append(player1);
			builder.append(", ");
		}
		if (player2 != null) {
			builder.append("player2=");
			builder.append(player2);
			builder.append(", ");
		}
		if (player3 != null) {
			builder.append("player3=");
			builder.append(player3);
			builder.append(", ");
		}
		if (player4 != null) {
			builder.append("player4=");
			builder.append(player4);
			builder.append(", ");
		}
		if (player5 != null) {
			builder.append("player5=");
			builder.append(player5);
			builder.append(", ");
		}
		if (player6 != null) {
			builder.append("player6=");
			builder.append(player6);
		}
		if (notes != null) {
			builder.append("notes=\n");
			builder.append(notes);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
