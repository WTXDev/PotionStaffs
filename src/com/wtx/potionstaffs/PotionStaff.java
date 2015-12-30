package com.wtx.potionstaffs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.potion.PotionEffectType;

public abstract class PotionStaff {
	
	private PotionEffectType effect;
	private int usesLeft;
	private Material material;
	private List<String> lore = new ArrayList<String>();
	private String name;
	
	public PotionStaff(final PotionEffectType effect, Material material, int uses, List<String> lore, String name)
	{
		this.effect = effect;
		this.usesLeft = uses;
		this.material = material;
		this.name = name;
		this.lore = lore;
	}
	
	public abstract void SetLore();
	public abstract ShapelessRecipe getRecipe();
	public abstract ItemStack getStaff();
	public abstract void UpdateLore();
	
	public PotionEffectType getEffect() {
		return effect;
	}

	public Material getMaterial() {
		return material;
	}

	public int getUsesLeft() {
		return usesLeft;
	}

	public void setUsesLeft(int usesLeft) {
		this.usesLeft = usesLeft;
	}
	
	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEffect(PotionEffectType effect) {
		this.effect = effect;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}


}
