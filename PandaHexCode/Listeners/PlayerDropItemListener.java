package PandaHexCode.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import PandaHexCode.Commands.*;

public class PlayerDropItemListener implements Listener{
	
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		if(StandartArrayCommands.disabledrop.targetPlayers.contains(e.getPlayer().getName()))
			e.setCancelled(true);
	}
}
