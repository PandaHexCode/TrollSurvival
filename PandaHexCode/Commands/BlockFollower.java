package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class BlockFollower extends ChatCommand{

	public BlockFollower(String command) {
		super(command);
		this.helpMaterial = Material.DIRT;
	}

	public static boolean isIn = false;
	public static Player targetPlayer = null;
	public static Player placePlayer = null;
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		
		if(!isIn) {
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use /blockfollower <Player>");
			else {
			    if(Bukkit.getPlayer(arg3[0]) == null)
					p.sendMessage(PluginMain.PR+"§cThis Player is not online!");
				else {
					isIn = true;
					p.sendMessage(PluginMain.PR+"All blocks that you place follow §e"+Bukkit.getPlayer(arg3[0]).getName()+"§2!");
					placePlayer = p;
					targetPlayer = Bukkit.getPlayer(arg3[0]);
					}
				}
			}
		else {
			isIn = false;
			p.sendMessage(PluginMain.PR+"§bSuccessful stopped all followed Blocks!");
		}
		return false;
	}

}
