package com.wtx.potionstaffs.staffs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import com.wtx.potionstaffs.PotionStaff;

import net.md_5.bungee.api.ChatColor;

public class SpeedStaff extends PotionStaff {
	
	static PotionEffectType effect = PotionEffectType.SPEED;
	static Material material = Material.SUGAR;
	static List<String> lore = new ArrayList<String>();

	public SpeedStaff() {
		super(effect, material, 5, lore, ChatColor.WHITE + "Speed Staff");
	}
	
	public void SetLore()
	{		
		lore.add(ChatColor.BOLD + "Shift and right click to activate");
		lore.add(ChatColor.GREEN + "Potion Staff");
		lore.add(ChatColor.RED + "Uses Left: " + this.getUsesLeft());
	}
	
	public ShapelessRecipe getRecipe()
	{
		return new ShapelessRecipe(this.getStaff()).addIngredient(Material.SUGAR).addIngredient(Material.STICK);
	}
	
	public ItemStack getStaff()
	{
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(this.getName());
		meta.setLore(getLore());
		item.setItemMeta(meta);
		
		return item;
	}

	@Override
	public void UpdateLore() {
		SpeedStaff.lore.clear();
		this.SetLore();
	}

}
