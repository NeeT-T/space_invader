import java.awt.image.BufferedImage;

public class EnemyLastLine extends Ship {
	
	private boolean isFirst;
	
	public EnemyLastLine() {
		super(
				Resource.getInstance().ImageCut(360, 0, 520, 250),
				0,
				300,
				1
				);
		// TODO Auto-generated constructor stub
	}
	
}
