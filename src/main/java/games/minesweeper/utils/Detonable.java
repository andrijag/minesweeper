package main.java.games.minesweeper.utils;

public abstract class Detonable {
	private ExplosiveState state;

	public Detonable() {
		state = ExplosiveState.LIVE;
	}
	
	public void detonate() {
		state = ExplosiveState.DETONATED;
	}
	
	public boolean isDetonated() {
		return state == ExplosiveState.DETONATED;
	}
}
