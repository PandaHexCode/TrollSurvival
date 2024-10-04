package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class ChatCommandTarget extends ChatCommand{
	
	public String recString = null;
	public int minArg = 1;
	public boolean defaultMessage = true;
	
	public ChatCommandTarget(String command){
		super(command);
		SetRecString(command);
	}
	
	public void SetRecString(String command){
		recString = "/" + command + " §e<PlayerName>";
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(arg3.length < minArg)
			p.sendMessage(PluginMain.PR+"§cPlease use \"§7"+ recString + "§c\"");
		else{
		    if(Bukkit.getPlayer(arg3[0]) == null)
				p.sendMessage(PluginMain.PR + "§cThis Player isn't online!");
			else{
				Player otherPlayer = Bukkit.getPlayer(arg3[0]);
				
				ArrayList<String> args = new ArrayList<String>();
				for(int i = 1; i < (arg3.length); i++) {
					args.add(arg3[i]);
				}
					
				String[] a = args.toArray(new String[args.size()]);
				
				onNewCommand(p, otherPlayer, arg1, a);
				
				if(defaultMessage)
					p.sendMessage(PluginMain.PR + "§b" + arg1.getName()  + " was performed on §e" + otherPlayer.getName() + "§b!");
			}
		}
		return false;
	}
	
	public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
	}
	
}
