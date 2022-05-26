import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Alien {

	private BufferedImage image;
	private BufferedImage imageSecondary;
	private int imageWidth;
	private int imageHeight;
	private int imageSecondaryWidth;
	private int imageSecondaryHeight;
	private int posY;
	private int posX;
	private int movY;
	private int movX;
	private int points;
	
	public Alien (int posX, int posY, int movX, int movY, BufferedImage image, BufferedImage imageSecondary, int points) {
		this.image = image;
		this.imageSecondary = imageSecondary;
		this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
		this.imageSecondaryWidth = imageSecondary.getWidth();
		this.imageSecondaryHeight = imageSecondary.getHeight();
		this.movX = movX;
		this.movY = movY;
		this.posX = posX;
		this.posY = posY;
		this.points = points;
	}
	
	public void updateAlienPosition() {
		if (posY % 100 == 0) {
			changeImages();
		}
		posY = posY + movY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, imageWidth, imageHeight);
	}
	
	public void draw(Graphics graphic) {
		graphic.drawImage(image, posX, posY, null);
	}
	
	public void changeImages() {
		BufferedImage img = imageSecondary;
		int auxWidth = imageSecondaryWidth;
		int auxHeight = imageSecondaryHeight;
		
		imageSecondaryWidth = imageWidth;
		imageSecondaryHeight = imageHeight;
		imageSecondary = image;
		
		image = img;
		imageHeight = auxHeight;
		imageWidth = auxWidth;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
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
	
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	public int getImageHeight() {
		return imageHeight;
	}
	
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public void setMovX(int movX) {
		this.movX = movX;
	}
	
	public int getMovX() {
		return movX;
	}
	
	public void setMovY(int movY) {
		this.movY = movY;
	}
	
	public int getMovY() {
		return movY;
	}

	
	public int getImageSecondaryWidth() {
		return imageSecondaryWidth;
	}

	
	public void setImageSecondaryWidth(int imageSecondaryWidth) {
		this.imageSecondaryWidth = imageSecondaryWidth;
	}

	public int getImageSecondaryHeight() {
		return imageSecondaryHeight;
	}

	public void setImageSecondaryHeight(int imageSecondaryHeight) {
		this.imageSecondaryHeight = imageSecondaryHeight;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
}
