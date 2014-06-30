

abstract class Missile$$TankWar extends GameObject {

	protected float geschwindigkeit, xf_Koordinate, yf_Koordinate;
	protected long currTime;
	protected int tankId;
	protected int missileRichtung;
	protected int vernichtungskraft;
	protected boolean feindlich;

	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 * @param y_Koordinate
	 * @param width
	 * @param height
	 * @param missileRichtung
	 * @param missileType
	 */
	public Missile$$TankWar(TankManager tankManager, int x_Koordinate, int y_Koordinate, int width,
			int height, int missileRichtung, int missileType, boolean feindlich, int tankId) {
		init(tankManager, x_Koordinate, y_Koordinate, width, height, missileRichtung, missileType,
				feindlich, tankId);
	}

	protected void init(TankManager tankManager, int x_Koordinate, int y_Koordinate, int width,
			int height, int missileRichtung, int missileType, boolean feindlich, int tankId) {

		((Missile) this).tankManager = tankManager;
		((Missile) this).objectType = missileType;
		((Missile) this).missileRichtung = missileRichtung;
		((Missile) this).feindlich = feindlich;
		((Missile) this).id = ((Missile) this).hashCode();
		((Missile) this).tankId = tankId;

		switch (missileType) {
		case 70:
			((Missile) this).objWidth = tankManager.koernigkeit2 + 2;
			((Missile) this).objHeight = tankManager.koernigkeit2 + 2;
			((Missile) this).colorR = 255;
			((Missile) this).colorG = 200;
			((Missile) this).colorB = 205;
			((Missile) this).geschwindigkeit = 0.00039f;
			((Missile) this).vernichtungskraft = 10;
			break;
		}

		switch (missileRichtung) {
		case 1:
			((Missile) this).x_Koordinate = x_Koordinate + width / 2 - objWidth / 2;
			((Missile) this).y_Koordinate = y_Koordinate - objHeight;
			break;
		case 3:
			int temp = ((Missile) this).objWidth;
			((Missile) this).objWidth = ((Missile) this).objHeight;
			((Missile) this).objHeight = temp;
			((Missile) this).x_Koordinate = x_Koordinate + width;
			((Missile) this).y_Koordinate = y_Koordinate + height / 2 - objHeight / 2;
			break;
		case 5:
			((Missile) this).x_Koordinate = x_Koordinate + width / 2 - objWidth / 2;
			((Missile) this).y_Koordinate = y_Koordinate + height;
			break;
		case 7:
			temp = ((Missile) this).objWidth;
			((Missile) this).objWidth = ((Missile) this).objHeight;
			((Missile) this).objHeight = temp;
			((Missile) this).x_Koordinate = x_Koordinate - objWidth;
			((Missile) this).y_Koordinate = y_Koordinate + height / 2 - objHeight / 2;
			break;
		}

		currTime = System.currentTimeMillis();
		((Missile) this).xf_Koordinate = ((Missile) this).x_Koordinate + 0.0f;
		((Missile) this).yf_Koordinate = ((Missile) this).y_Koordinate + 0.0f;

	}

	protected void malen() {
		long elapsedTime = System.currentTimeMillis() - currTime;
		currTime += elapsedTime;
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			elapsedTime = 0;
		}
		koordinateAktualisieren(elapsedTime);

		 tankManager.maler.setColor(colorR, colorG, colorB);
		 tankManager.maler.fillOvall(x_Koordinate, y_Koordinate, objWidth,
	 objHeight);
		
	}

	protected void koordinateAktualisieren(long elapsedTime) {

		switch (missileRichtung) {
		case 1:
			yf_Koordinate -= geschwindigkeit * tankManager.screenWidth * elapsedTime;
			y_Koordinate = getRund(yf_Koordinate);
			break;
		case 3:
			xf_Koordinate += geschwindigkeit * tankManager.screenWidth * elapsedTime;
			x_Koordinate = getRund(xf_Koordinate);
			break;
		case 5:
			yf_Koordinate += geschwindigkeit * tankManager.screenWidth * elapsedTime;
			y_Koordinate = getRund(yf_Koordinate);
			break;
		case 7:
			xf_Koordinate -= geschwindigkeit * tankManager.screenWidth * elapsedTime;
			x_Koordinate = getRund(xf_Koordinate);
			break;
		}

		if (x_Koordinate < 0 || y_Koordinate < 0 || x_Koordinate > tankManager.screenWidth
				|| y_Koordinate > tankManager.screenHeight) {
			tankManager.missilesMenge.removeElement(((Missile) this));
		}

		treffenErkennen();

	}

	protected void treffenErkennen() {
		for (int i = 0; i < tankManager.tankMenge.size(); i++) {

			if (stossenGegen((GameObject) tankManager.tankMenge.elementAt(i))
					&& ((Missile) this).feindlich != ((Tank) tankManager.tankMenge.elementAt(i)).feindlich) {
				((Tank) tankManager.tankMenge.elementAt(i)).beschaedigen(vernichtungskraft,tankId);
				remove();
				break;
			}

		}
		for (int i = 0; i < tankManager.missilesMenge.size(); i++) {

			if (((Missile) this).feindlich != ((Missile) tankManager.missilesMenge.elementAt(i)).feindlich
					&& stossenGegen((GameObject) tankManager.missilesMenge.elementAt(i))) {
				((Missile) tankManager.missilesMenge.elementAt(i)).explodieren();
				remove();
				break;
			}

		}

		if (stossenGegen(tankManager.brickwall))
			explodieren();
		if (stossenGegen(tankManager.metalwall))
			explodieren();
	}

	protected void explodieren() {
		tankManager.missilesMenge.removeElement(((Missile) this));
	}
	
	protected void remove(){
		tankManager.missilesMenge.removeElement(((Missile) this));
	}
}

abstract class Missile$$explodieren extends  Missile$$TankWar  {

	protected void explodieren(){
		super.explodieren();
		tankManager.expEffekt.addElement(new ExplodierenEffekt(tankManager, x_Koordinate,
				y_Koordinate));
	}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 * @param y_Koordinate
	 * @param width
	 * @param height
	 * @param missileRichtung
	 * @param missileType
	 */
	public Missile$$explodieren ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int width,
			int height, int missileRichtung, int missileType, boolean feindlich, int tankId ) { super(tankManager, x_Koordinate, y_Koordinate, width, height, missileRichtung, missileType, feindlich, tankId); }
	
}

public class Missile extends  Missile$$explodieren  {

	public void malen() {
		long elapsedTime = System.currentTimeMillis() - currTime;
		currTime += elapsedTime;
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			elapsedTime = 0;
		}
		koordinateAktualisieren(elapsedTime);

		switch (missileRichtung) {
		case 1:
			tankManager.maler.drawImage("missileU.png", x_Koordinate, y_Koordinate);
			break;
		case 3:
			tankManager.maler.drawImage("missileR.png", x_Koordinate, y_Koordinate);
			break;

		case 5:
			tankManager.maler.drawImage("missileD.png", x_Koordinate, y_Koordinate);
			break;
		case 7:
			tankManager.maler.drawImage("missileL.png", x_Koordinate, y_Koordinate);
			break;
		}
	}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 * @param y_Koordinate
	 * @param width
	 * @param height
	 * @param missileRichtung
	 * @param missileType
	 */
	public Missile ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int width,
			int height, int missileRichtung, int missileType, boolean feindlich, int tankId ) { super(tankManager, x_Koordinate, y_Koordinate, width, height, missileRichtung, missileType, feindlich, tankId); }

}