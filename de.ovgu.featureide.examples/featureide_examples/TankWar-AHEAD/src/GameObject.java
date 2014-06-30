
import java.util.Vector;



public class GameObject {

	protected TankManager tankManager;
	protected int x_Koordinate, y_Koordinate, x_Koe, y_Koe;
	protected int colorR, colorG, colorB;
	protected int objectType;
	protected int id;
	protected int objWidth, objHeight, objWidth_Koe, objHeight_Koe;
	protected boolean zerstoerbarKeit = true;

	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 * @param y_Koordinate
	 * @param colorR
	 * @param colorG
	 * @param colorB
	 * @param objWidth
	 * @param objHeight
	 * @param objectType
	 */
	public GameObject(TankManager tankManager, int x_Koordinate,
			int y_Koordinate, int colorR, int colorG, int colorB, int objWidth,
			int objHeight, int objectType) {
		init(tankManager, x_Koordinate, y_Koordinate, colorR, colorG, colorB,
				objWidth, objHeight, objectType);
	}

	protected void init(TankManager tankManager, int x_Koordinate,
			int y_Koordinate, int colorR, int colorG, int colorB, int objWidth,
			int objHeight, int objectType) {

		((GameObject) this).tankManager = tankManager;
		((GameObject) this).x_Koordinate = x_Koordinate;
		((GameObject) this).y_Koordinate = y_Koordinate;
		((GameObject) this).colorR = colorR;
		((GameObject) this).colorG = colorG;
		((GameObject) this).colorB = colorB;
		((GameObject) this).objWidth = objWidth;
		((GameObject) this).objHeight = objHeight;
		((GameObject) this).objWidth_Koe = objWidth / tankManager.koernigkeit2;
		((GameObject) this).objHeight_Koe = objHeight / tankManager.koernigkeit2;
		((GameObject) this).objectType = objectType;

	}

	public GameObject() {
	}

	protected void malen() {
		tankManager.maler.setColor(colorR, colorG, colorB);
		tankManager.maler.fillRect(x_Koordinate, y_Koordinate, objWidth,
				objHeight);

	}

	protected boolean stossenGegen(GameObject gameObj) {
		if (gameObj instanceof Tank) {
			if (x_Koe < gameObj.x_Koe + gameObj.objWidth_Koe
					&& x_Koe > gameObj.x_Koe - objWidth_Koe
					&& y_Koe < gameObj.y_Koe + gameObj.objHeight_Koe
					&& y_Koe > gameObj.y_Koe - objHeight_Koe) {
				return true;
			}
		}
		if (x_Koordinate < gameObj.x_Koordinate + gameObj.objWidth
				&& x_Koordinate > gameObj.x_Koordinate - objWidth
				&& y_Koordinate < gameObj.y_Koordinate + gameObj.objHeight
				&& y_Koordinate > gameObj.y_Koordinate - objHeight)

			return true;
		else
			return false;
	}

	protected boolean stossenGegen(Vector obj) {
		boolean wall = false;
		if (obj.size() > 0) {
			wall = obj.elementAt(0) instanceof Wall;
		}
		for (int i = 0; i < obj.size(); i++) {
			if (wall) {
				if (stossenGegen((Wall) obj.elementAt(i)))
					return true;
			} else {
				if (stossenGegen((GameObject) obj.elementAt(i))
						&& ((GameObject) this) != (GameObject) obj.elementAt(i))

					return true;
			}
		}
		return false;
	}

	protected boolean stossenGegen(Wall wall) {

		return wall.stossenGegen(((GameObject) this));
	}

	public static int getRund(float f) {
		Float ftemp = new Float(f);
		int fint = ftemp.intValue();
		if (ftemp.floatValue() >= fint + 0.5f) {
			fint = fint + 1;
		}
		return fint;
	}
	
	protected void explodieren() {
		
	}

}