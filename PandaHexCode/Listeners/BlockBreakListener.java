package PandaHexCode.Listeners;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import PandaHexCode.PluginMain;
import PandaHexCode.Commands.*;

public class BlockBreakListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDestroy(BlockBreakEvent e){
		Player p = e.getPlayer();
		Location loc = e.getBlock().getLocation();
		Material mat = e.getBlock().getType();
		
		if(StandartArrayCommands.disablebreak.targetPlayers.contains(p.getName()))
			e.setCancelled(true);
		
		if(StandartArrayCommands.explosionbreak.targetPlayers.contains(p.getName()))
			p.getWorld().createExplosion(loc, 2);
		
		if(StandartArrayCommands.ultrabreak.targetPlayers.contains(p.getName())){
			ArrayList<Location> locations = PluginMain.GetLocationsInRadius(loc, 5 , false,true);
			for(int i = 0; i < locations.size(); i++) {
				if(locations.get(i).getBlock().getType() == mat)
					locations.get(i).getBlock().breakNaturally(p.getItemInHand());
			}
		}
		
		/*BlockBreakVector*/
		BlockBreakOffset.TargetPlayer target = BlockBreakOffset.GetTargetPlayerWithName(p.getName());
		if(target != null) {
			Location loc2 = loc;
			loc2.add(target.vt);
			loc2.getBlock().breakNaturally(p.getItemInHand());
			e.setCancelled(true);
		}
		/**/
		
		if(StandartArrayCommands.limitedcreative.targetPlayers.contains(p.getName())){
			if(mat == Material.BARRIER | mat == Material.BEDROCK)
				e.setCancelled(true);
		}
	}
	
}