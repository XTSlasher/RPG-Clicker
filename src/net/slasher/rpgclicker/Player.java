package net.slasher.rpgclicker;

public abstract class Player {
	/** Player Stats **/
	public static int money, health, maxHealth, attack, defence, characters, experience, maxExp, level;
	
	/** Player Name **/
	public static String pName;
	
	public Player(String name, int cash, int hp, int atk, int def, int chars, int xp, int lvl) {
		pName = name;
		money = cash;
		maxHealth = hp;
		health = maxHealth;
		attack = atk;
		defence = def;
		characters = chars;
		experience = xp;
		maxExp = ((level*10)+(5*level)*level^2)+1;
		level = lvl;
	}
	
	public static void levelUp() {
		experience -= maxExp;
		level += 1;
		
		setMaxHealth();

		health = maxHealth;
		
		setMaxExp();
	}
	
	public static void addExp(int plus) {
		experience += plus;
		
		if(experience >= maxExp) {
			levelUp();
		}
	}
	
	public static String getName() {
		return pName;
	}
	
	public static int getMoney() {
		return money;
	}
	
	public static int getHealth() {
		return health;
	}
	
	public static void setMaxHealth() {
		maxHealth = ((level*10)+(3*level)*100);
	}
	
	public static int getMaxHealth() {
		return maxHealth;
	}
	
	public static int getAtk() {
		return attack;
	}
	
	public static int getDef() {
		return defence;
	}
	
	public static int getChars() {
		return characters;
	}
	
	public static int getExp() {
		return experience;
	}
	
	public static void setMaxExp() {
		maxExp = ((level*10)+(5*level)*level^2)+1;
	}
	
	public static int getMaxExp() {
		return maxExp;
	}
	
	public static int getLvl() {
		return level;
	}
}
