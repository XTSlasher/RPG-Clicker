package net.slasher.rpgclicker;

import java.util.HashMap;

import org.jnbt.IntTag;


public class Inventory {
	public static HashMap<Potion, Integer> potions = new HashMap<Potion, Integer>();
	public static HashMap<Weapon, Integer> weapons = new HashMap<Weapon, Integer>();
	public static HashMap<Armour, Integer> armours = new HashMap<Armour, Integer>();
	
	public static void initInventoryLoad() {
		System.out.println("Loading Inventory!");
	}
	
	public static void initInventoryNew() {
		for(int i=0;i<Database_Shop.potionList.size();i++) {
			potions.put(Database_Shop.potionList.get(i), 0);
			
			if(Database_Shop.potions[i] != null) {
				Variables.potions[i] = new IntTag(Database_Shop.potions[i].name, 0);
			}
		}
		
		for(int i=0;i<Database_Shop.weaponList.size();i++) {
			weapons.put(Database_Shop.weaponList.get(i), 0);
			
			if(Database_Shop.weapons[i] != null) {
				Variables.weapons[i] = new IntTag(Database_Shop.weapons[i].name, 0);
			}
		}
		
		for(int i=0;i<Database_Shop.armourList.size();i++) {
			armours.put(Database_Shop.armourList.get(i), 0);
			
			if(Database_Shop.armours[i] != null) {
				Variables.armours[i] = new IntTag(Database_Shop.armours[i].name, 0);
			}
		}
		
		getPotions();
		getWeapons();
		getArmours();
	}
	
	public static void getPotions() {
		for(int i=0;i<Database_Shop.potionList.size();i++) {
			int count = potions.get(Database_Shop.potionList.get(i));
			
			System.out.println(Database_Shop.potionList.get(i).name + ": " + count);
		}
	}
	
	public static void updatePotions(Potion ptn, int count) {
		int oldCount = potions.get(ptn);
		int newCount = oldCount+count;
		
		potions.put(ptn, newCount);
		
		for(int i=0;i<Database_Shop.potionList.size();i++) {			
			if(Database_Shop.potions[i] != null) {
				if(Database_Shop.potions[i].name == ptn.getName()) {
					Variables.potions[i] = new IntTag(Database_Shop.potions[i].name, newCount);
				}
			}
		}
		
		getPotions();
	}
	
	public static void getWeapons() {
		for(int i=0;i<Database_Shop.weaponList.size();i++) {
			int count = weapons.get(Database_Shop.weaponList.get(i));
			
			System.out.println(Database_Shop.weaponList.get(i).name + ": " + count);
		}
	}
	
	public static void updateWeapons(Weapon wep, int count) {
		int oldCount = weapons.get(wep);
		int newCount = oldCount+count;
		
		weapons.put(wep, newCount);
		
		for(int i=0;i<Database_Shop.weaponList.size();i++) {
			if(Database_Shop.weapons[i] != null) {
				if(Database_Shop.weapons[i].getName() == wep.getName()) {
					Variables.weapons[i] = new IntTag(Database_Shop.weapons[i].getName(), newCount);
				}
			}
		}

		getWeapons();
	}
	
	public static void getArmours() {
		for(int i=0;i<Database_Shop.armourList.size();i++) {
			int count = armours.get(Database_Shop.armourList.get(i));
			
			System.out.println(Database_Shop.armourList.get(i).name + ": " + count);
		}
	}
	
	public static void updateArmour(Armour arm, int count) {
		int oldCount = armours.get(arm);
		int newCount = oldCount+count;
		
		armours.put(arm, newCount);
		
		for(int i=0;i<Database_Shop.armourList.size();i++) {
			if(Database_Shop.armours[i] != null) {
				if(Database_Shop.armours[i].getName() == arm.getName()) {
					Variables.armours[i] = new IntTag(Database_Shop.armours[i].getName(), newCount);
				}
			}
		}

		getArmours();
	}
}
