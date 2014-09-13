package net.slasher.rpgclicker;

public class Weapon {
	String name = "";
	String desc;
	int atk = 0;
	int id = 0;
	int bv = 0;
	
	public Weapon(String name, String desc, int id, int atk, int bv) {
		this.name = name;
		this.desc = desc;
		this.id = id;
		this.atk = atk;
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
	
	public int getATK() {
		return atk;
	}
	
	public int getBV() {
		return bv;
	}
}
