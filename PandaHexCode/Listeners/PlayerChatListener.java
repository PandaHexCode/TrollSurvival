package PandaHexCode.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import PandaHexCode.PluginMain;
import PandaHexCode.Commands.StandartArrayCommands;

import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class PlayerChatListener implements Listener{
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		if(StandartArrayCommands.mute.targetPlayers.contains(e.getPlayer().getName())){
			e.setCancelled(true);
			PluginMain.SendMessageToAllTrollers("§7[§4§lMutedPlayer§7] §e"+e.getPlayer().getName()+" §c> §e"+e.getMessage());
		}
	}
	
}
