package main.java.games.minesweeper.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MinefieldView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public MinefieldView(int numberOfRows, int numberOfColumns) {
		super(new GridLayout(numberOfRows, numberOfColumns));
		
		for (int i = 0; i < numberOfColumns; i++) {
			for (int j = 0; j < numberOfRows; j++) {
				add(new JButton());
			}
		}
	}
}
