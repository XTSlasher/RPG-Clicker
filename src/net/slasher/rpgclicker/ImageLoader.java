package net.slasher.rpgclicker;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	// Buttons {150, 53}
	public static Image playGame;
	public static Image exitGame;
	
	// HUD
	public static Image plrHud;
	public static Image shop;
	public static Image pause;
	public static Image backpack;
	public static Image highLight;
	public static Image PhighLight;
	public static Image ShighLight;
	public static Image hl2;
	
	// Characters {32, 32}
	public static Image evan;
	public static Image lyra;
	public static Image zane;
	
	public static Image[] chars = {evan, lyra, zane};
	
	public static void initButtons() throws SlickException {
		playGame = new Image("res/images/playGameButton.png");
		exitGame = new Image("res/images/exitGameButton.png");
		plrHud = new Image("res/images/psb.png");
		shop = new Image("res/images/shop.png");
		pause = new Image("res/images/pauseMenu.png");
		backpack = new Image("res/images/backpack.png");
		highLight = new Image("res/images/highlight.png");
		PhighLight = new Image("res/images/highlightPause.png");
		ShighLight = new Image("res/images/highlightShop.png");
	}
	
	public static void initChars() throws SlickException {
		evan = new Image("res/chars/evan.png");
		lyra = new Image("res/chars/lyra.png");
		zane = new Image("res/chars/zane.png");
	}
}
