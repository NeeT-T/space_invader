import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Setup {

	public static final int WINDOW_WIDTH = 1350;
	public static final int WINDOW_HEIGHT = 690;
	
	public Setup() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		
		JFrame window = new JFrame("Night Survivor");
		Game game = new Game();

		game.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setResizable(false);
		window.getContentPane().add(game);
		
//		window.setLocation((screenWidth / 2) - (WINDOW_WIDTH / 2),
//				(screenHeight / 2) - (WINDOW_HEIGHT / 2));

		window.pack();
		window.setVisible(true);

	}
	
	public static void main(String[] args) { new Setup(); }
}