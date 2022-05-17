
public class Main_ship extends Ship{
		
		private Direction direction;

		public Main_ship() {
			super(
				Resource.getInstance().ImageCut(150, 600, 220, 695),
				Setup.WINDOW_WIDTH / 2 - 70 / 2,
				Setup.WINDOW_HEIGHT - 95,
				3
				);
			direction = new Direction();
		}
		
		public void moviment() {
			if (direction.isK_right() == true) {
				movX = +3;
			} else if (direction.isK_left() == true) {
				movX = -3;
			} else {
				movX = 0;
			}
		}
		
		public Direction getDirection() {
			return direction;
		}
}
