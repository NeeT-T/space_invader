import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Game extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MILISECOND_PER_FRAME = 17;
	private Ship player;
	private Enemy enemy;
	boolean check = true;
	
	public Game() {
		setFocusable(true);
		setLayout(null);
		player = new Ship();
		enemy = new Enemy();

		addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
					setDirectionByKeyPressed(e, player, false);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (!Resource.isGameOver)
					setDirectionByKeyPressed(e, player, true);
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Resource.isGameOver)
					setShoot(e, player);
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

	@Override
	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		setBackground(Color.BLACK);
		Resource.getInstance().hud(graphic, player);
		player.draw(graphic);
		enemy.showEnemys(graphic);
	}
	
	public void handleEvents() {
		player.moviment();
	}
	
	public void update() {
		Resource.tickFrame();
		gameRules();
		
		player.updateShipPosition();
		player.updateBulletPosition();
		player.verifyColisionOnSides();
		
		enemy.updateAlienPosition();
	}
	
	public void gameRules() {
		if (check) {
			Resource.setTimeStamp(0);
			check = !check;
		}
		Rules.enemySpanw(enemy);
		Rules.isEnemyGetShoot(enemy, player);
		Rules.enemyGetPlayer(enemy, player);
		Rules.addAlienBonus(enemy);
	}
	
	public void render() {
		repaint();
	}
	
	public void setDirectionByKeyPressed(KeyEvent e, Ship ship, boolean value) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: ship.getDirection().setK_up(value); break;
			case KeyEvent.VK_DOWN: ship.getDirection().setK_down(value); break;
			case KeyEvent.VK_RIGHT: ship.getDirection().setK_right(value); break;
			case KeyEvent.VK_LEFT: ship.getDirection().setK_left(value); break;
		}
	}
	
	public void setShoot(KeyEvent e, Ship ship) {
		if (e.getKeyChar() == ' ') {
			ship.addBullet();
		}
	}
	

	
}
