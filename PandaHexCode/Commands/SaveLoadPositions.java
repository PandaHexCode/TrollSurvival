package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class SaveLoadPositions {
	
	public static ArrayList<Pos> positions = new ArrayList<Pos>();
	
	public static class Pos{
		public String name;
		public Location loc;
	}
	
	public static Pos TryGetPos(String name) {
		for(int i = 0; i < positions.size(); i++) {
			if(positions.get(i).name.equalsIgnoreCase(name))
				return positions.get(i);
		}
		
		return null;
	}
	
	public static class SavePositionCmd extends ChatCommand{
		public SavePositionCmd(String command) {
			super(command);
			
		}
	
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /saveposition <PositionName>");
			else {
				String name = arg3[0];
				
				Pos pos = TryGetPos(name);
				if(pos != null) {
					pos.loc = p.getLocation();
					p.sendMessage(PluginMain.PR+"Position §e"+name+"§2 overwritted!");
				}else {
					pos = new Pos();
					pos.name = name;
					pos.loc = p.getLocation();
					positions.add(pos);
					p.sendMessage(PluginMain.PR+"New Position §e"+name+"§2 saved!");
				}
			}
			return false;
		}
		
	}
	
	public static class LoadPositionCmd extends ChatCommand{
		public LoadPositionCmd(String command) {
			super(command);
			
		}
	
		public static ArrayList<String> targetPlayers = new ArrayList<String>();
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /loadposition <PositionName>");
			else {
				String name = arg3[0];
				
				Pos pos = TryGetPos(name);
				if(pos == null)
					p.sendMessage(PluginMain.PR+"§cPosition §e"+name+" §cnot found!");
				else{
					p.teleport(pos.loc);
					p.sendMessage(PluginMain.PR+"Teleported to §e"+name+"§2!");
				}
			}
			return false;
		}
	}
	
	public static class DeletePositionCmd extends ChatCommand{
		public DeletePositionCmd(String command) {
			super(command);
			
		}
	
		public static ArrayList<String> targetPlayers = new ArrayList<String>();
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /deleteposition <PositionName>");
			else {
				String name = arg3[0];
				
				Pos pos = TryGetPos(name);
				if(pos == null)
					p.sendMessage(PluginMain.PR+"§cPosition §e"+name+" §cnot found!");
				else{
					positions.remove(pos);
					p.sendMessage(PluginMain.PR+"Deleted Position §e"+name+"§2!");
					
				}
			}
			return false;
		}
	}
	
	public static class ListPositionsCMD extends ChatCommand{
		public ListPositionsCMD(String command) {
			super(command);
			
		}
	
		public static ArrayList<String> targetPlayers = new ArrayList<String>();
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			String message = PluginMain.PR+"Saved Positions:§e ";
			
			for(int i = 0; i < positions.size(); i++) {
				message = message + positions.get(i).name+"§6,§e";
			}
			
			p.sendMessage(message);
			return false;
		}
	}

}
