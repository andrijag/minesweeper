package main.java.games.minesweeper.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

class MinefieldView extends JPanel {
	private static final long serialVersionUID = 1L;
	private FieldView[][] fieldViews;

	MinefieldView(int numberOfRows, int numberOfColumns) {
		super(new GridLayout(numberOfRows, numberOfColumns));
		fieldViews = new FieldView[numberOfRows][numberOfColumns];

		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++) {
				fieldViews[row][column] = new FieldView(row, column);
				add(fieldViews[row][column]);
			}
		}
	}

	FieldView get(int row, int column) {
		return fieldViews[row][column];
	}
}
