package net.slasher.rpgclicker;

import javax.swing.JOptionPane;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Object message = "Please Input Desired Name";
	Object playerName = "Player1";
	public static User plr;
	
	public Menu(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		ImageLoader.initButtons();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Defenders of 2D RPG!", (Game.width / 2) - 75, 50);
		ImageLoader.playGame.draw(Game.width / 2 - 75, 100);
		ImageLoader.exitGame.draw(Game.width / 2 - 75, 175);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		// Play Button
		if((xpos > ((Game.width / 2) - 75) && (xpos < ((Game.width / 2) - 75) + 150)) && ((ypos > Game.height - (100 + 53)) && (ypos < Game.height - 100))) {
			if(Mouse.isButtonDown(0)) {
				if(Load.checkIfSave()) {
					Object newGame = JOptionPane.showInputDialog(null, "Do you want to start a NEW game?!", "New Game?", JOptionPane.YES_NO_OPTION, null, new Object[]{"Yes",  "No"}, "No");
					String choice = newGame.toString();
					
					if(choice == "Yes") {
						String name = JOptionPane.showInputDialog(null, message, playerName);
						plr = new User(name, 0, 10, 10, 1, 1, 1, 0, 0, 1, true);
					} else {
						Load.load();
					}
				} else {
					String name = JOptionPane.showInputDialog(null, message, playerName);
					plr = new User(name, 0, 10, 10, 1, 1, 1, 0, 0, 1, true);
				}	
				
				sbg.enterState(1);
			}
		}
		
		// Exit Button
		if((xpos > ((Game.width / 2) - 75) && (xpos < ((Game.width / 2) - 75) + 150)) && ((ypos > Game.height - (175 + 53)) && (ypos < Game.height - 175))) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
		in.clearKeyPressedRecord();
	}
	
	public int getID() {
		return 0;
	}
}
 