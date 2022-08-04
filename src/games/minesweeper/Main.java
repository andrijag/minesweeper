package games.minesweeper;

public class Main {
	public static void main(String args[]) {
		System.out.println("Minesweeper");
		Minefield mf = new Minefield(10, 10);
		Minelayer ml = new Minelayer(mf, 9);
		Minesweeper ms = new Minesweeper(mf);
		mf.uncover(0, 0);
		ml.remove(mf.get(0, 0));
		ml.layMines();
		mf.updateValues();
		System.out.println(mf);
	}
}
