package PandaHexCode.Listeners;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;
import PandaHexCode.Commands.Controll;
import PandaHexCode.Commands.StandartArrayCommands;

public class PlayerMoveListener implements Listener{
	
	public static ArrayList<String> wasBoostedPlayers = new ArrayList<String>();

	int i = 0;
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player player = e.getPlayer();
		
		if(StandartArrayCommands.autojump.targetPlayers.contains(player.getName()) && player.isOnGround()){
			Vector vt = player.getVelocity();
			vt.setY(0.5f);
			player.setVelocity(vt);
		}
		
		if(StandartArrayCommands.movelag.targetPlayers.contains(player.getName()) && (e.getTo().getX() != e.getFrom().getX() | e.getTo().getY() != e.getFrom().getY() | e.getTo().getZ() != e.getFrom().getZ())){
			i++;
			if(i % 2 == 0)
				player = player;
			else{
				Location newTo2 = e.getTo().clone();
				newTo2.setX(e.getFrom().getX());
				newTo2.setY(e.getFrom().getY());
				newTo2.setZ(e.getFrom().getZ());
				e.setTo(newTo2);
			}
		}
		
		if(StandartArrayCommands.disablegravity.targetPlayers.contains(player.getName()))
			player.setGravity(false);
		else 
			player.setGravity(true);
		
		if(StandartArrayCommands.glide.targetPlayers.contains(player.getName()))
			player.setGliding(true);
		
		if(StandartArrayCommands.freeze.targetPlayers.contains(player.getName())){
			Location newTo = e.getTo().clone();
			newTo.setX(e.getFrom().getX());
			newTo.setY(e.getFrom().getY());
			newTo.setZ(e.getFrom().getZ());
			e.setTo(newTo);
		}
		
		if(StandartArrayCommands.freezeRotation.targetPlayers.contains(player.getName())){
			Location newTo = e.getTo().clone();
			newTo.setYaw(e.getFrom().getYaw());
			newTo.setPitch(e.getFrom().getPitch());
			e.setTo(newTo);
		}
		
		/*Controll Player*/
		if(Controll.isInSpam && player == Controll.spamPlayer)
			Controll.targetPlayer.teleport(Controll.spamPlayer.getLocation());
		/**/
		
		/*Super Jump Boost*/
		if(StandartArrayCommands.superjumpboost.targetPlayers.contains(player.getName()) && player.getVelocity().getY() >= 0 && !player.isOnGround() && !wasBoostedPlayers.contains(player.getName())) {
			Vector vt = player.getVelocity();
			vt.setY(vt.getY()+0.7f);
			player.setVelocity(vt);
			wasBoostedPlayers.add(player.getName());
		}else if(player.isOnGround() && wasBoostedPlayers.contains(player.getName()))
				wasBoostedPlayers.remove(player.getName());
		/**/
		
		if(StandartArrayCommands.dirtterrain.targetPlayers.contains(player.getName())) {
			ArrayList<Location> locs = PluginMain.GetLocationsInRadius(player.getLocation(), 5, false, false);
			for(int i = 0; i < locs.size(); i++){
				if(locs.get(i).getBlock().getType() != Material.AIR)
					locs.get(i).getBlock().setType(Material.DIRT);
			}
		}
	}
	
}