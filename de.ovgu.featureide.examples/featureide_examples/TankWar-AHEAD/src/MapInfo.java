
import java.io.InputStream;
import java.util.Vector;



public class MapInfo {
	Vector brickWall = new Vector();
	Vector metalWall = new Vector();
	Vector grassWall = new Vector();
	Vector waterWall = new Vector();
	Vector enemyPosition = new Vector();
	Vector enemyType = new Vector();
	TankManager tankManager;
	public boolean read = true;
	int mapSize;
	int playerLocationX;
	int playerLocationY;
	int baseLocationX;
	int baseLocationY;
	int brickWallLocationX;
	int brickWallLocationY;
	int brickWallWidth;
	int brickWallHeight;
	int metalWallLocationX;
	int metalWallLocationY;
	int metalWallWidth;
	int metalWallHeight;
	int grassWallLocationX;
	int grassWallLocationY;
	int grassWallWidth;
	int grassWallHeight;
	int waterWallLocationX;
	int waterWallLocationY;
	int waterWallWidth;
	int waterWallHeight;
	int enemyLocation;
	int enemyAllNr;
	int enemyMaxNr;
	int enemyTy;

	private String readMap(String resource) {
		String strReturn = null;
		InputStream in = null;
		byte[] word_utf = new byte[1024];// new byte[1024];
		char[] toChar = new char[512];
		int rectLocationX;
		int rectLocationY;
		int rectWidth;
		int rectHeight;

		try {
			in = Tank.class.getClassLoader().getResourceAsStream("maps/" + resource);
			in.read(word_utf);
			in.close();
			strReturn = new String(word_utf, "UTF-8");
		} catch (Exception e) {
			((MapInfo) this).read = false;
			return null;
		} finally {
		}
		in = null;
		System.out.println(strReturn);
		toChar = strReturn.toCharArray();
		for (int i = 0; i < 512; i++) {
			if (toChar[i] == 'a') {
				mapSize = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
				System.out.println("mapSize = " + mapSize);
			}
			if (toChar[i] == 'b') {
				brickWallLocationX = (((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48);
				brickWallLocationY = (((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48);
				brickWallWidth = (((int) toChar[i + 5] - 48) * 10 + (int) toChar[i + 6] - 48);
				brickWallHeight = (((int) toChar[i + 7] - 48) * 10 + (int) toChar[i + 8] - 48);
				brickWall.addElement(new Wall(tankManager, brickWallLocationX, brickWallLocationY,
						brickWallWidth, brickWallHeight, 31));
			}
			if (toChar[i] == 'c') {
				metalWallLocationX = (((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48);
				metalWallLocationY = (((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48);
				metalWallWidth = (((int) toChar[i + 5] - 48) * 10 + (int) toChar[i + 6] - 48);
				metalWallHeight = (((int) toChar[i + 7] - 48) * 10 + (int) toChar[i + 8] - 48);
				metalWall.addElement(new Wall(tankManager, metalWallLocationX, metalWallLocationY,
						metalWallWidth, metalWallHeight, 33));
			}
			if (toChar[i] == 'd') {
				grassWallLocationX = (((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48);
				grassWallLocationY = (((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48);
				grassWallWidth = (((int) toChar[i + 5] - 48) * 10 + (int) toChar[i + 6] - 48);
				grassWallHeight = (((int) toChar[i + 7] - 48) * 10 + (int) toChar[i + 8] - 48);
				grassWall.addElement(new Wall(tankManager, grassWallLocationX, grassWallLocationY,
						grassWallWidth, grassWallHeight, 32));
			}
			if (toChar[i] == 'e') {
				waterWallLocationX = (((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48);
				waterWallLocationY = (((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48);
				waterWallWidth = (((int) toChar[i + 5] - 48) * 10 + (int) toChar[i + 6] - 48);
				waterWallHeight = (((int) toChar[i + 7] - 48) * 10 + (int) toChar[i + 8] - 48);
				waterWall.addElement(new Wall(tankManager, waterWallLocationX, waterWallLocationY,
						waterWallWidth, waterWallHeight, 34));
			}
			if (toChar[i] == 'f') {
				enemyLocation = ((int) toChar[i + 1] - 48) * 1000 + ((int) toChar[i + 2] - 48)
						* 100 + ((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48;
				Integer temp = new Integer(enemyLocation);
				enemyPosition.addElement(temp);
			}
			if (toChar[i] == 'g') {
				enemyAllNr = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
			}
			if (toChar[i] == 'h') {
				enemyMaxNr = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
			}
			if (toChar[i] == 'i') {
				enemyTy = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
				Integer temp = new Integer(enemyTy);
				enemyType.addElement(temp);
			}
			if (toChar[i] == 'j') {
				playerLocationX = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
				playerLocationY = ((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48;
			}
			if (toChar[i] == 'k') {
				baseLocationX = ((int) toChar[i + 1] - 48) * 10 + (int) toChar[i + 2] - 48;
				baseLocationY = ((int) toChar[i + 3] - 48) * 10 + (int) toChar[i + 4] - 48;
			}
		}

		return strReturn;

	}

	public MapInfo(TankManager tankM, int lv) {
		this.tankManager = tankM;
		String x = "/map" + lv + ".txt";
		this.readMap(x);
	}

}