package main.java.games.minesweeper.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		JButton restartButton = new JButton("Restart");
		int padding = 10;
		setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

		JPanel header = new JPanel(new BorderLayout());
		header.add(minecount, BorderLayout.LINE_START);
		header.add(time, BorderLayout.LINE_END);

		JScrollPane minefieldScrollPane = new JScrollPane(minefield);
		int unitIncrement = 10;
		minefieldScrollPane.getVerticalScrollBar().setUnitIncrement(unitIncrement);
		minefieldScrollPane.getHorizontalScrollBar().setUnitIncrement(unitIncrement);

		JPanel footer = new JPanel();
		footer.add(restartButton);

		int minefieldScrollPanePreferredWidth = minefieldScrollPane.getPreferredSize().width;
		header.setMaximumSize(new Dimension(minefieldScrollPanePreferredWidth, header.getPreferredSize().height));
		minefieldScrollPane.setMaximumSize(minefieldScrollPane.getPreferredSize());
		footer.setMinimumSize(new Dimension(minefieldScrollPanePreferredWidth, footer.getPreferredSize().height));
		footer.setMaximumSize(new Dimension(minefieldScrollPanePreferredWidth, footer.getPreferredSize().height));

		add(Box.createVerticalGlue());
		add(header);
		add(minefieldScrollPane);
		add(footer);
		add(Box.createVerticalGlue());

		restartButton.addActionListener(event -> restart());

		int periodInMillis = 100;
		Timer timer = new Timer(periodInMillis, event -> updateTime());
		timer.start();

		FieldsMouseAdapter mouseAdapter = new FieldsMouseAdapter(game);
		for (int row = 0; row < game.getNumberOfRows(); row++)
			for (int column = 0; column < game.getNumberOfColumns(); column++)
				minefield.get(row, column).addMouseListener(mouseAdapter);
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
}
