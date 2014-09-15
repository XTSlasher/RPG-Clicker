package net.slasher.rpgclicker;

public abstract class Player {
	/** Player Stats **/
	public static int money, health, maxHealth, attack, defence, characters, experience, maxExp, level;
	
	/** Player Name **/
	public static String pName;
	
	public Player(String name, int cash, int hp, int mhp, int atk, int def, int chars, int xp, int mxp, int lvl, boolean isNew) {
		pName = name;
		money = cash;
		if(mhp == 0) {
			maxHealth = 10;
		} else {
			maxHealth = mhp;
		}
		if(hp == 0) {
			health = maxHealth;
		} else {
			health = hp;
		}
		attack = atk;
		defence = def;
		characters = chars;
		experience = xp;
		if(mxp == 0) {
			maxExp = ((level*10)+(5*level)*level^2)+1;
		} else {
			maxExp = mxp;
		}
		level = lvl;
		
		if(isNew) {
			Inventory.initInventoryNew();
		} else {
			Inventory.initInventoryLoad();
		}
	}
	
	public static void calcAtk() {
		for(int i=0;i<Inventory.weapons.size();i++) {
			int count = Inventory.weapons.get(Database_Shop.weapons[i]);
			int totalAtk = Database_Shop.weapons[i].getATK() * count;
			
			attack += totalAtk;
			
			System.out.println("Attack: " + attack);
		}
	}
	
	public static void levelUp() {
		experience -= maxExp;
		level += 1;
		
		setMaxHealth();

		health = maxHealth;
		
		setMaxExp();
	}
	
	public static void addExp(int gain) {
		experience += gain;
		
		if(experience >= maxExp) {
			levelUp();
		}
	}
	
	public static void addMoney(int plus) {
		money += plus;
	}
	
	public static void loseMoney(int lose) {
		money -= lose;
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
