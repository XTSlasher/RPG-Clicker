package net.slasher.rpgclicker;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.jnbt.IntTag;
import org.jnbt.NBTOutputStream;

public class Save {
	public static void save() throws Exception{
		Variables.updateVariables();
		
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
		out.close();
		
		NBTOutputStream out2 = new NBTOutputStream(new FileOutputStream(new File(playerPath + "potions.dat")));
		
		for(int i=0;i<Variables.potions.length;i++) {
			IntTag current = Variables.potions[i];
			
			if(current != null) {
				System.out.println("Saving: " + current);
				out2.writeTag(current);
			}
		}
		
		out2.close();
		
		NBTOutputStream out3 = new NBTOutputStream(new FileOutputStream(new File(playerPath + "weapons.dat")));
		
		for(int i=0;i<Variables.weapons.length;i++) {
			IntTag current = Variables.weapons[i];
			
			if(current != null) {
				System.out.println("Saving: " + current);
				out3.writeTag(current);
			}
		}
		out3.close();
		
		NBTOutputStream out4 = new NBTOutputStream(new FileOutputStream(new File(playerPath + "armours.dat")));
		
		for(int i=0;i<Variables.armours.length;i++) {
			IntTag current = Variables.armours[i];
			
			if(current != null) {
				System.out.println("Saving: " + current);
				out4.writeTag(current);
			}
		}
		out4.close();
		
		JOptionPane.showMessageDialog(null, "Save Complete!");
	}
}
