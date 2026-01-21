package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetrisTest {

	Tetris t = new Tetris(() -> {
	});

	@Test
	public void testCreateGame() {
		assertEquals(20, t.field.length);
		assertEquals(10, t.field[0].length);
		assertEquals(4, t.figure.length);
		assertEquals(4, t.figure[0].length);
		assertEquals(0, t.posY);
		assertEquals(4, t.posX);

	}

	@Test
	public void testMoveDown() {
		assertTrue(t.canMoveDown());

		EventProcessor ep = t;
		ep.moveDown();
		assertEquals(1, t.posY);
		
		t.posY = Tetris.HEIGHT - Tetris.FIGURE_SIZE + 1;
		assertFalse(t.canMoveDown());
		
		t.moveDown();
		assertEquals(Tetris.HEIGHT - Tetris.FIGURE_SIZE + 1, t.posY);
	}

	@Test
	public void testCanFigureBePlacedAt() throws Exception {
		assertTrue(t.canFigureBePlacedAt(t.posX, t.posY));
		assertFalse(t.canFigureBePlacedAt(-2, t.posY));
		assertFalse(t.canFigureBePlacedAt(Tetris.WIDTH - Tetris.FIGURE_SIZE + 2, t.posY));
	}

	@Test
	public void testCanMoveLeftAndRight() throws Exception {
		assertTrue(t.canMoveLeft());
		assertTrue(t.canMoveRight());

		t.posX = -1;
		assertFalse(t.canMoveLeft());

		t.posX = Tetris.WIDTH - Tetris.FIGURE_SIZE + 1;
		assertFalse(t.canMoveRight());
	}

	@Test
	public void testMoveLeftRight() throws Exception {
		t.moveLeft();
		assertEquals(Tetris.INITIAL_POS_X - 1, t.posX);
		t.moveRight();
		assertEquals(Tetris.INITIAL_POS_X, t.posX);

		t.posX = -1;
		t.moveLeft();
		assertEquals(-1, t.posX);

		t.posX = Tetris.WIDTH - Tetris.FIGURE_SIZE + 1;
		t.moveRight();
		assertEquals(Tetris.WIDTH - Tetris.FIGURE_SIZE + 1, t.posX);
	}

}
