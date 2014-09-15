package net.slasher.rpgclicker;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
	
	public static boolean ting = false;

	public static boolean isPaused = false;
	
	public Play(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		ImageLoader.initChars();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		ImageLoader.plrHud.draw(0, 0);
		
		g.drawString("Player Name: " + Player.getName(), 20, 25);
		g.drawString("HP: " + Player.getHealth() + "/" + Player.getMaxHealth(), 295, 25);
		g.drawString("ATK: " + Player.getAtk(), 464, 25);
		g.drawString("DEF: " + Player.getDef(), 635, 25);
		g.drawString("Money: " + Player.getMoney(), 20, 100);
		g.drawString("Characters: " + Player.getChars(), 295, 100);
		g.drawString("Level: " + Player.getLvl(), 464, 100);
		g.drawString("XP: " + Player.getExp() + "/" + Player.getMaxExp(), 635, 100);
		
		if(Player.getChars() == 1) {
			ImageLoader.evan.draw(350, 350);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(!isPaused) {
			Input in = gc.getInput();
			
			if(in.isKeyPressed(Input.KEY_L)) {
				Player.addExp(Player.getLvl());
			}
			if(in.isKeyPressed(Input.KEY_M)) {
				Player.addMoney(100);
			}
			if(in.isKeyPressed(Input.KEY_A)) {
				Player.health -= 1;
			}
			if(in.isKeyPressed(Input.KEY_I)) {
				isPaused = true;
				sbg.enterState(Game.inventory);
			}
			if(in.isKeyPressed(Input.KEY_ESCAPE)) {
				isPaused = true;
				sbg.enterState(Game.pauseMenu);
			}
			if(in.isKeyPressed(Input.KEY_S)) {
				isPaused = true;
				sbg.enterState(Game.shopMenu);
			}
			
			in.clearKeyPressedRecord();
		}
	}
	
	public int getID() {
		return 1;
	}
}
 