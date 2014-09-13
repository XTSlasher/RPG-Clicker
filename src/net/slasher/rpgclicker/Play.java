package net.slasher.rpgclicker;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
	
	public static boolean ting = false;
	
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
		g.drawString("DEF: " + Player.getAtk(), 635, 25);
		g.drawString("Money: " + Player.getMoney(), 20, 100);
		g.drawString("Characters: " + Player.getChars(), 295, 100);
		g.drawString("Level: " + Player.getLvl(), 464, 100);
		g.drawString("XP: " + Player.getExp() + "/" + Player.getMaxExp(), 635, 100);
		
		/**
		g.drawRect(50, 50, Game.charSize, Game.charSize*5);
		for(int i=0;i<5;i++) {
			g.drawLine(50, 50 + (Game.charSize*i), 50 + Game.charSize, 50 + (Game.charSize*i));
		}
		
		// 50 + (32*i) + (1*(i+1))
		ImageLoader.evan.draw(50, 50 + (32*0) + (1*1));
		*/
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		
		if(in.isKeyDown(Input.KEY_L)) {
			if(!ting) {
				ting = true;
				Player.addExp(Player.getLvl());
			}
		}
		
		ting = false;
	}
	
	public int getID() {
		return 1;
	}
}
 