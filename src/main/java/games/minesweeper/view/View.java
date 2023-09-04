package main.java.games.minesweeper.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		super(new BorderLayout());
		this.game = game;
		
		JPanel header = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		
		minecount = new JLabel("minecount");
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		header.add(minecount, c);
		
		JButton restartButton = new JButton();
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 0;
		header.add(restartButton, c);

		time = new JLabel("time");
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 2;
		c.gridy = 0;
		header.add(time, c);
		
		JPanel frame = new JPanel(new BorderLayout());
		minefield = new MinefieldView(game.getNumberOfRows(), game.getNumberOfColumns());
		frame.add(minefield, BorderLayout.CENTER);

		add(header,  BorderLayout.PAGE_START);
		add(frame, BorderLayout.CENTER);

		int periodInMillis = 100;
		Timer timer = new Timer(periodInMillis, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				updateTime();
		    }
		});
		timer.start();
		
		restartButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent event) {
				restart();
			}
		});
		
		for (int row = 0; row < game.getNumberOfRows(); row++) {
			for (int column = 0; column < game.getNumberOfRows(); column++) {
				FieldView fieldview = minefield.get(row, column);
				fieldview.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent event) {
						int row = fieldview.getRow();
						int column = fieldview.getColumn();
						if (SwingUtilities.isLeftMouseButton(event))
							sweep(row, column);
						else if (SwingUtilities.isRightMouseButton(event))
							mark(row, column);
						else if (SwingUtilities.isMiddleMouseButton(event))
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
