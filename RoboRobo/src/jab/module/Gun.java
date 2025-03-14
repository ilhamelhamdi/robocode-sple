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
			double timeFactor = Math.sin(bot.getTime() * 0.1); // Sinus dari waktu
			double bulletPower = 1.5 + (timeFactor * 1.5); // Power bervariasi dari 1.5 ke 3.0

			// Hitung delay berdasarkan sinus (ubah range dari 5 ke 20 ticks)
			long fireDelay = (long) ((1.0 - timeFactor) * 15) + 5;

			// Pastikan tidak menembak kalau energi hampir habis
			if (bot.getEnergy() < bulletPower + 0.5) {
				bulletPower = 0;
			}

			bot.bulletPower = bulletPower;

			System.out.println(fireDelay);
			System.out.println("test: " + (bot.getTime() - lastFireTime));

			// Cek apakah sudah cukup lama sejak tembakan terakhir
			if (bot.getGunHeat() == 0 && bulletPower > 0 && bot.getTime() - lastFireTime >= fireDelay) {
				Bullet b = bot.setFireBullet(bulletPower);
				bot.registerBullet(b);
				lastFireTime = bot.getTime(); // Simpan waktu tembakan terakhir
			}
		}
	}

	private long lastFireTime = 0;

}
