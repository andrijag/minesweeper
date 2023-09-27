package main.java.games.minesweeper.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MinefieldView extends JPanel {
	private static final long serialVersionUID = 1L;
	private FieldView[][] fieldViews;

	public MinefieldView(int numberOfRows, int numberOfColumns) {
		super(new GridLayout(numberOfRows, numberOfColumns));
		fieldViews = new FieldView[numberOfRows][numberOfColumns];

		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++) {
				fieldViews[row][column] = new FieldView(row, column);
				add(fieldViews[row][column]);
			}
		}
	}

	public FieldView get(int row, int column) {
		return fieldViews[row][column];
	}
}
