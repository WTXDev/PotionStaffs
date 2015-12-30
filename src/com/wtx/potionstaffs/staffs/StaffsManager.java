package com.wtx.potionstaffs.staffs;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.wtx.potionstaffs.PotionStaff;

import net.md_5.bungee.api.ChatColor;

public class StaffsManager {
	
	private ArrayList<PotionStaff> staffsList = new ArrayList<PotionStaff>();
	
	public ArrayList<PotionStaff> getStaffsList()
	{
		return this.staffsList;
	}
	
	public StaffsManager(Plugin plugin)
	{
		staffsList.add(new SpeedStaff());
	}
	
	public PotionStaff getStaff(ItemStack item)
	{
		for (PotionStaff staff : this.getStaffsList())
		{
			if (staff.getName() == item.getItemMeta().getDisplayName())
			{
				return staff;
			}
		}
		
		return null;
	}
	
	public boolean isStaff(ItemStack item)
	{
		return item.getItemMeta().getLore().contains(ChatColor.GREEN + "Potion Staff");		
	}

}
