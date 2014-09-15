package net.slasher.rpgclicker;

public class Armour {
	String name = "";
	String desc;
	int def = 0;
	int id = 0;
	int bv = 0;
	
	public Armour(String name, String desc, int id, int def, int bv) {
		this.name = name;
		this.desc = desc;
		this.id = id;
		this.def = def;
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
	
	public int getDEF() {
		return def;
	}
	
	public int getBV() {
		return bv;
	}
}
