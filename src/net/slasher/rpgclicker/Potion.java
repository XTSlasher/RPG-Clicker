package net.slasher.rpgclicker;

public class Potion {
	String name = "";
	String desc;
	int hp = 0;
	int id = 0;
	int bv = 0;
	
	public Potion(String name, String desc, int id, int hp, int bv) {
		this.name = name;
		this.desc = desc;
		this.hp = hp;
		this.id = id;
		this.bv = bv;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getID() {
		return id;
	}
	
	public int getBV() {
		return bv;
	}
	
	public int getHP() {
		return hp;
	}
	
	public static void usePotion(Potion ptn) {
		System.out.println("Using: " + ptn.name);
		
		if(Player.health < Player.maxHealth) {
			Inventory.potions.put(ptn, Inventory.potions.get(ptn) - 1);
			
			Player.health += ptn.getHP();
			
			if(Player.health > Player.maxHealth) {
				Player.health = Player.maxHealth;
			}
		}
	}
}
