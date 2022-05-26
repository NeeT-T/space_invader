import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Ship {
	
	private int posX;
	private int posY;
	private int life;
	private int imageWidth;
	private int imageHeight;
	private int movX;
	private int movY;
	private ArrayList<Bullet> bullets;
	private BufferedImage image;
	private BufferedImage imageSecondary;
	private Direction direction;
	
	public Ship() {
		this.image = Resource.getInstance().ImageCut(75, 330, 120, 370);
		this.imageSecondary = Resource.getInstance().ImageCut(120,330,188,370);
		this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
		this.posX = Setup.WINDOW_WIDTH / 2 - imageWidth / 2;
		this.posY = Setup.WINDOW_HEIGHT - imageHeight - 50;
		this.life = 3;
		this.bullets = new ArrayList<Bullet>();
		this.direction = new Direction();
	}
	
	public void moviment() {
		if (direction.isK_right() == true) {
			movX = 7;
		} else if (direction.isK_left() == true) {
			movX = -7;
		} else {
			movX = 0;
		}
	}

	
	public void draw(Graphics graphic) {
		graphic.drawImage(image, posX, posY, null);
		showBullet(graphic);
	}
	
	public void verifyColisionOnSides() {
		if (posX + imageWidth >= Setup.WINDOW_WIDTH || posX <= 0) {
			posX = posX - movX;
		}
	}
	
	public void updateBulletPosition() {
		Bullet auxBullet;
		for (int i = 0; i < bullets.size(); i++) {
			auxBullet = bullets.get(i);
			if (auxBullet.getPosY() <= 0) {
				removeBullet(auxBullet);
			}
			auxBullet.updateBulletPosition();
		}
	}
	
	public void showBullet(Graphics graphic) {
		Bullet auxBullet;
		for (int i = 0; i < bullets.size(); i++) {
			auxBullet = bullets.get(i);
			auxBullet.draw(graphic);
		}
	}
	
	public void addBullet() {
		if (bullets.size() < 3)
			bullets.add(new Bullet(this.getPosX() + (this.getImageWidth() / 2) - 1, this.getPosY(), Resource.getInstance().ImageCut(45, 45, 48, 50)));
	}
	
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public void updateShipPosition() {
		posX = posX + movX;
		posY = posY + movY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getImageHeight() {
		return imageHeight;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getMovX() {
		return movX;
	}
	
	public void setMovX(int movX) {
		this.movX = movX;
	}
	
	public int getMovY() {
		return movY;
	}
	
	public void setMovY(int movY) {
		this.movY = movY;
	}
	
	public Direction getDirection() {
		return direction;
	}

	
	public BufferedImage getImageSecondary() {
		return imageSecondary;
	}

	public void setImageSecondary(BufferedImage imageSecondary) {
		this.imageSecondary = imageSecondary;
	}
	
}