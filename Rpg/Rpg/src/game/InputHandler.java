package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class InputHandler implements KeyListener {

	public InputHandler(Game game) {
		game.addKeyListener(this);
	}

	public class Key {
		private int numTimesPressed = 0;
		private boolean pressed = false;

		public int getNumTimesPressed() {
			return numTimesPressed;
		}

		public boolean isPressed() {
			return pressed;
		}

		public void toggle(boolean isPressed) {
			pressed = isPressed;
			if (isPressed)
				numTimesPressed++;
		}
	}

	public Key MUp = new Key();
	public Key MDown = new Key();
	public Key MLeft = new Key();
	public Key MRight = new Key();
	
	public Key SUp = new Key();
	public Key SDown = new Key();
	public Key SLeft = new Key();
	public Key SRight = new Key();

	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_W)
			MUp.toggle(isPressed);
		if (keyCode == KeyEvent.VK_S)
			MDown.toggle(isPressed);
		if (keyCode == KeyEvent.VK_A)
			MLeft.toggle(isPressed);
		if (keyCode == KeyEvent.VK_D)
			MRight.toggle(isPressed);
		if (keyCode == KeyEvent.VK_UP)
			SUp.toggle(isPressed);
		if (keyCode == KeyEvent.VK_DOWN)
			SDown.toggle(isPressed);
		if (keyCode == KeyEvent.VK_LEFT)
			SLeft.toggle(isPressed);
		if (keyCode == KeyEvent.VK_RIGHT)
			SRight.toggle(isPressed);
	}

}
