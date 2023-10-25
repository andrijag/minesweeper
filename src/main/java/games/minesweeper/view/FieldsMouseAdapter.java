package main.java.games.minesweeper.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import main.java.games.minesweeper.model.Game;

class FieldsMouseAdapter extends MouseAdapter {
	private Game game;
	private FieldView source = null;
	private boolean leftIsPressed = false;
	private boolean rightIsPressed = false;
	private boolean middleIsPressed = false;
	private boolean leftIsReleased = true;
	private boolean rightIsReleased = true;
	private boolean middleIsReleased = true;

	FieldsMouseAdapter(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		boolean leftIsPressedEvent = SwingUtilities.isLeftMouseButton(event);
		boolean rightIsPressedEvent = SwingUtilities.isRightMouseButton(event);
		boolean middleIsPressedEvent = SwingUtilities.isMiddleMouseButton(event);

		if (leftIsPressedEvent) {
			leftIsPressed = true;
			leftIsReleased = false;
		} else if (rightIsPressedEvent) {
			rightIsPressed = true;
			rightIsReleased = false;
		} else if (middleIsPressedEvent) {
			middleIsPressed = true;
			middleIsReleased = false;
		}

		if (source == null)
			source = (FieldView) event.getSource();

		if (rightIsPressedEvent && leftIsReleased && middleIsReleased)
			mark();

		if (leftIsPressedEvent || middleIsPressedEvent)
			setPressedAndArmed(true);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		boolean leftIsReleasedEvent = SwingUtilities.isLeftMouseButton(event);
		boolean rightIsReleasedEvent = SwingUtilities.isRightMouseButton(event);
		boolean middleIsReleasedEvent = SwingUtilities.isMiddleMouseButton(event);

		if (leftIsReleasedEvent)
			leftIsReleased = true;
		else if (rightIsReleasedEvent)
			rightIsReleased = true;
		else if (middleIsReleasedEvent)
			middleIsReleased = true;

		if (source == null)
			return;

		if (leftIsPressed && leftIsReleasedEvent && rightIsReleased && middleIsReleased)
			sweep();
		else if ((leftIsPressed && rightIsPressed) && (leftIsReleasedEvent || rightIsReleasedEvent))
			chord();
		else if (middleIsPressed && middleIsReleasedEvent)
			chord();

		if (leftIsReleasedEvent || rightIsReleasedEvent || middleIsReleasedEvent) {
			leftIsPressed = false;
			rightIsPressed = false;
			middleIsPressed = false;
			setPressedAndArmed(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		source = (FieldView) event.getSource();
		if (leftIsPressed || middleIsPressed)
			setPressedAndArmed(true);
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if (leftIsPressed || middleIsPressed)
			setPressedAndArmed(false);
		source = null;
	}

	private void setPressedAndArmed(boolean isPressedAndArmed) {
		source.getModel().setPressed(isPressedAndArmed);
		source.getModel().setArmed(isPressedAndArmed);
	}

	private void sweep() {
		game.sweep(source.getRow(), source.getColumn());
	}

	private void mark() {
		game.mark(source.getRow(), source.getColumn());
	}

	private void chord() {
		game.chord(source.getRow(), source.getColumn());
	}
}
