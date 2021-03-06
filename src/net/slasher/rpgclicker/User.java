package net.slasher.rpgclicker;

import org.jnbt.IntTag;
import org.jnbt.StringTag;

public class User extends Player {

	public User(String name, int cash, int hp, int mhp, int atk, int def, int chars, int xp, int mxp, int lvl, boolean isNew) {
		super(name, cash, hp, mhp, atk, def, chars, xp, mxp, lvl, isNew);
		
		Variables.playerName = new StringTag("PlayerName", name);
		Variables.money = new IntTag("PlayerCash", cash);
		Variables.health = new IntTag("PlayerHP", hp);
		Variables.maxHealth = new IntTag("PlayerMHP", hp);
		Variables.attack = new IntTag("PlayerATK", atk);
		Variables.defence = new IntTag("PlayerDEF", def);
		Variables.characters = new IntTag("PlayerChars", chars);
		Variables.experience = new IntTag("PlayerXP", xp);
		Variables.maxExp = new IntTag("PlayerMXP", xp);
		Variables.level = new IntTag("PlayerLvl", lvl);
	}

}