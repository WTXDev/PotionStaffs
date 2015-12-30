package com.wtx.potionstaffs.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.wtx.potionstaffs.Invoke;
import com.wtx.potionstaffs.PotionStaff;
import com.wtx.potionstaffs.exceptions.InvalidStaffException;

import net.md_5.bungee.api.ChatColor;

public class PotionStaffListener implements Listener {
	
	public void givePlayerPotionEffect(Player player, PotionEffectType potion, int duration, int level)
    {
        player.addPotionEffect(new PotionEffect(potion, duration, level));
    }
	
	
	
	@EventHandler
	public void onPlayerInteraction(final PlayerInteractEvent event)
	{
		final Action action = event.getAction();
		final Player player = event.getPlayer();
		
		if (action != Action.RIGHT_CLICK_AIR)
		{
			return;
		}
		
		if (!(event.getPlayer().isSneaking()))
		{
			return;
		}
		
		ItemStack inHand = event.getItem();
		
		if (Invoke.getInstance().getStaffsManager().isStaff(inHand))
		{
			PotionStaff staff = null;
			
			try {
				
				staff = Invoke.getInstance().getStaffsManager().getStaff(inHand);
				
				if (staff != null)
				{
					
					int uses = staff.getUsesLeft() - 1;
					
					if (staff.getUsesLeft() == 0)
					{
						Invoke.sendPluginMessage("This staff has no uses left!", player);
						return;
					}
					
					this.givePlayerPotionEffect(player, staff.getEffect(), 1200, 1);
					Invoke.sendPluginMessage("You have used a " + ChatColor.AQUA + staff.getName() + ChatColor.GOLD + ". It has " + ChatColor.AQUA + staff.getUsesLeft() + ChatColor.GOLD + " uses left", player);
					staff.setUsesLeft(uses);
					staff.UpdateLore();
				}
				else
				{
					throw new InvalidStaffException();
				}
				
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}

}
