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
	private JLabel minecount = new JLabel("minecount");
	private JLabel time = new JLabel("time");
	private MinefieldView minefield;

	public View(Game game) {
		super(new BorderLayout());
		this.game = game;
		minefield = new MinefieldView(game.getNumberOfRows(), game.getNumberOfColumns());

		JPanel header = new JPanel(new BorderLayout());
		header.add(minecount, BorderLayout.LINE_START);
		header.add(time, BorderLayout.LINE_END);

		JScrollPane minefieldScrollPane = new JScrollPane(minefield);
		int unitIncrement = 10;
		minefieldScrollPane.getVerticalScrollBar().setUnitIncrement(unitIncrement);
		minefieldScrollPane.getHorizontalScrollBar().setUnitIncrement(unitIncrement);

		JButton restartButton = new JButton("Restart");

		JPanel footer = new JPanel();
		footer.add(restartButton);

		int minefieldScrollPanePreferredWidth = minefieldScrollPane.getPreferredSize().width;
		header.setMaximumSize(new Dimension(minefieldScrollPanePreferredWidth, header.getPreferredSize().height));
		minefieldScrollPane.setMaximumSize(minefieldScrollPane.getPreferredSize());
		footer.setMinimumSize(new Dimension(minefieldScrollPanePreferredWidth, footer.getPreferredSize().height));
		footer.setMaximumSize(new Dimension(minefieldScrollPanePreferredWidth, footer.getPreferredSize().height));

		JPanel panel = new JPanel(new BorderLayout());
		int padding = 10;
		panel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Box.createVerticalGlue());
		panel.add(header);
		panel.add(minefieldScrollPane);
		panel.add(footer);
		panel.add(Box.createVerticalGlue());
		add(panel, BorderLayout.CENTER);

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
