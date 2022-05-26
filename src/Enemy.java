import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
	private ArrayList<Alien> aliens;
	
	public Enemy() {
		aliens = new ArrayList<Alien>();
	}
	
	public void showEnemys(Graphics graphic) {
		Alien auxAlien;
		for (int i = 0; i < aliens.size(); i++) {
			auxAlien = aliens.get(i);
			auxAlien.draw(graphic);
		}
	}
	
	public void updateAlienPosition() {
		Alien auxAlien;
		for (int i = 0; i < aliens.size(); i++) {
			auxAlien = aliens.get(i);
			auxAlien.updateAlienPosition();
		}
	}
	
	public void addAlien() {
		aliens.add(selectAlien(new Random().nextInt(0, 6)));
	}
	
	public void addAlien(int alienId) {
		aliens.add(selectAlien(alienId));
	}
	
	public void removeAlien(Alien alien) {
		aliens.remove(alien);
	}
	
	public Alien selectAlien(int value) {
		Random rand = new Random();
		switch (value) {
		case 0:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 80), -60,
					0, 2,
					Resource.getInstance().ImageCut(205,0,280,50), Resource.getInstance().ImageCut(160,0,220,50),
					20);
		case 1:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 70), -75,
					0, 2,
					Resource.getInstance().ImageCut(0,120,50,185), Resource.getInstance().ImageCut(50,120,100,185),
					20);
		case 2:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 50), -55,
					0, 1,
					Resource.getInstance().ImageCut(0,195,75,240), Resource.getInstance().ImageCut(75,195,130,240),
					30);
		case 3:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 75), -50,
					0, 2,
					Resource.getInstance().ImageCut(128,200,190,240), Resource.getInstance().ImageCut(185,200,250,240),
					20);
		case 4:
			return new Alien(rand.nextInt(0
					, Setup.WINDOW_WIDTH - 60), -75,
					0, 1,
					Resource.getInstance().ImageCut(160,120,215,185), Resource.getInstance().ImageCut(100,120,150,185),
					30);
		case 5:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 80), -60,
					0, 1,
					Resource.getInstance().ImageCut(5,0,80,50), Resource.getInstance().ImageCut(83,0,160,50),
					30);
		default:
			return new Alien(rand.nextInt(0,
					Setup.WINDOW_WIDTH - 80), -70,
					0, 4,
					Resource.getInstance().ImageCut(0,310,79,370), Resource.getInstance().ImageCut(0,310,79,370),
					100);
		}
	}
	
	public ArrayList<Alien> getAliens() {
		return aliens;
	}
}
