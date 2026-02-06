package tetris;

public class View implements Observer {

	private GameGraphics graphics;

	public View(GameGraphics graphics) {
		this.graphics = graphics;
	}

	@Override
	public void stateChanged(Tetris model) {
		draw(model.field, 0, 0);
		draw(model.figure, model.posX, model.posY);
	}

	private void draw(int[][] matrix, int offsetX, int offsetY) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				graphics.drawBox(col + offsetX, row + offsetY, matrix[row][col]);
			}
		}
	}

}
