import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Ship {
	
	protected int posX;
	protected int posY;
	protected int life;
	protected int imageWidth;
	protected int imageHeight;
	protected int movX;
	protected int movY;
	protected BufferedImage image;
	
	public Ship(BufferedImage image, int posX, int posY, int life) {
		this.image = image;
		this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
		this.posX = posX;
		this.posY = posY;
		this.life = life;
	}
	
	public void verifyColisionOnSides() {
		if (posX + imageWidth >= Setup.WINDOW_WIDTH || posX <= 0) {
			posX = posX - movX;
		}
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
	
}