package net.slasher.rpgclicker;

import java.util.HashMap;


public class Inventory {
	public static HashMap<Potion, Integer> potions = new HashMap<Potion, Integer>();
	public static HashMap<Weapon, Integer> weapons = new HashMap<Weapon, Integer>();
	
	public static void initInventory() {
		for(int i=0;i<Database_Shop.potionList.size();i++) {
			potions.put(Database_Shop.potionList.get(i), 0);
		}
		
		for(int i=0;i<Database_Shop.weaponList.size();i++) {
			weapons.put(Database_Shop.weaponList.get(i), 0);
		}
		
		getPotions();
		getWeapons();
	}
	
	public static void getPotions() {
		for(int i=0;i<Database_Shop.potionList.size();i++) {
			int count = potions.get(Database_Shop.potionList.get(i));
			
			System.out.println(Database_Shop.potionList.get(i).name + ": " + count);
		}
	}
	
	public static void getWeapons() {
		for(int i=0;i<Database_Shop.weaponList.size();i++) {
			int count = weapons.get(Database_Shop.weaponList.get(i));
			
			System.out.println(Database_Shop.weaponList.get(i).name + ": " + count);
		}
	}
	
	public static void updatePotions(Potion ptn, int count) {
		int oldCount = potions.get(ptn);
		int newCount = oldCount+count;
		
		potions.put(ptn, newCount);
		
		getPotions();
	}
	
	public static void updateWeapons(Weapon wep, int count) {
		int oldCount = weapons.get(wep);
		int newCount = oldCount+count;
		
		weapons.put(wep, newCount);
		
		getWeapons();
	}
}
