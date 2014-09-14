package net.slasher.rpgclicker;

public class Potion {
	String name = "";
	String desc;
	int id = 0;
	int bv = 0;
	
	public Potion(String name, String desc, int id, int bv) {
		this.name = name;
		this.desc = desc;
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
}
