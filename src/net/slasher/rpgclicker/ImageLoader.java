package net.slasher.rpgclicker;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	// Buttons {150, 53}
	public static Image playGame;
	public static Image exitGame;
	
	// HUD
	//public static Image plrHud;
	
	// Characters {32, 32}
	public static Image evan;
	public static Image lyra;
	public static Image zane;
	
	public static Image[] chars = {evan, lyra, zane};
	
	public static void initButtons() throws SlickException {
		playGame = new Image("res/images/playGameButton.png");
		exitGame = new Image("res/images/exitGameButton.png");
		//plrHud = new Image("res/images/playerStatusBar.png");
	}
	
	public static void initChars() throws SlickException {
		evan = new Image("res/chars/evan.png");
		lyra = new Image("res/chars/lyra.png");
		zane = new Image("res/chars/zane.png");
	}
}
