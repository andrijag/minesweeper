package main.java.games.minesweeper;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import main.java.games.minesweeper.model.Game;

public class Main {
	public static class Application implements Runnable {
		@Override
		public void run() {
			Game game = new Game(9, 9, 10);
			game.sweep(0, 0);
			game.mark(8, 8);
			game.sweep(8, 0);
			System.out.println(game);
			
			JFrame frame = new JFrame();
			frame.setLocation(100, 100);
			frame.setSize(300, 200);
			frame.setTitle("Minesweeper");
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Application());
	}
}
