package PandaHexCode.Listeners;


import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import PandaHexCode.PluginMain;

public class PlayerKickListener implements Listener{
	
	@EventHandler
	public void onLeave(PlayerKickEvent e) {
		Player p = e.getPlayer();
		if(PluginMain.trollers.contains(p.getName())) {
			p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
			p.sendMessage("\n"+PluginMain.PR+"§4§lSomeone has tried to kick/ban you!");
			p.sendMessage(PluginMain.PR+"§eReason: "+e.getReason());
			e.setCancelled(true);
		}
		
		if(e.getReason().contains("Flying is not enabled on this server"))
			e.setCancelled(true);	
	}
	
}
