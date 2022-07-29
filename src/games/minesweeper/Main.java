package games.minesweeper;

public class Main {
	public static void main(String args[]) {
		System.out.println("Minesweeper");
		Minefield mf = new Minefield(10, 10);
		Minelayer ml = new Minelayer(mf, 9);
		mf.uncover(0, 0);
		ml.layMines();
		ml.scatterMines();
		mf.updateValues();
		System.out.println(mf);
	}
}
