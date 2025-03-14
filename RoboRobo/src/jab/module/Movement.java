package jab.module;

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
		if (bot.getTime() % 30 < 15) {
			moveDirection *= -1;
		}

		bot.setAhead(150 * moveDirection);
	}

	int moveDirection = 1;

}
