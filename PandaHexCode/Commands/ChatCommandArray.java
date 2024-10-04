package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class ChatCommandArray extends ChatCommandTarget{

	public ArrayList<String> targetPlayers = new ArrayList<String>();
	
	public ChatCommandArray(String command){
		super(command);
		defaultMessage = false;
	}
	
	@Override
	public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
		if(targetPlayers.contains(otherPlayer.getName())) {
			targetPlayers.remove(otherPlayer.getName());
			sender.sendMessage(PluginMain.PR+"§e" + otherPlayer.getName() + " §bis no longer in the " + command.getName() + " array!");
		}else{
			targetPlayers.add(otherPlayer.getName());
			sender.sendMessage(PluginMain.PR+"§e" + otherPlayer.getName() + "§2 is now in the " + command.getName() + " array!");
		}
	}

}
