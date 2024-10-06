package PandaHexCode.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import PandaHexCode.PluginMain;

public class PlayerResourcePackStatusListener implements Listener{
	
	@EventHandler
	public void onChat(PlayerResourcePackStatusEvent e) {
		PluginMain.SendMessageToAllTrollers(PluginMain.PR + "§e" + e.getPlayer().getName() +" §3Resourcepack-Status: " + e.getStatus());
	}
	
}