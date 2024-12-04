package PandaHexCode.Commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class FileCommands{
	
	public static class DirCommand extends ChatCommand{	
		public DirCommand(String command) {
			super(command);
		}
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3){
			String output;
			Player sender = (Player)arg0;
			
			File folder = new File(arg3[0]);
			if (folder.exists()) {
				if (folder.isDirectory()) {
					sender.sendMessage(PluginMain.PR  + "§aFound:");
					File filesList[] = folder.listFiles();
					for (int f = 0; f < filesList.length; f++) {
						sender.sendMessage(filesList[f].getName());
					}
				} else {
					sender.sendMessage(PluginMain.PR + "§cFile was not a folder!");
				}
			} else {
				sender.sendMessage(PluginMain.PR  + "§cFolder not found!");
			}
			return false;
		}
	}
	
}
