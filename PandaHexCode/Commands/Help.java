package PandaHexCode.Commands;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PandaHexCode.PluginMain;

public class Help extends ChatCommand{

	private static int commandsProSite = 5;
	
	public Help(String command) {
		super(command);
		
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(arg3.length < 1)
			p.sendMessage(PluginMain.PR+"§cPlease use /help <Site(1|2...)>");
		else {
			int site = Integer.parseInt(arg3[0]);
			int normalSite = site;
			site = site-1;
			for(int i = 0;i< 5;i++) {
				p.sendMessage("");
			}
			
			ArrayList<String> commands = (ArrayList<String>) ChatCommand.allCommands.clone();
			Collections.sort(commands);
			int maxSite = commands.size() / commandsProSite +1;
			if(normalSite == 0 | normalSite > maxSite) {
				p.sendMessage(PluginMain.PR+"§cThis Site not exits!");
				return true;
			}
			
			p.sendMessage(PluginMain.PR+"§bHelp Site §2"+normalSite+"/"+maxSite);
			
			String commandSymbol = "/";
			if(PluginMain.ISGRIEFVERSION)
				commandSymbol = "!";
			
			int beginValue = commandsProSite * site;
			for(int i = beginValue; i < beginValue+commandsProSite ; i++) {
				if(i < commands.size())
					p.sendMessage(PluginMain.PR+commandSymbol+commands.get(i));
			}
		}
		return false;
	}

}
