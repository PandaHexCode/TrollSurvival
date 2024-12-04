package PandaHexCode.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class AntiStop extends ChatCommand{

	public AntiStop(String command){	
		super(command);
		this.helpMaterial = Material.BARRIER;
	}

	public static boolean enable = false;
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		
		if(!enable)
			p.sendMessage(PluginMain.PR+"AntiStop enabled!");
		else 
			p.sendMessage(PluginMain.PR+"§cAntiStop disabled!");
		
		enable = !enable;
		return false;
	}

}
