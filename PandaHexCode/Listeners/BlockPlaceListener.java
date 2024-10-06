package PandaHexCode.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import PandaHexCode.PluginMain;
import PandaHexCode.Commands.*;

public class BlockPlaceListener implements Listener{
	
	private Location loc = null;
	
	@EventHandler
	public void onPlayerBuild(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		loc = e.getBlock().getLocation();
		Material mat = e.getBlock().getType();
		
		if(StandartArrayCommands.disablebuild.targetPlayers.contains(p.getName()))
			e.setCancelled(true);
		
		/*BlockVector*/
		BlockPlaceOffset.TargetPlayer target = BlockPlaceOffset.GetTargetPlayerWithName(p.getName());
		if(target != null) {
			Location locc = loc;
			locc.add(target.vt.getX(),target.vt.getY(),target.vt.getZ());
			PluginMain.MoveBlockTo(e.getBlock(), locc, 1,false , "null");
		}
		/**/
		
		/*BlockFollower*/
		if(BlockFollower.isIn && p == BlockFollower.placePlayer)
				PluginMain.MoveBlockTo(e.getBlock(), BlockFollower.targetPlayer.getLocation(), 3,true , BlockFollower.targetPlayer.getName());
		/**/
		
		if(StandartArrayCommands.limitedcreative.targetPlayers.contains(p.getName())){
			if(mat == Material.TNT | mat == Material.LEGACY_TNT | mat == Material.FIRE
					| mat == Material.FIRE_CHARGE | mat == Material.BEDROCK)
				e.setCancelled(true);
		}
		
		if(StandartArrayCommands.clientSidePlaceArray.targetPlayers.contains(p.getName())){
			for(int i = 1; i < 5; i++){
				p.sendBlockChange(loc.add(0, 0, 1), mat.createBlockData());
			}
		}
	}
	
}