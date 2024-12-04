package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class BlockPlaceOffset extends ChatCommand{

	public BlockPlaceOffset(String command) {
		super(command);
		this.helpMaterial = Material.GRASS_BLOCK;
	}

	public static ArrayList<TargetPlayer> targetPlayers = new ArrayList<TargetPlayer>();
	
	public static class TargetPlayer{
		public String playerName;
		public Vector vt;
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(arg3.length < 4)
			p.sendMessage(PluginMain.PR+"§cPlease use /blockplaceoffset <Player> <X> <Y> <Z>");
		else {
			if(Bukkit.getPlayer(arg3[0]) == null)
				p.sendMessage(PluginMain.PR+"§cThis Player is not online!");
			else {
				float x = Float.parseFloat(arg3[1]);
				float y = Float.parseFloat(arg3[2]);
				float z = Float.parseFloat(arg3[3]);
				if(x == 0 && y == 0 && z == 0) {
					if(targetPlayers.contains(GetTargetPlayerWithName(arg3[0]))) {
						targetPlayers.remove(GetTargetPlayerWithName(arg3[0]));
						p.sendMessage(PluginMain.PR+"§e"+arg3[0]+" §bcan now place normal again!");
					}else
						p.sendMessage(PluginMain.PR+"§cNothing changed offset 0 0 0 is standart!");
					
					return false;
				}
				
				if(targetPlayers.contains(GetTargetPlayerWithName(arg3[0]))) {
					GetTargetPlayerWithName(arg3[0]).vt = new Vector(x,y,z);
					p.sendMessage(PluginMain.PR+arg3[0]+" Changed offset (If you want standart use 0 0 0)!");
				}
				else {
					TargetPlayer target = new TargetPlayer();
					target.vt = new Vector(x,y,z);
					target.playerName = arg3[0];
					
					targetPlayers.add(target);
					p.sendMessage(PluginMain.PR+"§e"+arg3[0]+"§2 can now only place Blocks with offset haha!");
				}
			}
		}
		return false;
	}
	
	public static TargetPlayer GetTargetPlayerWithName(String name) {
		for(int i = 0; i < targetPlayers.size() ; i++) {
			if(targetPlayers.get(i).playerName.contains(name))
				return targetPlayers.get(i);
		}
		
		return null;
	}

}
