package PandaHexCode.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import PandaHexCode.Commands.StandartArrayCommands;

@SuppressWarnings("deprecation")
public class PlayerPickupItemListener implements Listener{
	
	@EventHandler
	public void onPlayerPickUp(PlayerPickupItemEvent e) {
		if(StandartArrayCommands.disablepickup.targetPlayers.contains(e.getPlayer().getName()))
			e.setCancelled(true);
	}
	
}

