package jab.module;

import robocode.Rules;
import robocode.Bullet;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (bot.enemy != null) {
			// Calculate bullet power for the burst (dividing max power among 3 shots)
			double bulletPower = Math.min(Rules.MAX_BULLET_POWER / 3.0, bot.getEnergy() - 0.01);
			int burstCount = 3; // Number of bullets in the burst
			for (int i = 0; i < burstCount; i++) {
				if (bot.getGunHeat() == 0) {
					Bullet b = bot.setFireBullet(bulletPower);
					bot.registerBullet(b);
				}
			}
		}
	}

}
