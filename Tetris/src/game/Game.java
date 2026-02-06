package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.Tetris;
import tetris.View;

public class Game {

	private static final int TILE_SIZE = 40;
	private static final Color[] COLORS = { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN,
			Color.MAGENTA };

	public static void main(String[] args) {

		JFrame f = new JFrame("Tetris");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 800);
		f.setResizable(false);
		JPanel p = new JPanel();
		f.getContentPane().add(p);
		f.setVisible(true);

		p.setFocusable(true);
		p.requestFocusInWindow();

		Graphics g = p.getGraphics();

		View view = new View((x, y, color) -> {
			g.setColor(COLORS[color]);
			g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		});

		Tetris tetris = new Tetris(view);

		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					System.out.println("Left");
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("Right");
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("Down");
					break;
				case KeyEvent.VK_UP:
					System.out.println("Up");
					break;
				}
			}

		});

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tetris.moveDown();
			}
		}).start();

	}

}
