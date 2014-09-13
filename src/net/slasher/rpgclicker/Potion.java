package net.slasher.rpgclicker;

public class Potion {
	String name = "";
	String desc;
	int id = 0;
	
	public Potion(String name, String desc, int id) {
		this.name = name;
		this.desc = desc;
		this.id = id;
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
}
