package main.java.games.minesweeper.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		int periodInMillis = 100;
		ActionListener timerTaskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateTime();
		    }
		};
		Timer timer = new Timer(periodInMillis, timerTaskPerformer);
		timer.start();
		
		add(header,  BorderLayout.PAGE_START);
		frame.add(minefield, BorderLayout.CENTER);
		add(frame, BorderLayout.CENTER);
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
}
