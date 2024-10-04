package PandaHexCode.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import PandaHexCode.Commands.*;

public class EntityDamageByEntityListener implements Listener{
	
	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent e) {
		 if(e.getDamager() instanceof Player){
			   Player p = (Player) e.getDamager();
			   if(StandartArrayCommands.nulldamage.targetPlayers.contains(p.getName()))
				   e.setDamage(0);
			   else if(StandartArrayCommands.instantkillmobs.targetPlayers.contains(p.getName()))
				   e.setDamage(10000);
		 }
		 
		 if(e.getEntity() instanceof Player ) {
				Player p = (Player)e.getEntity();
				if(StandartArrayCommands.ultraknockback.targetPlayers.contains(p.getName()))
					p.setVelocity(new Vector(100,100,100));
		 }
	}
	
}
