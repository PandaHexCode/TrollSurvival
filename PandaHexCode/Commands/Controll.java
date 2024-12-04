package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class Controll extends ChatCommand{

	public Controll(String command) {
		super(command);
		this.helpMaterial = Material.PLAYER_HEAD;
	}

	public static boolean isInSpam = false;
	public static Player targetPlayer = null;
	public static Player spamPlayer = null;
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		
		if(!isInSpam) {
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /controll <Player>");
			else {
			    if(Bukkit.getPlayer(arg3[0]) == null)
					p.sendMessage(PluginMain.PR+"§cThis Player is not online!");
				else {
					isInSpam = true;
					p.sendMessage(PluginMain.PR+"Successful started Controll!");
					spamPlayer = p;
					targetPlayer = Bukkit.getPlayer(arg3[0]);
					}
				}
			}
		else {
			isInSpam = false;
			p.sendMessage(PluginMain.PR+"§bSuccessful stopped Controll!");
		}
		return false;
	}

}
