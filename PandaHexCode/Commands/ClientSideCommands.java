package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class ClientSideCommands{

	public static class ClientSideBlock extends ChatCommandTarget{
		public ClientSideBlock(String command) {
			super(command);
			recString = "/" + command + " §e<PlayerName> <BlockName>";
			minArg = 2;
			defaultMessage = false;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Material mat = PluginMain.GetMaterialByName(arg[0]);
			if(mat == null){
				sender.sendMessage(PluginMain.PR+"§cNot found a Material with the Name §e"+ arg[0]+ "§c!");
				return;
			}
			otherPlayer.sendBlockChange(otherPlayer.getLocation(), mat.createBlockData());
			sender.sendMessage(PluginMain.PR+"Successfuly placed a ClientSideBlock, only the target Player can see it!");
		}

	}
	
	public static class ClientSideSchlong extends ChatCommandTarget{
		
		public ClientSideSchlong(String command) {
			super(command);
			defaultMessage = false;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Material mat = Material.PINK_WOOL;
			
			otherPlayer.sendBlockChange(otherPlayer.getLocation(), mat.createBlockData());
			otherPlayer.sendBlockChange(otherPlayer.getLocation().add(new Vector(1,0,0)), mat.createBlockData());
			otherPlayer.sendBlockChange(otherPlayer.getLocation().add(new Vector(-1,0,0)), mat.createBlockData());
			otherPlayer.sendBlockChange(otherPlayer.getLocation().add(new Vector(0,1,0)), mat.createBlockData());
			otherPlayer.sendBlockChange(otherPlayer.getLocation().add(new Vector(0,2,0)), mat.createBlockData());
			
			sender.sendMessage(PluginMain.PR+"Successfuly placed a ClientSideSchlong, only the target Player can see it!");
		}

	}
	
	public static class ClientSideBlockRadius extends ChatCommandTarget{
		public ClientSideBlockRadius(String command){
			super(command);
			recString = "/" + command + " §e<PlayerName> <BlockName>";
			minArg = 2;
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
					otherPlayer.sendBlockChange(locs.get(i), mat.createBlockData());
			}
		}

	}
	
}
