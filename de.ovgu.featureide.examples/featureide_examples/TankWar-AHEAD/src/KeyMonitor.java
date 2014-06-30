
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyMonitor implements KeyListener {

	private GameManager gameManager;

	public KeyMonitor(GameManager gameManager) {

		this.gameManager = gameManager;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		gameManager.keyPressBehandeln(key);

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		gameManager.keyReleaseBehandeln(key);

	}

	public void keyTyped(KeyEvent arg0) {

	}

}