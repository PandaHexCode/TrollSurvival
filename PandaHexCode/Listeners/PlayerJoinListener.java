package PandaHexCode.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import PandaHexCode.PluginMain;
import PandaHexCode.Commands.*;

public class PlayerJoinListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if(Vanish.playersInVanish.contains(pl.getName()))
				e.getPlayer().hidePlayer(pl);
		}
		
		if(PluginMain.trollers.contains(e.getPlayer().getName()))
			e.getPlayer().sendMessage(PluginMain.PR+"You can use ChatCommands on this Server! §4§l:D");
	}
}
