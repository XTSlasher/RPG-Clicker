package net.slasher.rpgclicker;

import java.awt.Font;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class InventoryScreen extends BasicGameState {
	
	public static int selected = 0;
	public static int subSelected = 1;
	public static boolean inSubMenu = false;
	
	public static int[] totalAtk = {};
	
	Font font;
	TrueTypeFont ttf;
	
	public InventoryScreen(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		font = new Font("Veranda", Font.BOLD, 20);
		ttf = new TrueTypeFont(font, true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		ImageLoader.backpack.draw(0, 0);
		
		if(selected == 0) {	
			ImageLoader.highLight.draw(0, 99);
			
			for(int i=0;i<Database_Shop.potionList.size();i++) {
				ttf.drawString(15, 100 + 40 + (35*i), i+1 + ") " + Database_Shop.potionList.get(i).name);
				
				ttf.drawString(175, 100 + 40 + (35*i), "Owned: " + Inventory.potions.get(Database_Shop.potionList.get(i)));
			}
			
			if(inSubMenu) {
				ImageLoader.ShighLight.draw(2, 100 + (35*subSelected));
				
				ttf.drawString(15, 525, "Description: " + Database_Shop.potionList.get(subSelected-1).desc);
			}
		} else if(selected == 1) {
			ImageLoader.highLight.draw(200, 99);
			
			for(int i=0;i<Database_Shop.weaponList.size();i++) {
				ttf.drawString(15, 100 + 40 + (35*i), i+1 + ") " + Database_Shop.weaponList.get(i).name);
				
				ttf.drawString(175, 100 + 40 + (35*i), "Owned: " + Inventory.weapons.get(Database_Shop.weapons[i]));
			}
			
			for(int i=0;i<Inventory.weapons.size();i++) {
				int count = Inventory.weapons.get(Database_Shop.weapons[i]);
				
				int totalAtk = Database_Shop.weapons[i].getATK() * count;
				
				ttf.drawString(300, 100 + 40 + (35*i), "Total ATK: " + totalAtk);
			}
			
			for(int i=0;i<5;i++) {
				g.drawLine(300, 100 + 40 + (35*Inventory.weapons.size())-i, 450, 100 + 40 + (35*Inventory.weapons.size())-i);
			}
			ttf.drawString(300, 100 + 40 + (35*Inventory.weapons.size()), "ATK: " + Player.getAtk());
		} else if(selected == 2) {
			ImageLoader.highLight.draw(400, 99);
			
			for(int i=0;i<Database_Shop.armourList.size();i++) {
				ttf.drawString(15, 100 + 40 + (35*i), i+1 + ") " + Database_Shop.armourList.get(i).name);
				
				ttf.drawString(175, 100 + 40 + (35*i), "Owned: " + Inventory.armours.get(Database_Shop.armours[i]));
			}
			
			for(int i=0;i<Inventory.armours.size();i++) {
				int count = Inventory.armours.get(Database_Shop.armours[i]);
				
				int totalDef = Database_Shop.armours[i].getDEF() * count;
				
				ttf.drawString(300, 100 + 40 + (35*i), "Total DEF: " + totalDef);
			}
			
			for(int i=0;i<5;i++) {
				g.drawLine(300, 100 + 40 + (35*Inventory.armours.size())-i, 450, 100 + 40 + (35*Inventory.armours.size())-i);
			}
			ttf.drawString(300, 100 + 40 + (35*Inventory.armours.size()), "DEF: " + Player.getDef());
		} else if(selected == 3) {
			ImageLoader.highLight.draw(600, 99);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		
		if(!inSubMenu) {
			if(in.isKeyPressed(Input.KEY_RIGHT)) {
				if(selected < 3) { selected += 1; }
			} else if(in.isKeyPressed(Input.KEY_LEFT)) {
				if(selected > 0) { selected -= 1; }
			}
		}
		
		if(inSubMenu) {
			if(in.isKeyPressed(Input.KEY_DOWN)) {
				if(selected == 0) {
					if(subSelected < Database_Shop.potionList.size()) {
						subSelected += 1;
					}
				}
				if(selected == 1) {
					if(subSelected < Database_Shop.weaponList.size()) {
						subSelected += 1;
					}
				}
			} else if(in.isKeyPressed(Input.KEY_UP)) {
				if(selected == 0) {
					if(subSelected > 1) {
						subSelected -= 1;
					}
				}
				if(selected == 1) {
					if(subSelected > 1) {
						subSelected -= 1;
					}
				}
			}
		}
		
		if(in.isKeyPressed(Input.KEY_SPACE) || in.isKeyPressed(Input.KEY_ENTER)) {
			if(inSubMenu) {
				if(selected == 0) {
					for(int i=0;i<Database_Shop.potionList.size();i++) {
						if(subSelected-1 == i) {
							if(Inventory.potions.get(Database_Shop.potionList.get(i)) > 0) {
								Potion.usePotion(Database_Shop.potions[Database_Shop.potionList.get(i).id]);
							}
						}
					}
				}
			}
			if(!inSubMenu && selected == 0) {
				inSubMenu = true;
			}
		}
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)) {
			if(!inSubMenu) {
				Play.isPaused = false;
				sbg.enterState(Game.gameScreen);
			} else if(inSubMenu) {
				inSubMenu = false;
				subSelected = 1;
			}
		}
		
		in.clearKeyPressedRecord();
	}
	
	public int getID() {
		return 4;
	}
}
 