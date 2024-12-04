package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class Radius{

	public static class BlockRadius extends ChatCommandTarget{
		public BlockRadius(String command){
			super(command);
			recString = "/" + command + " §e<PlayerName> <BlockName>";
			minArg = 2;
			this.helpMaterial = Material.TNT;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Material mat = PluginMain.GetMaterialByName(arg[0]);
			if(mat == null){
				sender.sendMessage(PluginMain.PR+"§cNot found a Material with the Name §e"+ arg[0]+ "§c!");
				return;
			}
			ArrayList<Location> locs = PluginMain.GetLocationsInRadius(otherPlayer.getLocation(), 5, false, false);
			for(int i = 0; i < locs.size(); i++){
				if(locs.get(i).getBlock().getType() != Material.AIR)
					locs.get(i).getBlock().setType(mat);
			}
		}

	}

}
