import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.Random;

import javax.swing.JPanel;

public class Game extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MILISECOND_PER_FRAME = 17;
	private Main_ship main_ship;
	private EnemyLastLine enemy;

	public Game() {
		setFocusable(true);
		setLayout(null);
		main_ship = new Main_ship();
		enemy = new EnemyLastLine();
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				setDirectionByKeyPressed(e, main_ship, false);
			}
			@Override 
			public void keyPressed(KeyEvent e) {
				setDirectionByKeyPressed(e, main_ship, true);
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				gameloop();
			}
		}).start();
	}
	
	public void gameloop() {
		while(true) {
			handleEvents();
			update();
			render();
			try {
				Thread.sleep(MILISECOND_PER_FRAME);
			} catch (InterruptedException e) {
				System.out.println("Erro de sleep");
			}
		}
	}
	
	public void handleEvents() {
		main_ship.moviment();
	}
	
	public void update() {
		main_ship.updateShipPosition();
		main_ship.verifyColisionOnSides();
	}
	
	public void render() {
		repaint();
	}
	
	public void setDirectionByKeyPressed(KeyEvent e, Main_ship ship, boolean value) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: ship.getDirection().setK_up(value); break;
			case KeyEvent.VK_DOWN: ship.getDirection().setK_down(value); break;
			case KeyEvent.VK_RIGHT: ship.getDirection().setK_right(value); break;
			case KeyEvent.VK_LEFT: ship.getDirection().setK_left(value); break;
		}
	}
	
	@Override
	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		setBackground(Color.BLACK);
		graphic.drawImage(main_ship.getImage(), main_ship.getPosX(), main_ship.getPosY(), null);
		Resource.hud(graphic, main_ship);
		graphic.drawImage(enemy.getImage(), enemy.getPosX(), enemy.getPosY(), null);

	}
	
}
