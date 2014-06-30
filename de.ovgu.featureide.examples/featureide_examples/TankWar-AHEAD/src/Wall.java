
import java.util.Vector;



abstract class Wall$$TankWar extends GameObject {

	protected int koernigGroesse;
	protected Vector wallTeile = new Vector(2, 2);

	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param x_Koernig
	 *            -Width
	 * @param y_Koernig
	 *            -Height
	 * @param wallType
	 */
	public Wall$$TankWar(TankManager tankManager, int x_Koordinate, int y_Koordinate,
			int x_Koernig, int y_Koernig, int wallType) {
		init(tankManager, x_Koordinate, y_Koordinate, x_Koernig/2, y_Koernig/2,
				wallType);
	}

	protected void init(TankManager tankManager, int x_Koordinate,
			int y_Koordinate, int x_Koernig, int y_Koernig, int wallType) {

		((Wall) this).koernigGroesse = tankManager.koernigkeit;
		switch (wallType) {
		case 31:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2,
					y_Koordinate * tankManager.koernigkeit2, 255, 255, 0,
					x_Koernig * koernigGroesse, y_Koernig * koernigGroesse,
					wallType);
			break;
		case 32:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2,
					y_Koordinate * tankManager.koernigkeit2, 0, 139, 0,
					x_Koernig * koernigGroesse, y_Koernig * koernigGroesse,
					wallType);
			break;
		case 33:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2,
					y_Koordinate * tankManager.koernigkeit2, 150, 255, 150,
					x_Koernig * koernigGroesse, y_Koernig * koernigGroesse,
					wallType);
			break;
		case 34:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2,
					y_Koordinate * tankManager.koernigkeit2, 0, 255, 134,
					x_Koernig * koernigGroesse, y_Koernig * koernigGroesse,
					wallType);
			break;

		}
		for (int j = 0; j < y_Koernig; j++) {
			for (int i = 0; i < x_Koernig; i++) {
				wallTeile.addElement(new GameObject(tankManager,
						((Wall) this).x_Koordinate + i * koernigGroesse,
						((Wall) this).y_Koordinate + j * koernigGroesse, colorR, colorG,
						colorB, koernigGroesse, koernigGroesse, wallType));
			}
		}

	}

	protected void malen() {

		
		 for (int i = 0; i < wallTeile.size(); i++) { ((GameObject)
		 wallTeile.elementAt(i)).malen(); }
		 
		
	}

	protected boolean stossenGegen(GameObject gameObj) {

		return (super.stossenGegen(gameObj) && stossenGegenTeil(gameObj));

	}

	protected boolean stossenGegenTeil(GameObject gameObj) {
		boolean stossen = false;
		Vector tempTeile = new Vector();

		for (int i = 0; i < wallTeile.size(); i++) {

			if (gameObj.stossenGegen((GameObject) wallTeile.elementAt(i))) {
				tempTeile.addElement((GameObject) wallTeile.elementAt(i));
				stossen = true;
			}
		}
		if (objectType != 33 && gameObj instanceof Missile) {
			for (int i = 0; i < tempTeile.size(); i++) {

				wallTeile.removeElement((GameObject) tempTeile.elementAt(i));
			}
		}
		return stossen;
	}

}

public class Wall extends  Wall$$TankWar  {

	protected void malen() {
		for (int i = 0; i < wallTeile.size(); i++) {
			int x = ((GameObject) wallTeile.elementAt(i)).x_Koordinate;
			int y = ((GameObject) wallTeile.elementAt(i)).y_Koordinate;
			int wallTypeImage = ((GameObject) wallTeile.elementAt(i)).objectType;
			tankManager.maler.drawImage(wallTypeImage + ".png", x, y);
		}

	}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param x_Koernig
	 *            -Width
	 * @param y_Koernig
	 *            -Height
	 * @param wallType
	 */
	public Wall ( TankManager tankManager, int x_Koordinate, int y_Koordinate,
			int x_Koernig, int y_Koernig, int wallType ) { super(tankManager, x_Koordinate, y_Koordinate, x_Koernig, y_Koernig, wallType); }
	

}