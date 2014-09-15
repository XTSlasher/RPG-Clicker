package net.slasher.rpgclicker;

import org.jnbt.IntTag;
import org.jnbt.StringTag;

public class Variables {
	public static StringTag playerName;
	public static IntTag money; 
	public static IntTag health; 
	public static IntTag maxHealth; 
	public static IntTag attack; 
	public static IntTag defence; 
	public static IntTag characters; 
	public static IntTag experience; 
	public static IntTag maxExp; 
	public static IntTag level;
	public static IntTag[] potions = new IntTag[100];
	public static IntTag[] weapons = new IntTag[100];
	public static IntTag[] armours = new IntTag[100];
	
	public static void showVariables() {
		System.out.println(playerName);
		System.out.println(money);
		System.out.println(health);
		System.out.println(maxHealth);
		System.out.println(attack);
		System.out.println(defence);
		System.out.println(characters);
		System.out.println(experience);
		System.out.println(maxExp);
		System.out.println(level);
	}
	
	public static void setVariables() {
		System.out.println("Setting Player Data!");
		
		Menu.plr = new User(playerName.getValue(), money.getValue().intValue(), health.getValue().intValue(), maxHealth.getValue().intValue(), attack.getValue().intValue(), defence.getValue().intValue(), characters.getValue().intValue(), experience.getValue().intValue(), maxExp.getValue().intValue(), level.getValue().intValue(), false);
	}
	
	public static void updateVariables() {
		Variables.playerName = new StringTag("PlayerName", Player.getName());
		Variables.money = new IntTag("PlayerCash", Player.getMoney());
		Variables.health = new IntTag("PlayerHP", Player.getHealth());
		Variables.maxHealth = new IntTag("PlayerMHP", Player.getMaxHealth());
		Variables.attack = new IntTag("PlayerATK", Player.getAtk());
		Variables.defence = new IntTag("PlayerDEF", Player.getDef());
		Variables.characters = new IntTag("PlayerChars", Player.getChars());
		Variables.experience = new IntTag("PlayerXP", Player.getExp());
		Variables.maxExp = new IntTag("PlayerMXP", Player.getMaxExp());
		Variables.level = new IntTag("PlayerLvl", Player.getLvl());
	}
}
