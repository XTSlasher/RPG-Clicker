package net.slasher.rpgclicker;

import java.util.ArrayList;


public class Database_Shop {
	public static int cost = 0;
	
	// Health Potions
	public static Potion[] potions = new Potion[100];
	public static ArrayList<Potion> potionList = new ArrayList<Potion>();
	public static Potion potion;
	public static Potion Hpotion;
	public static Potion Mpotion;
	public static Potion Upotion;
	
	// Weapons
	public static Weapon[] weapons = new Weapon[100];
	public static ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	public static Weapon stick;
	public static Weapon staff;
	public static Weapon rod;
	public static Weapon refinedRod;
	public static Weapon magicRod;
	public static Weapon dagger;
	public static Weapon shortSword;
	public static Weapon longSword;
	public static Weapon broadSword;
	public static Weapon greatSword;
	
	// Armour
	public static Armour[] armours = new Armour[100];
	public static ArrayList<Armour> armourList = new ArrayList<Armour>();
	public static Armour cottonShirt;
	public static Armour leatherVest;
	public static Armour ironPlate;
	public static Armour steelPlate;
	public static Armour royalArmour;
	public static Armour titaniumPlate;
	
	public static void initArmour() {
		armourList.clear();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Initializing Armour!");
		cottonShirt = new Armour("Cotton Shirt", "100% Cotton.", 0, 1, 4);
		leatherVest = new Armour("Leather Vest", "Eat moar chicken!", 1, 3, 7);
		ironPlate = new Armour("Iron Plate", "Knight 'n Shinin' Armour.", 2, 7, 16);
		steelPlate = new Armour("Steel Plate", "", 3, 11, 23);
		royalArmour = new Armour("Royal Armour", "Feel like a king?", 4, 18, 33);
		titaniumPlate = new Armour("Titanium Plate", "", 5, 25, 56);
		
		armourList.add(cottonShirt);
		armourList.add(leatherVest);
		armourList.add(ironPlate);
		armourList.add(steelPlate);
		armourList.add(royalArmour);
		armourList.add(titaniumPlate);
		
		for(int i=0;i<armourList.size();i++) {
			armours[i] = armourList.get(i);
		}
		
		checkListArmour();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Armour Setup Complete.");
	}
	
	public static void checkListArmour() {
		System.out.println("Checking Armour");
		for(int i=0;i<armours.length;i++) {
			if(armours[i] != null) {
				System.out.println(i + ") " + armours[i].name);
			}
		}
	}
	
	public static void initWeapons() {
		weaponList.clear();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Initializing Weapons!");
		stick = new Weapon("Stick", "Twig.. Hmm.", 0, 1, 7);
		staff = new Weapon("Staff", "Branch maybe?", 1, 2, 15);
		rod = new Weapon("Rod", "", 2, 4, 31);
		refinedRod = new Weapon("Refined Rod", "", 3, 6, 46);
		magicRod = new Weapon("Magic Rod", "", 4, 10, 57);
		dagger = new Weapon("Dagger", "Dull Metal Blade", 5, 4, 17);
		shortSword = new Weapon("Short Sword", "Easy to wield sword", 6, 6, 29);
		longSword = new Weapon("Long Sword", "Dual handed sword", 7, 10, 50);
		broadSword = new Weapon("Broad Sword", "Heavy Sword", 8, 15, 71);
		greatSword = new Weapon("Great Sword", "Sword", 9, 21, 84);
		
		weaponList.add(stick);
		weaponList.add(staff);
		weaponList.add(rod);
		weaponList.add(refinedRod);
		weaponList.add(magicRod);
		weaponList.add(dagger);
		weaponList.add(shortSword);
		weaponList.add(longSword);
		weaponList.add(broadSword);
		weaponList.add(greatSword);
		
		for(int i=0;i<weaponList.size();i++) {
			weapons[i] = weaponList.get(i);
		}
		
		checkListWeapon();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Weapon Setup Complete.");
	}
	
	public static void checkListWeapon() {		
		for(int i=0;i<weapons.length;i++) {
			if(weapons[i] != null) {
				System.out.println(i + ") " + weapons[i].name);
			}
		}
	}
	
	public static void initPotions() {
		potionList.clear();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Initializing Potions!");
		potion = new Potion("Potion", "Heal +10 HP", 0, 10, 10);
		Hpotion = new Potion("H-Potion", "Heal +17 HP", 1, 17, 23);
		Mpotion = new Potion("M-Potion", "Heal +30 HP", 2, 30, 41);
		Upotion = new Potion("U-Potion", "Heal +50 HP", 3, 50, 76);
		
		potionList.add(potion);
		potionList.add(Hpotion);
		potionList.add(Mpotion);
		potionList.add(Upotion);
		
		for(int i=0;i<potionList.size();i++) {
			potions[i] = potionList.get(i);
		}
		
		checkListPotion();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Potion Setup Complete.");
	}
	
	public static void checkListPotion() {		
		for(int i=0;i<potions.length;i++) {
			if(potions[i] != null) {
				System.out.println(i + ") " + potions[i].name);
			}
		}
	}

	public static int getCost(int bv, int lvl) {
		cost = (bv*lvl)+(lvl*2)+bv;
		
		return cost;
	}
}
