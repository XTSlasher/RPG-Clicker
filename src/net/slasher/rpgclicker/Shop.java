package net.slasher.rpgclicker;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Shop extends BasicGameState {
	
	public static int selected = 0;
	public static int subSelected = 1;
	public static int count = 1;
	public static int cost = 0;
	public static boolean inSubMenu = false;
	public static boolean isBuying = false;
	public static boolean cantBuy = false;
	public static String status = "Not Enought Money";
	
	Font font;
	TrueTypeFont ttf;
	
	public Shop(int id) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		font = new Font("Veranda", Font.BOLD, 20);
		ttf = new TrueTypeFont(font, true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		ImageLoader.shop.draw(0, 0);
		
		if(selected == 0) {	
			ImageLoader.highLight.draw(0, 99);
			
			for(int i=0;i<Database_Shop.potionList.size();i++) {
				g.drawString(i+1 + ") " + Database_Shop.potionList.get(i).name, 15, 100 + 40 + (35*i));
				
				g.drawString("Cost: " + Database_Shop.getCost(Database_Shop.potionList.get(i).bv, Player.getLvl()), 175, 100 + 40 + (35*i));
				
				if(inSubMenu) {
					ImageLoader.ShighLight.draw(2, 100 + (35*subSelected));
					
					ttf.drawString(15, 525, "Description: " + Database_Shop.potionList.get(subSelected-1).desc);
					
					if(isBuying) {
						ttf.drawString(550, 215, Database_Shop.potionList.get(subSelected-1).name);
						ttf.drawString(550, 250, "Buying: x" + count);
						ttf.drawString(550, 285, "Cost: " + (Database_Shop.getCost(Database_Shop.potionList.get(subSelected-1).bv, Player.getLvl()) * count));
						ttf.drawString(625, 350, "BUY");
						if(cantBuy) {
							ttf.drawString(550, 385, status);
						}
						
						ImageLoader.highLight.draw(550, 345);
					}
				}
			}
			
		} else if(selected == 1) {
			ImageLoader.highLight.draw(200, 99);
			
			for(int i=0;i<Database_Shop.weaponList.size();i++) {
				g.drawString(i+1 + ") " + Database_Shop.weaponList.get(i).name, 15, 100 + 40 + (35*i));
				
				g.drawString("Cost: " + Database_Shop.getCost(Database_Shop.weaponList.get(i).bv, Player.getLvl()), 175, 100 + 40 + (35*i));

				if(inSubMenu) {
					ImageLoader.ShighLight.draw(2, 100 + (35*subSelected));
					
					ttf.drawString(15, 525, "Description: " + Database_Shop.weaponList.get(subSelected-1).desc);
					
					if(isBuying) {
						ttf.drawString(550, 215, Database_Shop.weaponList.get(subSelected-1).name);
						ttf.drawString(550, 250, "Buying: x" + count);
						ttf.drawString(550, 285, "Cost: " + (Database_Shop.getCost(Database_Shop.weaponList.get(subSelected-1).bv, Player.getLvl()) * count));
						ttf.drawString(625, 350, "BUY");
						
						ImageLoader.highLight.draw(550, 345);
					}
				}
			}
		} else if(selected == 2) {
			ImageLoader.highLight.draw(400, 99);
		} else if(selected == 3) {
			ImageLoader.highLight.draw(600, 99);
		}
		
		g.destroy();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {		
		Input in = gc.getInput();
		
		if(!inSubMenu && !isBuying) {
			if(in.isKeyPressed(Input.KEY_RIGHT)) {
				if(selected < 3) { selected += 1; }
			} else if(in.isKeyPressed(Input.KEY_LEFT)) {
				if(selected > 0) { selected -= 1; }
			}
		} else if(isBuying) {
			if(in.isKeyPressed(Input.KEY_RIGHT)) {
				if(count < 99) { count += 1; }
			} else if(in.isKeyPressed(Input.KEY_LEFT)) {
				if(count > 1) { count -= 1; }
			}
		}
		
		if(inSubMenu && (isBuying == false)) {
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
			if(!inSubMenu) {
				inSubMenu = true;
			} else if(inSubMenu && !isBuying) {
				if(!isBuying) {
					isBuying = true;
				}
			} else if(inSubMenu && isBuying) {
				cost = Database_Shop.getCost(Database_Shop.potionList.get(subSelected-1).bv, Player.getLvl()) * count;
				
				if(Player.getMoney() >= cost) {
					isBuying = false;
					Player.loseMoney(cost);
					cost = 0;
					
					if(selected == 0) {
						Inventory.updatePotions(Database_Shop.potionList.get(subSelected-1), count);
					}
					if(selected == 1) {
						Inventory.updateWeapons(Database_Shop.weaponList.get(subSelected-1), count);
					}					

					count = 1;
					cantBuy = false;
				} else {
					cantBuy = true;
				}
			}
		}
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)) {
			if(!inSubMenu) {
				Play.isPaused = false;
				sbg.enterState(Game.gameScreen);
			} else if(inSubMenu && !isBuying) {
				inSubMenu = false;
				subSelected = 1;
			} else if(inSubMenu && isBuying){
				isBuying = false;
				count = 1;
				cantBuy = false;
			}
		}
		
		in.clearKeyPressedRecord();
	}
	
	public int getID() {
		return 3;
	}
}
 