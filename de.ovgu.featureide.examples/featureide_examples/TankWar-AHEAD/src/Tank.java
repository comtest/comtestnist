
import java.util.Random;
import java.util.Vector;



abstract class Tank$$TankWar extends GameObject {

	protected float geschwindigkeit, xf_Koordinate, yf_Koordinate;
	protected long currTime;
	protected long time, time1;
	protected int missileType = 70;
	protected long feuernKontroller;
	protected long feuernHaufigkeit = 700;// ms
	protected int energie;
	protected static Random random = new Random();
	protected boolean aktive = true;
	protected boolean feuern = false;
	protected boolean keyUp = false, keyDown = false, keyLeft = false, keyRight = false;
	protected boolean flachHeit = false;
	protected boolean feindlich;
	protected int beschId;
	protected long elapsedTime;

	/*
	 * U=1 UR=2 R=3 DR=4 D=5 LD=6 L=7 UL=8
	 */
	protected int flachHeitRichtung;
	protected int tankRichtung = 0, fahrRichtung = 1;

	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param tankType
	 */
	public Tank$$TankWar(TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType) {
		init(tankManager, x_Koordinate, y_Koordinate, tankType);
	}

	protected void init(TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType) {
		((Tank) this).id = ((Tank) this).hashCode();
		switch (tankType) {
		case 00:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 255, 0, 210, tankManager.koernigkeit2 * 2,
					tankManager.koernigkeit2 * 2, tankType);
			((Tank) this).feindlich = false;
			((Tank) this).geschwindigkeit = 0.00000f;
			((Tank) this).feuernHaufigkeit = 0;
			((Tank) this).energie = 1;
			break;
		case 01:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 255, 0, 0, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = false;
			((Tank) this).geschwindigkeit = 0.00020f;
			((Tank) this).feuernHaufigkeit = 700;
			((Tank) this).energie = 50;
			break;
		case 02:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 0, 255, 0, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = false;
			((Tank) this).geschwindigkeit = 0.00010f;
			((Tank) this).feuernHaufigkeit = 700;
			((Tank) this).energie = 100;
			break;
		case 03:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 0, 0, 255, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = false;
			((Tank) this).geschwindigkeit = 0.00015f;
			((Tank) this).feuernHaufigkeit = 500;
			((Tank) this).energie = 70;
			break;
		case 11:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00010f;
			((Tank) this).feuernHaufigkeit = 900;
			((Tank) this).energie = 1;
			break;
		case 12:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00010f;
			((Tank) this).feuernHaufigkeit = 900;
			((Tank) this).energie = 1;
			break;
		case 13:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 3,
					tankManager.koernigkeit2 * 3, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00010f;
			((Tank) this).feuernHaufigkeit = 900;
			((Tank) this).energie = 1;
			break;
		case 21:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 4,
					tankManager.koernigkeit2 * 4, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00005f;
			((Tank) this).energie = 30;
			break;
		case 22:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 4,
					tankManager.koernigkeit2 * 4, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00005f;
			((Tank) this).energie = 30;
			break;
		case 23:
			super.init(tankManager, x_Koordinate * tankManager.koernigkeit2, y_Koordinate
					* tankManager.koernigkeit2, 210, 10, 210, tankManager.koernigkeit2 * 4,
					tankManager.koernigkeit2 * 4, tankType);
			((Tank) this).feindlich = true;
			((Tank) this).geschwindigkeit = 0.00005f;
			((Tank) this).energie = 30;
			break;
		}

		currTime = System.currentTimeMillis();
		time = currTime;
		time1 = currTime;
		feuernKontroller = currTime;
		((Tank) this).xf_Koordinate = x_Koordinate * tankManager.koernigkeit2 + 0.0f;
		((Tank) this).yf_Koordinate = y_Koordinate * tankManager.koernigkeit2 + 0.0f;
	}

	protected void malen() {
		long elapsedTime = System.currentTimeMillis() - currTime;
		currTime += elapsedTime;
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			if (feindlich) {
				time += elapsedTime;
				time1 += elapsedTime;
			}
			elapsedTime = 0;
		}

		if (feuern) {
			feuern();
		}
		if (!aktive) {
			elapsedTime = 0;
		}
		
		koordinateAktualisieren(elapsedTime);
		tankMalen();

	}

	protected void tankMalen() {
		 tankManager.maler.setColor(colorR, colorG, colorB);
		 tankManager.maler.fillOvall(x_Koordinate, y_Koordinate, objWidth,
		 objHeight);
		
		 geschuetzTurm();

		
	}

	
	private void geschuetzTurm() {
		int pW = objWidth / 10, pH = objWidth / 2 + objWidth / 6;
		switch (((Tank) this).fahrRichtung) {
		case 1:
			tankManager.maler.setColor(255, 165, 0);
			tankManager.maler.fillRect(x_Koordinate + objWidth / 2 - pW / 2, y_Koordinate - pH
					+ objWidth / 2, pW, pH);
			break;
		case 3:
			tankManager.maler.setColor(255, 165, 0);
			tankManager.maler.fillRect(x_Koordinate + objWidth / 2, y_Koordinate + objWidth / 2
					- pW / 2, pH, pW);
			break;

		case 5:
			tankManager.maler.setColor(255, 165, 0);
			tankManager.maler.fillRect(x_Koordinate + objWidth / 2 - pW / 2, y_Koordinate
					+ objWidth / 2, pW, pH);
			break;

		case 7:
			tankManager.maler.setColor(255, 165, 0);
			tankManager.maler.fillRect(x_Koordinate - (pH - objWidth / 2), y_Koordinate + objWidth
					/ 2 - pW / 2, pH, pW);
			break;
		}

	}

	protected void keyPressBehandeln(int key) {
		switch (key) {
		case 38:
			keyUp = true;
			keyDown = false; /* fur vier richtung */
			keyLeft = false; /* fur vier richtung */
			keyRight = false; /* fur vier richtung */
			break;
		case 40:
			keyUp = false;
			keyDown = true;
			keyLeft = false;
			keyRight = false;
			break;
		case 37:
			keyUp = false;
			keyDown = false;
			keyLeft = true;
			keyRight = false;
			break;
		case 39:
			keyUp = false;
			keyDown = false;
			keyLeft = false;
			keyRight = true;
			break;
		case 17: /* key Ctrl */
			feuern = true;
			break;
		}
		richtungErkennen();
	}

	protected void keyReleaseBehandeln(int key) {

		switch (key) {
		case 38:
			keyUp = false;
			break;
		case 40:
			keyDown = false;
			break;
		case 37:
			keyLeft = false;
			break;
		case 39:
			keyRight = false;
			break;
		case 17: /* key Ctrl */
			feuern = false;
			break;
		}
		richtungErkennen();
	}

	protected void richtungErkennen() {
		if (keyLeft && !keyUp && !keyRight && !keyDown)
			tankRichtung = 7;
		else if (keyLeft && keyUp && !keyRight && !keyDown)
			tankRichtung = 8;
		else if (!keyLeft && keyUp && !keyRight && !keyDown)
			tankRichtung = 1;
		else if (!keyLeft && keyUp && keyRight && !keyDown)
			tankRichtung = 2;
		else if (!keyLeft && !keyUp && keyRight && !keyDown)
			tankRichtung = 3;
		else if (!keyLeft && !keyUp && keyRight && keyDown)
			tankRichtung = 4;
		else if (!keyLeft && !keyUp && !keyRight && keyDown)
			tankRichtung = 5;
		else if (keyLeft && !keyUp && !keyRight && keyDown)
			tankRichtung = 6;
		else if (!keyLeft && !keyUp && !keyRight && !keyDown)
			tankRichtung = 0;
	}

	protected void feuern() {
		if (currTime - feuernKontroller > feuernHaufigkeit) {
			((Tank) this).tankManager.missilesMenge.addElement(new Missile(tankManager, x_Koordinate,
					y_Koordinate, objWidth, objHeight, fahrRichtung, missileType, feindlich, id));
			feuernKontroller = currTime;
		}

	}

	protected void koordinateAktualisieren(long elapsedTime) {
		x_Koe = x_Koordinate / tankManager.koernigkeit2;
		y_Koe = y_Koordinate / tankManager.koernigkeit2;
		int x_KoeRest = x_Koordinate % tankManager.koernigkeit2;
		int y_KoeRest = y_Koordinate % tankManager.koernigkeit2;

		if (feindlich&&elapsedTime!=0) {
			tankFeindKI();
		}

		int alteX_Koordinate, alteY_Koordinate, alteX_Koe, alteY_Koe;
		float alteXf_Koordinate, alteYf_Koordinate;
		alteX_Koordinate = x_Koordinate;
		alteY_Koordinate = y_Koordinate;
		alteXf_Koordinate = xf_Koordinate;
		alteYf_Koordinate = yf_Koordinate;
		alteX_Koe = x_Koe;
		alteY_Koe = y_Koe;

		if ((x_KoeRest != 0 || y_KoeRest != 0) && !flachHeit) {
			flachHeit = true;
			flachHeitRichtung = fahrRichtung;
		}
		if (x_KoeRest == 0 && y_KoeRest == 0) {
			flachHeit = false;
		}
		if (flachHeit) {
			switch (flachHeitRichtung) {
			case 1:
				yf_Koordinate -= geschwindigkeit * tankManager.screenWidth * elapsedTime;
				y_Koordinate = getRund(yf_Koordinate);
				if (tankRichtung == 0) {
					if (y_Koordinate / tankManager.koernigkeit2 < alteY_Koordinate
							/ tankManager.koernigkeit2) {
						y_Koordinate = y_Koe * tankManager.koernigkeit2;
					}
				}
				if (yf_Koordinate < 0) {
					yf_Koordinate = 0;
					y_Koordinate = 0;
				}
				y_Koe = y_Koordinate / tankManager.koernigkeit2;
				break;
			case 3:
				xf_Koordinate += geschwindigkeit * tankManager.screenWidth * elapsedTime;
				x_Koordinate = getRund(xf_Koordinate);
				if (tankRichtung == 0) {
					if (x_Koordinate / tankManager.koernigkeit2 > alteX_Koordinate
							/ tankManager.koernigkeit2) {
						x_Koordinate = (x_Koe + 1) * tankManager.koernigkeit2;
					}
				}
				if (x_Koordinate % tankManager.koernigkeit2 != 0) {
					x_Koe = x_Koordinate / tankManager.koernigkeit2 + 1;
				}
				break;
			case 5:
				yf_Koordinate += geschwindigkeit * tankManager.screenWidth * elapsedTime;
				y_Koordinate = getRund(yf_Koordinate);
				if (tankRichtung == 0) {
					if (y_Koordinate / tankManager.koernigkeit2 > alteY_Koordinate
							/ tankManager.koernigkeit2) {
						y_Koordinate = (y_Koe + 1) * tankManager.koernigkeit2;
					}
				}
				if (y_Koordinate % tankManager.koernigkeit2 != 0) {
					y_Koe = y_Koordinate / tankManager.koernigkeit2 + 1;
				}
				break;
			case 7:
				xf_Koordinate -= geschwindigkeit * tankManager.screenWidth * elapsedTime;

				x_Koordinate = getRund(xf_Koordinate);
				if (tankRichtung == 0) {
					if (x_Koordinate / tankManager.koernigkeit2 < alteX_Koordinate
							/ tankManager.koernigkeit2) {
						x_Koordinate = x_Koe * tankManager.koernigkeit2;
					}
				}
				if (xf_Koordinate < 0) {
					xf_Koordinate = 0;
					x_Koordinate = 0;
				}
				x_Koe = x_Koordinate / tankManager.koernigkeit2;
				break;
			}
		} else {
			switch (tankRichtung) {
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
		}

		if (((Tank) this).tankRichtung != 0 && !flachHeit)
			fahrRichtung = tankRichtung;

		// ?????
		if (x_Koordinate < 0 || x_Koordinate > tankManager.screenWidth - objWidth
				|| y_Koordinate < 0 || y_Koordinate > tankManager.screenHeight - objHeight) {
			x_Koordinate = alteX_Koordinate;
			y_Koordinate = alteY_Koordinate;
			xf_Koordinate = alteXf_Koordinate;
			yf_Koordinate = alteYf_Koordinate;
		}

		if (stossenGegen(tankManager.tankMenge)) {
			x_Koordinate = alteX_Koe * tankManager.koernigkeit2;
			y_Koordinate = alteY_Koe * tankManager.koernigkeit2;
			xf_Koordinate = alteXf_Koordinate;
			yf_Koordinate = alteYf_Koordinate;

		}
		if (stossenGegen(tankManager.brickwall)) {
			x_Koordinate = alteX_Koordinate;
			y_Koordinate = alteY_Koordinate;
			xf_Koordinate = alteXf_Koordinate;
			yf_Koordinate = alteYf_Koordinate;
		}
		// if (stossenGegen(tankManager.grasswall)) {
		// x_Koordinate = alteX_Koordinate;
		// y_Koordinate = alteY_Koordinate;
		// }
		if (stossenGegen(tankManager.metalwall)) {
			x_Koordinate = alteX_Koordinate;
			y_Koordinate = alteY_Koordinate;
			xf_Koordinate = alteXf_Koordinate;
			yf_Koordinate = alteYf_Koordinate;
		}
		if (stossenGegen(tankManager.waterwall)) {
			x_Koordinate = alteX_Koordinate;
			y_Koordinate = alteY_Koordinate;
			xf_Koordinate = alteXf_Koordinate;
			yf_Koordinate = alteYf_Koordinate;
		}

	}

	protected void tankFeindKI() {
	
	}

	public void beschaedigen(int besch, int beschId) {
		((Tank) this).beschId = beschId;
		((Tank) this).energie = ((Tank) this).energie - besch;
			if (((Tank) this).energie <= 0) {
				explodieren();
			}
	}
	
	protected void explodieren() {
		tankManager.tankMenge.removeElement(((Tank) this));
		if (tankManager.tank1 != null && ((Tank) this).id == tankManager.tank1.id) {
			tankManager.tank1 = null;
		}
	}
	
	protected void toolBehandeln(int toolType) {
	
	}
	
}

abstract class Tank$$Tools extends  Tank$$TankWar  {

	protected void malen() {
		elapsedTime = System.currentTimeMillis() - currTime;
		currTime += elapsedTime;
		toolKontroller();
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			if (feindlich) {
				time += elapsedTime;
				time1 += elapsedTime;
			}
			elapsedTime = 0;
		}

		if (feuern) {
			feuern();
		}
		if (!aktive) {
			elapsedTime = 0;
		}
		koordinateAktualisieren(elapsedTime);
		tankMalen();

	}
	
	protected void toolKontroller(){
	
	}

	protected void toolBehandeln(int toolType) {}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param tankType
	 */
	public Tank$$Tools ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Beschleunigung extends  Tank$$Tools  {

	protected long beschleunigungTimer;
	protected boolean beschleunigung = false;
	
	protected void toolKontroller(){
		super.toolKontroller();
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			if (beschleunigung) {
				beschleunigungTimer += elapsedTime;
			}
		}
		if (beschleunigung && System.currentTimeMillis() - beschleunigungTimer > 10000) {
			geschwindigkeit -=0.00010f;
			beschleunigung = false;
		}
	}
	
	

	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 370:// 30,144,255
			if (!beschleunigung) {
				((Tank) this).beschleunigungTimer = System.currentTimeMillis();
				((Tank) this).beschleunigung = true;
				((Tank) this).geschwindigkeit += 0.00010f;
			}
			break;
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
	 * @param tankType
	 */
	public Tank$$Beschleunigung ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$einfrieren extends  Tank$$Beschleunigung  {

	protected long einfrierenTimer;
	protected boolean einfrieren = false;
	
	protected void toolKontroller(){
		super.toolKontroller();
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			if (einfrieren) {
				einfrierenTimer += elapsedTime;
			}
		}
		if (einfrieren && System.currentTimeMillis() - einfrierenTimer > 8000) {
			for (int i = 0; i < tankManager.tankMenge.size(); i++) {
				if (tankManager.tankMenge.elementAt(i) != ((Tank) this)) {
					((Tank) tankManager.tankMenge.elementAt(i)).aktive = true;
				}
			}
			einfrieren = false;
		}
	}

	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 371:// 100,149,237
			((Tank) this).einfrierenTimer = System.currentTimeMillis();
			((Tank) this).einfrieren = true;
			for (int i = 0; i < tankManager.tankMenge.size(); i++) {
				if (tankManager.tankMenge.elementAt(i) != tankManager.tank1
						&& tankManager.tankMenge.elementAt(i) != tankManager.tank2) {
					((Tank) tankManager.tankMenge.elementAt(i)).aktive = false;
				}
			}
			break;
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
	 * @param tankType
	 */
	public Tank$$einfrieren ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Bombe extends  Tank$$einfrieren  {

	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 374:// 255,255,0
			Vector temp = new Vector();
			for (int i = 0; i < tankManager.tankMenge.size(); i++) {
				if (tankManager.tankMenge.elementAt(i) != tankManager.tank1
						&& tankManager.tankMenge.elementAt(i) != tankManager.tank2
						&& tankManager.tankMenge.elementAt(i) != tankManager.base) {
					temp.addElement(tankManager.tankMenge.elementAt(i));
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				if (i > 3) {
					break;
				}
				((Tank) temp.elementAt(i)).explodieren();
			}
			break;
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
	 * @param tankType
	 */
	public Tank$$Bombe ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Energie extends  Tank$$Bombe  {

	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 373:// 255,0,0
			((Tank) this).energie += 10;
			break;
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
	 * @param tankType
	 */
	public Tank$$Energie ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Feuerkraft extends  Tank$$Energie  {

	protected long feuerkraftTimer;
	protected boolean feuerkraft = false;
	
	protected void toolKontroller(){
		super.toolKontroller();
		if (tankManager.status == GameManager.PAUSE || tankManager.status == GameManager.EXIT) {
			if (feuerkraft) {
				feuerkraftTimer += elapsedTime;
			}
		}
		if (feuerkraft && System.currentTimeMillis() - feuerkraftTimer > 15000) {
			feuernHaufigkeit = feuernHaufigkeit + 500l;
			feuerkraft = false;
		}
	}
	
	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 372:// 0,255,0
			if (!feuerkraft) {
				((Tank) this).feuerkraftTimer = System.currentTimeMillis();
				((Tank) this).feuerkraft = true;
				((Tank) this).feuernHaufigkeit = ((Tank) this).feuernHaufigkeit - 500l;
			}
			break;
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
	 * @param tankType
	 */
	public Tank$$Feuerkraft ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Mars extends  Tank$$Feuerkraft  {
	protected boolean mars = false;
	protected long marsTimer;
	
	protected void toolKontroller(){
		super.toolKontroller();
		if (mars && System.currentTimeMillis() - marsTimer > 10000) {
			mars = false;
		}
		if (mars) {
			tankManager.maler.setColor(255, 255, 255);
			tankManager.maler.drawRoundRect(x_Koordinate - 3, y_Koordinate - 3, objWidth + 6,
					objHeight + 6, tankManager.koernigkeit, tankManager.koernigkeit);
		}
	}

	protected void toolBehandeln(int toolType) {
		super.toolBehandeln(toolType);
		switch (toolType) {
		case 375:// 255,255,255
			marsTimer = System.currentTimeMillis();
			((Tank) this).mars = true;
		break;
		}
	}
	
	public void beschaedigen(int besch, int beschId) {
		if(mars){
			((Tank) this).energie = ((Tank) this).energie + besch;
		}
		super.beschaedigen(besch,beschId);
	}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param tankType
	 */
	public Tank$$Mars ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$explodieren extends  Tank$$Mars  {

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
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param tankType
	 */
	public Tank$$explodieren ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Image extends  Tank$$explodieren  {

	protected void tankMalen() {
		switch (objectType) {
		case 00:
			tankManager.maler.drawImage("base", x_Koordinate, y_Koordinate);
			break;
		case 01:
			tankManager.maler.drawImage("gh", x_Koordinate - tankManager.koernigkeit2 * 2,
					y_Koordinate - tankManager.koernigkeit2 * 2);
			drawTanks("01");
			break;
		case 02:
			tankManager.maler.drawImage("gh", x_Koordinate - tankManager.koernigkeit2 * 2,
					y_Koordinate - tankManager.koernigkeit2 * 2);
			drawTanks("02");
			break;
		case 03:
			tankManager.maler.drawImage("gh", x_Koordinate - tankManager.koernigkeit2 * 2,
					y_Koordinate - tankManager.koernigkeit2 * 2);
			drawTanks("03");
			break;
		case 11:
			drawTanks("11");
			break;
		case 12:
			drawTanks("12");
			break;
		case 13:
			drawTanks("13");
			break;
		case 21:
			if (((Tank) this).energie >= 30)
				drawTanks("21");
			else if (((Tank) this).energie >= 20 && ((Tank) this).energie < 30)
				drawTanks("24");
			else if (((Tank) this).energie >= 10 && ((Tank) this).energie < 20)
				drawTanks("25");
			break;
		case 22:
			if (((Tank) this).energie >= 30)
				drawTanks("22");
			else if (((Tank) this).energie >= 20 && ((Tank) this).energie < 30)
				drawTanks("26");
			else if (((Tank) this).energie >= 10 && ((Tank) this).energie < 20)
				drawTanks("27");
			break;
		case 23:
			if (((Tank) this).energie >= 30)
				drawTanks("23");
			else if (((Tank) this).energie >= 20 && ((Tank) this).energie < 30)
				drawTanks("28");
			else if (((Tank) this).energie >= 10 && ((Tank) this).energie < 20)
				drawTanks("29");
			break;
		}

	}

	private void drawTanks(String tankTypes) {

		switch (((Tank) this).fahrRichtung) {
		case 1:
			tankManager.maler.drawImage(tankTypes + "U", x_Koordinate, y_Koordinate);
			break;
		case 3:
			tankManager.maler.drawImage(tankTypes + "R", x_Koordinate, y_Koordinate);
			break;
		case 5:
			tankManager.maler.drawImage(tankTypes + "D", x_Koordinate, y_Koordinate);
			break;
		case 7:
			tankManager.maler.drawImage(tankTypes + "L", x_Koordinate, y_Koordinate);
			break;
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
	 * @param tankType
	 */
	public Tank$$Image ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

abstract class Tank$$Record extends  Tank$$Image  {

	protected void explodieren() {
		tankManager.addScore(beschId, objectType);
		super.explodieren();
	}
      // inherited constructors



	/**
	 * 
	 * @param tankManager
	 * @param x_Koordinate
	 *            -(0-59)
	 * @param y_Koordinate
	 *            -(0-59)
	 * @param tankType
	 */
	public Tank$$Record ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }

}

public class Tank extends  Tank$$Record  {

	protected void tankFeindKI() {
		long timeJ = System.currentTimeMillis();
		long timeR = timeJ;
		if (timeJ - time > 700) {
			feuern();
			time = timeJ;
		}

		if (timeR - time1 > 400) {
			int[] richtung = { 0, 1, 3, 5, 7 };

			int index = Math.abs(random.nextInt() % 5);
			tankRichtung = richtung[index];
			time1 = timeJ;
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
	 * @param tankType
	 */
	public Tank ( TankManager tankManager, int x_Koordinate, int y_Koordinate, int tankType ) { super(tankManager, x_Koordinate, y_Koordinate, tankType); }
}