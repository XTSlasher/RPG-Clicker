package net.slasher.rpgclicker;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.jnbt.IntTag;
import org.jnbt.NBTOutputStream;

public class Save {
	public static void save() throws Exception{
		String playerPath = "saves/";
		if(!new File(playerPath).exists()) new File(playerPath).mkdirs();
		
		NBTOutputStream out = new NBTOutputStream(new FileOutputStream(new File(playerPath + "player.dat")));
		out.writeTag(Variables.playerName);
		out.writeTag(Variables.money);
		out.writeTag(Variables.health);
		out.writeTag(Variables.maxHealth); 
		out.writeTag(Variables.attack); 
		out.writeTag(Variables.defence); 
		out.writeTag(Variables.characters); 
		out.writeTag(Variables.experience); 
		out.writeTag(Variables.maxExp); 
		out.writeTag(Variables.level);
		
		for(int i=0;i<Variables.potions.length;i++) {
			IntTag current = Variables.potions[i];
			
			if(current != null) {
				System.out.println(current);
				out.writeTag(current);
			}
		}
		
		for(int i=0;i<Variables.weapons.length;i++) {
			IntTag current = Variables.weapons[i];
			
			if(current != null) {
				System.out.println(current);
				out.writeTag(current);
			}
		}
		out.close();
		
		JOptionPane.showMessageDialog(null, "Save Complete!");
	}
}
