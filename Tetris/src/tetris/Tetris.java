package tetris;

public class Tetris implements EventProcessor {

	static final int INITIAL_POS_X = 4;
	static final int INITIAL_POS_Y = 0;
	static final int FIGURE_SIZE = 4;
	static final int WIDTH = 10;
	static final int HEIGHT = 20;

	private static final int[][] L = {
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0},
	};
	
	
	public int[][] field = new int[HEIGHT][WIDTH];
	public int[][] figure = L;
	public int posY = INITIAL_POS_Y;
	public int posX = INITIAL_POS_X;
	private Observer observer;
	
	public Tetris(Observer o) {
		observer = o;
	}

	@Override
	public void moveDown() {
		if (!canMoveDown()) { // guard condition
			return;
		}
		posY++;
		observer.stateChanged(this);
	}

	public boolean canMoveDown() {
		return canFigureBePlacedAt(posX, posY + 1);
	}

	boolean canFigureBePlacedAt(int x, int y) {
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] == 0) {
					continue;
				}
				if (y + i >= Tetris.HEIGHT) {
					return false;
				}
				if (x + j < 0) {
					return false;
				}
				if (x + j >= Tetris.WIDTH) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void moveLeft() {
		if (canMoveLeft()) {
			posX--;
		}
	}

	@Override
	public void moveRight() {
		if (canMoveRight()) {
			posX++;
		}
	}

	public boolean canMoveLeft() {
		return canFigureBePlacedAt(posX - 1, posY);
	}

	public boolean canMoveRight() {
		return canFigureBePlacedAt(posX + 1, posY);
	}

}
