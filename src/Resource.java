import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	
	private static Resource instance = null;
	private BufferedImage sprite;
	public static int hi_score = 0;
	public static int player_score = 0;
	
	private Resource () {
		try {
			sprite = ImageIO.read(getClass().getResource("images/Sprites/ships_sprites.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Resource getInstance() {
		if (instance == null) instance = new Resource();
		return instance;
	}
	
	public BufferedImage ImageCut(int topLeftX, int topLeftY, int downRightX, int downRightY) {
		int width = downRightX - topLeftX;
		int height = downRightY - topLeftY;
		return sprite.getSubimage(topLeftX, topLeftY, width, height);
	}
	
	public static void hud(Graphics graphic, Main_ship main_ship) {
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("Monospaced", Font.PLAIN, 27)); 
		graphic.drawString("Lives <" + main_ship.getLife() + ">",  1100, 50);
		graphic.drawString("HI - SCORE", 550, 50);
		graphic.drawString(Integer.toString(hi_score), 550, 80);
		graphic.drawString("Score < 1 >", 100, 50);
		graphic.drawString(Integer.toString(player_score), 100, 80);
	}

}
