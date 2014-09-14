package net.slasher.rpgclicker;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Pause extends BasicGameState {	
	
	public static int selected = 0;
	
	public Pause(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		
		ImageLoader.pause.draw(0, 0);
		
		if(selected == 0) {
			ImageLoader.PhighLight.draw(273, 176);
		} else if(selected == 1) {
			ImageLoader.PhighLight.draw(273, 251);
		} else if(selected == 2) {
			ImageLoader.PhighLight.draw(273, 326);
		} else if(selected == 3) {
			ImageLoader.PhighLight.draw(273, 421);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		
		if(in.isKeyPressed(Input.KEY_DOWN)) {
			if(selected < 3) { selected += 1; }
		} else if(in.isKeyPressed(Input.KEY_UP)) {
			if(selected > 0) { selected -= 1; }
		}
		
		if(in.isKeyPressed(Input.KEY_SPACE) || in.isKeyPressed(Input.KEY_ENTER)) {
			if(selected == 0) {
				Play.isPaused = false;
				sbg.enterState(Game.gameScreen);
			}
			if(selected == 1) { 
				
			}
			if(selected == 2) {
				
			}
			if(selected == 3) {
				System.exit(0);
			}
		}
		
		in.clearKeyPressedRecord();
	}
	
	public int getID() {
		return 2;
	}
}
 