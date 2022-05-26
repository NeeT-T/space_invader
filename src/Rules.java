import java.util.ArrayList;

public class Rules {
	
	private static int timeToSpawnEnemys = 3000;
	private static long timeToSpawnAlienBonus = 0;
	private static long oneMinute = 60000;
	private static int oneSecond = 1000;
	
	public Rules () {
		Resource.setTimeStamp(0);
		System.out.println(Resource.getTimeStamp());
		Rules.timeToSpawnAlienBonus = 0;
	}
	
	public static void isEnemyGetShoot(Enemy enemy, Ship player) {
		ArrayList<Bullet> bullets = player.getBullets();
		ArrayList<Alien> aliens = enemy.getAliens();
		Alien auxAlien;
		Bullet auxBullet;
		for (int i = 0; i < bullets.size(); i++) {
			auxBullet = bullets.get(i);
			for (int j = 0; j < aliens.size(); j++) {
				auxAlien = aliens.get(j);
				if (auxBullet.getBounds().intersects(auxAlien.getBounds())) {
					player.removeBullet(auxBullet);
					Resource.setPlayerScore(auxAlien.getPoints());
					enemy.removeAlien(auxAlien);
				}
			}
		}
	}
	
	public static void enemySpanw(Enemy enemy) {
		if (Resource.getTimeStamp() >= timeToSpawnEnemys) {
			enemy.addAlien();
			timeToSpawnAlienBonus += Resource.getTimeStamp();
			Resource.setTimeStamp(0);
		}
	}
	
	public static void enemyGetPlayer(Enemy enemy, Ship player) {
		ArrayList<Alien> aliens = enemy.getAliens();
		Alien auxAlien;
		for (int i = 0; i < aliens.size(); i++) {
			auxAlien = aliens.get(i);
			if (auxAlien.getPosY() >= Setup.WINDOW_HEIGHT - 120) {
				enemy.removeAlien(auxAlien);
				player.setLife(player.getLife() - 1);
				isPlayerLive(auxAlien, player);
			}
		}
	}
	
	private static void isPlayerLive(Alien alien, Ship player) {
		if (player.getLife() == 0) {
			Resource.isPlayerGetHighScore();
			player.setImage(player.getImageSecondary());
			player.getDirection().stop();
			player.setPosX(player.getPosX() - player.getMovX());
			Resource.isGameOver = true;
			timeToSpawnEnemys = 10;
		}
	}
	
	public static void addAlienBonus(Enemy enemy) {
		if (timeToSpawnAlienBonus >= oneMinute) {
			enemy.addAlien(-1);
			timeToSpawnAlienBonus = 0;
			degreeTimeToSpawnEnemy();
		}
	}
	
	private static void degreeTimeToSpawnEnemy() {
		if (timeToSpawnEnemys <= oneSecond) return;
		timeToSpawnEnemys -= oneSecond / 2;
	}
	
}
