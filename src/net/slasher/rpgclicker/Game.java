package net.slasher.rpgclicker;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	public static final int height = 600;
	public static final int width = 800;
	public static final int charSize = 33;
	
	public static Game game;
	
	public static final String gameName = "RPG-Clicker";
	public static final int mainMenu = 0;
	public static final int gameScreen = 1;
	public static final int pauseMenu = 2;
	public static final int shopMenu = 3;
	
	public Game(String gameName) throws SlickException {
		super(gameName);
		
		game = this;
		
		this.addState(new Menu(mainMenu));
		this.addState(new Play(gameScreen));
		this.addState(new Pause(pauseMenu));
		this.addState(new Shop(shopMenu));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(gameScreen).init(gc, this);
		this.getState(pauseMenu).init(gc, this);
		this.getState(shopMenu).init(gc, this);
		
		this.enterState(mainMenu);
	}
	
	public static void main(String[] args) {
		AppGameContainer agc;
		
		try {
			agc = new AppGameContainer(new Game(gameName));
			agc.setDisplayMode(800, 600, false);
			agc.setShowFPS(false);
			agc.start();
		} catch(SlickException se) {
			se.printStackTrace();
		}
	}
}
