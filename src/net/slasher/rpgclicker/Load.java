package net.slasher.rpgclicker;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jnbt.IntTag;
import org.jnbt.NBTInputStream;
import org.jnbt.StringTag;
import org.jnbt.Tag;

public class Load {
	public static boolean checkIfSave() {
		String playerPath = "saves/";
		boolean fileFound = new File(playerPath + "player.dat").exists();
		
		if(fileFound) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void load() {
		System.out.println("Starting Load!");
		
		loadPlayer();
		loadPotions();
		loadWeapons();
		loadArmours();
		Variables.setVariables();
		
		JOptionPane.showMessageDialog(null, "Loading Completed!");
	}
	
	public static void loadPlayer() {
		String playerPath = "saves/";
		boolean fileFound = new File(playerPath + "player.dat").exists();
		
		if(!fileFound) { return; }
		
		NBTInputStream in = null;
		try {
			in = new NBTInputStream(new FileInputStream(new File("saves/player.dat")));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			try {
				Tag tag;
				while((tag = in.readTag()) != null) {
					tags.add(tag);
				}
				in.close();
			} catch(Exception e) {}
			
			Variables.playerName = (StringTag) getTag(tags, "PlayerName");
			Variables.money = (IntTag) getTag(tags, "PlayerCash");
			Variables.health = (IntTag) getTag(tags, "PlayerHP");
			Variables.maxHealth = (IntTag) getTag(tags, "PlayerMHP");
			Variables.attack = (IntTag) getTag(tags, "PlayerATK");
			Variables.defence = (IntTag) getTag(tags, "PlayerDEF");
			Variables.characters = (IntTag) getTag(tags, "PlayerChars");
			Variables.experience = (IntTag) getTag(tags, "PlayerXP");
			Variables.maxExp = (IntTag) getTag(tags, "PlayerMXP");
			Variables.level = (IntTag) getTag(tags, "PlayerLvl");
			
		} catch(Exception e) {}
		
	}
	
	public static void loadPotions() {
		String playerPath = "saves/";
		boolean fileFound = new File(playerPath + "potions.dat").exists();
		
		if(!fileFound) { return; }
		
		NBTInputStream in = null;
		try {
			in = new NBTInputStream(new FileInputStream(new File("saves/potions.dat")));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			try {
				Tag tag;
				while((tag = in.readTag()) != null) {
					tags.add(tag);
				}
				in.close();
			} catch(Exception e) {}
			
			for(int i=0;i<Database_Shop.potions.length;i++) {
				IntTag loadingTag = (IntTag) getTag(tags, Database_Shop.potions[i].name);
				Inventory.potions.put(Database_Shop.potionList.get(i), loadingTag.getValue());
			}
		} catch(Exception e) {}
		
	}
	
	public static void loadWeapons() {
		String playerPath = "saves/";
		boolean fileFound = new File(playerPath + "weapons.dat").exists();
		
		if(!fileFound) { return; }
		
		NBTInputStream in = null;
		try {
			in = new NBTInputStream(new FileInputStream(new File("saves/weapons.dat")));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			try {
				Tag tag;
				while((tag = in.readTag()) != null) {
					tags.add(tag);
				}
				in.close();
			} catch(Exception e) {}
			
			for(int i=0;i<Database_Shop.weapons.length;i++) {		
				IntTag loadingTag = (IntTag) getTag(tags, Database_Shop.weapons[i].name);
				Inventory.weapons.put(Database_Shop.weaponList.get(i), loadingTag.getValue());
			}
		} catch(Exception e) {}
		
	}
	
	public static void loadArmours() {
		String playerPath = "saves/";
		boolean fileFound = new File(playerPath + "armours.dat").exists();
		
		if(!fileFound) { return; }
		
		NBTInputStream in = null;
		try {
			in = new NBTInputStream(new FileInputStream(new File("saves/armours.dat")));
			ArrayList<Tag> tags = new ArrayList<Tag>();
			
			try {
				Tag tag;
				while((tag = in.readTag()) != null) {
					tags.add(tag);
				}
				in.close();
			} catch(Exception e) {}
			
			for(int i=0;i<Database_Shop.armours.length;i++) {		
				IntTag loadingTag = (IntTag) getTag(tags, Database_Shop.armours[i].name);
				Inventory.armours.put(Database_Shop.armourList.get(i), loadingTag.getValue());
			}
		} catch(Exception e) {}
		
	}
	
	public static Tag getTag(ArrayList<Tag> tags, String str) {
		for(Tag tag:tags) {
			if(tag.getName().equals(str)) {
				return tag;
			}
		}
		return null;
	}
}
