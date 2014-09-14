package net.slasher.rpgclicker;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class InventoryScreen extends BasicGameState {
	
	
	public InventoryScreen(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)) {
			Play.isPaused = false;
			sbg.enterState(Game.gameScreen);
		}
	}
	
	public int getID() {
		return 4;
	}
}
 