public class Direction {
	private boolean k_up = false;
	private boolean k_down = false;
	private boolean k_right = false;
	private boolean k_left = false;

	
	public Direction() {

	}
	
	public boolean isK_down() {
		return k_down;
	}
	
	public void setK_down(boolean k_down) {
		this.k_down = k_down;
	}
	
	public boolean isK_right() {
		return k_right;
	}
	
	public void setK_right(boolean k_right) {
		this.k_right = k_right;
	}
	
	public boolean isK_left() {
		return k_left;
	}
	
	public void setK_left(boolean k_left) {
		this.k_left = k_left;
	}
	
	public boolean isK_up() {
		return k_up;
	}
	
	public void setK_up(boolean k_up) {
		this.k_up = k_up;
	}
}