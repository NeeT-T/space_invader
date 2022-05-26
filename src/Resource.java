import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Resource {

    private static Resource instance = null;
    private BufferedImage sprite;
    private static long highScore;
    private static long playerScore = 0;
	private static long startTime = 0;
	private static long endTime = 0;
	private static long deltaTime = 0;
	private static long timeStamp = 0;
	public static boolean isGameOver = false;

    private Resource () {
    	readHighScore();
        try {
            sprite = ImageIO.read(getClass().getResource("images/Sprites/aliens.jpeg"));
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
    
	public static void tickFrame() {
		try {
			startTime = System.currentTimeMillis();
			deltaTime = startTime - endTime;
			timeStamp += deltaTime;
			endTime = startTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void isPlayerGetHighScore() {
		if (playerScore > highScore) {
			highScore = playerScore;
			writeHighScore();
		}
	}
	
	public static void setPlayerScore(long enemyPoint) {
		Resource.playerScore += enemyPoint;
	}
	
    public void hud(Graphics graphic, Ship player) {
        int i = 0;
        graphic.setColor(Color.WHITE);
        graphic.setFont(new Font("Monospaced", Font.PLAIN, 27));
        graphic.drawString("HI - SCORE" ,1100, 50);
        graphic.drawString(Long.toString(highScore), 1100, 80);
        graphic.drawString("Score < 1 >", 100, 50);
        graphic.drawString(Long.toString(playerScore), 100, 80);
        graphic.drawLine(0, Setup.WINDOW_HEIGHT-50, Setup.WINDOW_WIDTH, Setup.WINDOW_HEIGHT-50);
        graphic.drawString("LIVES: ", 10, Setup.WINDOW_HEIGHT-15);
//        graphic.drawString("Score < " + Long.toString(playerScore) + " >", 550, Setup.WINDOW_HEIGHT-15);
//        graphic.drawString("HI - SCORE < " + Long.toString(highScore) + " >", 950, Setup.WINDOW_HEIGHT-15);
        while(i < player.getLife() - 1) {
            graphic.drawImage(player.getImage(), 110 + (200 * i / 4),Setup.WINDOW_HEIGHT-42 , null);
            i++;
        }
    }
    
    public static void readHighScore() {
    	File file = new File("highscore.txt");
    	if (file.exists()) {
    		try (Scanner read = new Scanner(file)) {
    			Resource.highScore = read.nextLong();
    			read.close();
    		} catch (FileNotFoundException e) {
    		    System.out.println("An error occurred leitura.");
    			e.printStackTrace();
    		}
    	}
    }
    
    public static void writeHighScore() {
		try (FileWriter writeFile = new FileWriter("highscore.txt")) {
			File newFile = new File("highscore.txt");
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			writeFile.write(Long.toString(Resource.highScore));
			writeFile.close();
		} catch (IOException e) {
	      System.out.println("An error occurred escrita.");
	      e.printStackTrace();
	    }
    }
       
	public static long getTimeStamp() {
		return timeStamp;
	}
	
	public static void setTimeStamp(long timeStamp) {
		Resource.timeStamp = timeStamp;
	}
	
	public static long getPlayerScore() {
		return playerScore;
	}
	
}