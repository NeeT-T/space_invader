import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet {
    private BufferedImage image;
    private int movY;
    private int posY;
    private int posX;
    private int imageWidth;
    private int imageHeight;

    public Bullet(int posX, int posY, BufferedImage image) {
        this.posY = posY;
        this.posX = posX;
        this.movY = - 10;
        this.image = image;
        this.imageWidth = image.getWidth();
		this.imageHeight = image.getHeight();
    }
    
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, imageWidth, imageHeight);
	}
    
    public void draw(Graphics graphic) {
    	graphic.drawImage(image, posX, posY, null);
    }
    
    public void updateBulletPosition() {
    	posY = posY + movY;
    }
    
    public int getPosY() {
		return posY;
	}
    
    public void setPosY(int posY) {
		this.posY = posY;
	}
    
    public int getMovY() {
		return movY;
	}
}
