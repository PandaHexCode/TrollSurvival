package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import PandaHexCode.PluginMain;

public class StandartCommands{
	
	public static class Heal extends ChatCommandTarget{	
		public Heal(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.setHealth(20);
		}
	}
	
	public static class SetLevel extends ChatCommandTarget{	
		public SetLevel(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <Level>";
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			float level = Float.parseFloat(arg[0]);
			otherPlayer.setLevel((int)level);
		}
	}
	
	public static class Tp extends ChatCommandTarget{	
		public Tp(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			sender.teleport(otherPlayer.getLocation());
		}
	}
	
	public static class Tphere extends ChatCommandTarget{	
		public Tphere(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.teleport(sender.getLocation());
		}
	}
	
	public static class Op extends ChatCommandTarget{	
		public Op(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.setOp(true);
		}
	}
	
	public static class DeOp extends ChatCommandTarget{	
		public DeOp(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.setOp(false);
		}
	}
	
	public static class PInfo extends ChatCommandTarget{	
		public PInfo(String command) {
			super(command);
			defaultMessage = false;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Player oPlayer = otherPlayer;
			sender.sendMessage(PluginMain.PR+"Heaths: "+oPlayer.getHealth()+"/"+oPlayer.getHealthScale()+""
					+ "\n"+PluginMain.PR+"WalkSpeed: "+oPlayer.getWalkSpeed()
					+ "\n"+PluginMain.PR+"Level: "+oPlayer.getLevel() +
					"\n"+PluginMain.PR+"IsOp: "+oPlayer.isOp());
		}
	}
	
	public static class Reload extends ChatCommandTarget{	
		public Reload(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Bukkit.reload();
		}
	}
	
	public static class Title extends ChatCommandTarget{	
		public Title(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <Title>";
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			String msg = "";
			for(int i = 0; i < arg.length; i++)
				msg = msg + arg[i] + " ";
			msg = msg.replace("&", "§");
			otherPlayer.sendTitle(msg, "",10,50,10);
		}
	}
	
	public static class Rename extends ChatCommand{	
		public Rename(String command) {
			super(command);
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3){
			Player p = (Player) arg0;
			
			String finalMessage = "";
			for(int i = 0;i< arg3.length;i++) {
				finalMessage = finalMessage+arg3[i]+" ";
			}
			
			finalMessage = finalMessage.replaceAll("&", "§");
			ItemMeta newMeta = p.getInventory().getItemInMainHand().getItemMeta();
			newMeta.setDisplayName(finalMessage);
			p.getInventory().getItemInMainHand().setItemMeta(newMeta);
			p.sendMessage(PluginMain.PR+"Successful renamed Item to §e"+finalMessage+"§2!");
			
			return false;
		}
	}
	
	public static class Gamemode extends ChatCommand{

		public Gamemode(String command) {
			super(command);
			
		}

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			if(arg3.length < 1) {
				p.sendMessage(PluginMain.PR+"§cPlease use !gamemode <0|1|2|3> <OptionalPlayer>");
			}
			else {
				Player target = p;
				if(arg3.length > 1) {
					  if(Bukkit.getPlayer(arg3[1]) == null) {
						  p.sendMessage(PluginMain.PR+"§cThis Player is not online!");
						  return true;
					  }else
						  target = Bukkit.getPlayer(arg3[1]);
				}
				GameMode gm = GameMode.SURVIVAL;
				switch(arg3[0]) {
					case "1":
						gm = GameMode.CREATIVE;
						break;
					case "2":
						gm = GameMode.ADVENTURE;
						break;
					case "3":
						gm = GameMode.SPECTATOR;
						break;
				}
				
				target.setGameMode(gm);
				if(arg3.length > 1)
					p.sendMessage(PluginMain.PR+"Successful changed §e"+arg3[1]+"§2 Gamemode!");
				else
					p.sendMessage(PluginMain.PR+"Successful changed to §6"+gm.name()+"§2!");
			}
			return false;
		}

	}

	
}
