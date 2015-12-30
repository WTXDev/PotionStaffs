package com.wtx.potionstaffs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.wtx.potionstaffs.listeners.PotionStaffListener;
import com.wtx.potionstaffs.staffs.StaffsManager;

import net.md_5.bungee.api.ChatColor;

public class Invoke extends JavaPlugin {
	
	final PluginManager pluginManager = this.getServer().getPluginManager();
	
	private static Invoke instance;
	private Listener listener;
	private static StaffsManager staffs;
	private Logger logger;
	
	public final StaffsManager getStaffsManager()
	{
		return staffs;
	}
	
	public static final Invoke getInstance()
	{
		return instance;
	}
	
	public void registerStaffs()
	{
		for (PotionStaff ps : staffs.getStaffsList())
		{
			ps.SetLore();
			this.getServer().addRecipe(ps.getRecipe());
			logger.log(Level.INFO, "Successfully registered staff " + ps.getName());
		}
	}
	
	public static final void sendPluginMessage(final String txt, final Player player)
	{
		player.sendMessage(ChatColor.RED + "[" + ChatColor.GOLD + "PotionStaffs" + ChatColor.RED + "] " + txt);
	}
	
	@Override
	public void onEnable()
	{
		if (instance == null)
		{
			instance = this;
		}
		
		logger = Logger.getLogger("Minecraft");
		staffs = new StaffsManager(this);
		listener = new PotionStaffListener();
		this.pluginManager.registerEvents(listener, this.getInstance());
		this.registerStaffs();
	}
	
	@Override
	public void onDisable()
	{
		
	}

}
