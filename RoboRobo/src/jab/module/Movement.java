package jab.module;

import robocode.Event;
import robocode.HitWallEvent;

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
		// Limit our speed to 5
		bot.setMaxVelocity(8);
		// Start moving (and turning)
		bot.setAhead(10000 * moveDirection);
	}

	private int moveDirection = 1;

	void listen(Event e) {
		if (e instanceof HitWallEvent) {
			moveDirection *= -1;
		}
	}

}
