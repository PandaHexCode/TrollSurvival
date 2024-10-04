package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;
import PandaHexCode.Listeners.PlayerDeathListener;

public class DeathManager {
	
	public static class Receive extends ChatCommand{

		public Receive(String command) {
			super(command);
			
		}

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /receive <Number>");
			else {
				int number = 0;
				number = Integer.parseInt(arg3[0]);
				if(PlayerDeathListener.deaths.size() < number) {
					p.sendMessage(PluginMain.PR+"§cDeath not found!");
					return false;
				}
				
				PlayerDeathListener.Death death = PlayerDeathListener.deaths.get(number);
				death.Receive(false);
				p.sendMessage(PluginMain.PR+"Successfuly received §e" + death.player.getName() + "§2!");
				
			}
			return false;
		}

	}
	
	public static class DeathData extends ChatCommand{

		public DeathData(String command) {
			super(command);
			
		}

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /deathdata <Number>");
			else {
				int number = 0;
				number = Integer.parseInt(arg3[0]);
				if(PlayerDeathListener.deaths.size() < number) {
					p.sendMessage(PluginMain.PR+"§cDeath not found!");
					return false;
				}
				
				PlayerDeathListener.Death death = PlayerDeathListener.deaths.get(number);
				p.sendMessage(PluginMain.PR+"PlayerName: §e" + death.player.getName() + "\n§2Location: §e" + death.loc.toVector() + "\n§2Time: §e" + death.time);
				
			}
			return false;
		}

	}
	
	
}

