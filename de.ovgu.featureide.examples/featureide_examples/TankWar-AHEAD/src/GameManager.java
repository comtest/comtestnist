

abstract interface GameManager$$TankWar {

	public static int MAIN_MENU = 0;
	public static int TANK_WAEHLEN = 1;
	public static int SPIELEN = 2;
	public static int NOTE = 3;
	public static int HELP = 4;
	public static int LIAN_WANG = 5;
	public static int BANG_ZHU = 6;
	public static int KAI_FA = 7;
	public static int PAUSE = 8;
	public static int EXIT = 9;
	public static int NAME_VERGEBEN = 10;
	public static int LOSE = 11;
	public static int LEVEL = 12;
	public static int WIN = 13;

	public void aktualisieren();

	public void malenkontrolle();

	public void keyPressBehandeln(int key);

	public void keyReleaseBehandeln(int key);

	public void setStatus(int status);
	
	public int getBlood();
	
	public int getTankMenge();

}

public interface GameManager extends GameManager$$TankWar {
	
	public void writeScore();

}