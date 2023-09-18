package main.java.games.minesweeper.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import main.java.games.minesweeper.model.Game;
import main.java.games.minesweeper.model.util.Observer;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private Game game;
	private JLabel minecount;
	private JLabel time;
	private MinefieldView minefield;

	public View(Game game) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.game = game;
		minecount = new JLabel("minecount");
		time = new JLabel("time");
		minefield = new MinefieldView(game.getNumberOfRows(), game.getNumberOfColumns());
		JButton restartButton = new JButton();

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));

		header.add(minecount);
		header.add(Box.createHorizontalGlue());
		header.add(restartButton);
		header.add(Box.createHorizontalGlue());
		header.add(time);

		JScrollPane minefieldScrollPane = new JScrollPane(minefield);
		minefieldScrollPane.getVerticalScrollBar().setUnitIncrement(10);
		minefieldScrollPane.getHorizontalScrollBar().setUnitIncrement(10);

		header.setMaximumSize(minefieldScrollPane.getPreferredSize());
		minefieldScrollPane.setMaximumSize(minefieldScrollPane.getPreferredSize());

		add(Box.createVerticalGlue());
		add(header);
		add(minefieldScrollPane);
		add(Box.createVerticalGlue());

		restartButton.addActionListener(event -> restart());

		int periodInMillis = 100;
		Timer timer = new Timer(periodInMillis, event -> updateTime());
		timer.start();

		for (int i = 0; i < game.getNumberOfRows(); i++) {
			for (int j = 0; j < game.getNumberOfColumns(); j++) {
				final int row = i;
				final int column = j;
				minefield.get(i, j).addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent event) {
						if (SwingUtilities.isLeftMouseButton(event))
							sweep(row, column);
						else if (SwingUtilities.isRightMouseButton(event))
							mark(row, column);
						else if (SwingUtilities.isMiddleMouseButton(event))
							chord(row, column);
						if (SwingUtilities.isLeftMouseButton(event) && event.getClickCount() == 2)
							chord(row, column);
					}
				});
			}
		}
	}

	@Override
	public void update() {
		updateMinecount();
		updateMinefield();
	}

	private void updateMinecount() {
		minecount.setText(getMinecount());
	}

	private String getMinecount() {
		return Integer.toString(game.getMinecount());
	}

	private void updateMinefield() {
		for (int row = 0; row < game.getNumberOfRows(); row++)
			for (int column = 0; column < game.getNumberOfColumns(); column++)
				minefield.get(row, column).update(game.getField(row, column));
	}

	private void updateTime() {
		time.setText(getTime());
	}

	private String getTime() {
		int millisInSecond = 1000;
		return Long.toString(game.getTime() / millisInSecond);
	}

	private void restart() {
		game.restart();
	}

	private void sweep(int row, int column) {
		game.sweep(row, column);
	}

	private void mark(int row, int column) {
		game.mark(row, column);
	}

	private void chord(int row, int column) {
		game.chord(row, column);
	}
}
