package jab.module;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		bot.setAhead(moveAmount * moveDirection);
		moveAmount = Math.max(0, moveAmount - 1);
		bot.setTurnRight(45 * turnDirection);
	}

	int moveDirection;
	int turnDirection;
	double moveAmount;

	public void listenInput(InputEvent e) {
		if (e instanceof KeyEvent) {
			if (((KeyEvent) e).getID() == KeyEvent.KEY_PRESSED)
				switch (((KeyEvent) e).getKeyCode()) {
				case KeyEvent.VK_UP:
					moveDirection = 1;
					moveAmount = Double.POSITIVE_INFINITY;
					break;

				case KeyEvent.VK_DOWN:
					moveDirection = -1;
					moveAmount = Double.POSITIVE_INFINITY;
					break;

				case KeyEvent.VK_RIGHT:
					turnDirection = 1;
					break;

				case KeyEvent.VK_LEFT:
					turnDirection = -1;
					break;
				}
			else if (((KeyEvent) e).getID() == KeyEvent.KEY_RELEASED)
				switch (((KeyEvent) e).getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
					// Arrow up and down keys: move direction = stand still
					moveDirection = 0;
					break;

				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_LEFT:
					// Arrow right and left keys: turn direction = stop turning
					turnDirection = 0;
					break;
				}

		}
	}

}
